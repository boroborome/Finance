/**
 * 
 */
package com.boroborome.finace.web.jsonagent;

import java.io.IOException;
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
			throws IOException {
		resp.setContentType("text/plain");

		resp.getWriter().println("Hello, world");
	}
}
