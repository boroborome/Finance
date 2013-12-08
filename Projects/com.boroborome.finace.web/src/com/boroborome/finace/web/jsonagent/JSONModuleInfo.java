/**
 * 
 */
package com.boroborome.finace.web.jsonagent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author boroborome
 *
 */
public class JSONModuleInfo
{
	private String moduelName;
	
	private IJSONModule module;
	
	/**
	 * json method name -> JSON method info
	 */
	private Map<String, JSONMethodInfo> mapMethod = new HashMap<>();

	public JSONModuleInfo(String moduelName, IJSONModule module)
	{
		super();
		this.moduelName = moduelName;
		this.module = module;
		
		initMethods();
	}

	private void initMethods()
	{
		Class<? extends IJSONModule> moduleClass = module.getClass();
	}

	/**
	 * @return the moduelName
	 */
	public String getModuelName()
	{
		return moduelName;
	}

	/**
	 * @return the mapMethod
	 */
	public Map<String, JSONMethodInfo> getMapMethod()
	{
		return mapMethod;
	}

	/**
	 * @return the module
	 */
	public IJSONModule getModule()
	{
		return module;
	}
	
	
}
