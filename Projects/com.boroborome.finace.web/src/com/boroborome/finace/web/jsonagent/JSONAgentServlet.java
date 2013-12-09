/**
 * 
 */
package com.boroborome.finace.web.jsonagent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boroborome.finace.web.jsonmodule.FinanceModule;

/**
 * @author boroborome
 *
 */
public class JSONAgentServlet extends HttpServlet 
{
	public static final String AgentName = "/agent/";
	private Map<String, JSONModuleInfo> mapModule = new HashMap<>();
	
	public JSONAgentServlet()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException
	{
		super.init();
		regJSONModule("finance", new FinanceModule());
	}

	public void regJSONModule(String jsonModuleName, IJSONModule module)
	{
		if (jsonModuleName == null || module == null || jsonModuleName.isEmpty())
		{
			return;
		}
		
		JSONModuleInfo moduleInfo = new JSONModuleInfo(jsonModuleName, module);
		mapModule.put(moduleInfo.getModuelName(), moduleInfo);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		doServletAction(req, resp);
	}


	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException
	{
		doServletAction(req, resp);
	}
	
	private void doServletAction(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		String uri = req.getRequestURI();
		
		//find out the moduleName and methodName;
		String moduleMethod = uri.substring(AgentName.length());
		String[] aryModuleInfo = moduleMethod.split("\\.");
		if (aryModuleInfo == null || aryModuleInfo.length != 2)
		{
			resp.getWriter().print("Unkown uri:" + uri);
			return;
		}
		String moduleName = aryModuleInfo[0];
		JSONModuleInfo moduleInfo = this.mapModule.get(moduleName);
		if (moduleInfo == null)
		{
			resp.getWriter().print("Unkown module:" + moduleName + " in uri:" + uri);
			return;
		}
		
		String methodName = aryModuleInfo[1];
		JSONMethodInfo method = moduleInfo.getMapMethod().get(methodName);
		if (method == null)
		{
			resp.getWriter().print("Unkown method:" + methodName + " in module:" + moduleName + " uri:" + uri);
			return;
		}
		
		try
		{
			String result = (String) method.getJavaMethod().invoke(moduleInfo.getModule(), req);
			resp.getWriter().print(result);
		}
		catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e)
		{
			e.printStackTrace(resp.getWriter());
		}

	}
}
