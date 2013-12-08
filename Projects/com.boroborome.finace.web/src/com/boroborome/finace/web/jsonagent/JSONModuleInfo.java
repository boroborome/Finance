/**
 * 
 */
package com.boroborome.finace.web.jsonagent;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.boroborome.finace.web.annotation.JSONMethod;

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
		for (Method method : moduleClass.getMethods())
		{
			JSONMethod methodAnn = method.getAnnotation(JSONMethod.class);
			if (methodAnn == null)
			{
				continue;
			}
			
			//check the input&output of this method
			if (method.getReturnType() != String.class
					|| method.getParameterTypes() == null
					|| method.getParameterTypes().length != 1
					|| method.getParameterTypes()[0] != HttpServletRequest.class)
			{
				//TODO should write log
				continue;
			}
			
			mapMethod.put(methodAnn.name(), new JSONMethodInfo(methodAnn.name(), this, method));
		}
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
