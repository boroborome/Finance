/**
 * 
 */
package com.boroborome.finance.web.jsonagent;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author boroborome
 *
 */
public class JSONMethodInfo
{
	private String jsonMethodName;
	private JSONModuleInfo parent;
	private Method javaMethod;
	private JSONMethodStrategy methodStrategy;
	
	/**
	 * @param jsonMethodName
	 * @param parent
	 * @param javaMethod
	 */
	public JSONMethodInfo(String jsonMethodName, JSONModuleInfo parent,
			Method javaMethod, JSONMethodStrategy methodStrategy)
	{
		super();
		this.jsonMethodName = jsonMethodName;
		this.parent = parent;
		this.javaMethod = javaMethod;
		this.methodStrategy = methodStrategy;
	}

	/**
	 * @return the jsonMethodName
	 */
	public String getJsonMethodName()
	{
		return jsonMethodName;
	}

	/**
	 * @return the parent
	 */
	public JSONModuleInfo getParent()
	{
		return parent;
	}

	/**
	 * @return the javaMethod
	 */
	public Method getJavaMethod()
	{
		return javaMethod;
	}
	
	public JSONMethodStrategy getMethodStrategy()
	{
		return methodStrategy;
	}
	
	public void invokeMethod(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		methodStrategy.invoke(this, req, resp);
	}
}
