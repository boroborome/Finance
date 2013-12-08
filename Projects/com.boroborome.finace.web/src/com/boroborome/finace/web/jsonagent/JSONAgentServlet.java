/**
 * 
 */
package com.boroborome.finace.web.jsonagent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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
		initJSONMoudle();
	}

	private void initJSONMoudle()
	{
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

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException
	{
		resp.setContentType("text/plain");
		String uri = req.getRequestURI();
		
		//find out the moduleName and methodName;
		String moduleMethod = uri.substring(AgentName.length());
		String[] aryModuleInfo = moduleMethod.split("\\\\.");
		if (aryModuleInfo == null || aryModuleInfo.length != 2)
		{
			responseError(resp);
			return;
		}
		JSONModuleInfo moduleInfo = this.mapModule.get(aryModuleInfo[0]);
		if (moduleInfo == null)
		{
			responseError(resp);
			return;
		}
		
		JSONMethodInfo method = moduleInfo.getMapMethod().get(aryModuleInfo[1]);
		if (method == null)
		{
			responseError(resp);
			return;
		}
		
		try
		{
			String result = (String) method.getJavaMethod().invoke(moduleInfo.getModule(), req);
			resp.getWriter().println(result);
		}
		catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void responseError(HttpServletResponse resp)
	{
		// TODO Auto-generated method stub
		
	}
}
