/**
 * 
 */
package com.boroborome.finance.web.jsonagent;

import java.lang.reflect.Method;

/**
 * @author boroborome
 *
 */
public class JSONMethodInfo
{
	private String jsonMethodName;
	private JSONModuleInfo parent;
	private Method javaMethod;
	
	/**
	 * @param jsonMethodName
	 * @param parent
	 * @param javaMethod
	 */
	public JSONMethodInfo(String jsonMethodName, JSONModuleInfo parent,
			Method javaMethod)
	{
		super();
		this.jsonMethodName = jsonMethodName;
		this.parent = parent;
		this.javaMethod = javaMethod;
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
	
	
}
