/**
 * 
 */
package com.boroborome.finance.web.jsonagent;

import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author boroborome
 *
 */
public abstract class JSONMethodStrategy
{

	/**
	 * All the strategy we supported.
	 */
	private static List<JSONMethodStrategy> lstStrategy = new ArrayList<JSONMethodStrategy>();
	
	/**
	 * register a strategy in buffer
	 * @param strategy
	 */
	public static void regStrategy(JSONMethodStrategy strategy)
	{
		lstStrategy.add(strategy);
	}
	
	/**
	 * Find out a strategy for the input method<br>
	 * the funcation will return null if no strategy match this method
	 * @param method method to check
	 * @return strategy finded.
	 */
	public static JSONMethodStrategy findMatchStrategy(Method method)
	{
		JSONMethodStrategy strategy = null;
		for (JSONMethodStrategy curStrategy : lstStrategy)
		{
			if (curStrategy.isMethod(method))
			{
				strategy = curStrategy;
				break;
			}
		}
		return strategy;
	}
	
	static
	{
		regStrategy(new JSONMethodStrategy()
		{
			@Override
			public void invoke(JSONMethodInfo methodInfo, HttpServletRequest req, HttpServletResponse resp) throws Exception
			{
				String result = (String) methodInfo.getJavaMethod().invoke(methodInfo.getParent().getModule(), req);
				resp.getWriter().print(result);
			}

			@Override
			public boolean isMethod(Method method)
			{
				return (method != null
						&& method.getReturnType() == String.class
						&& method.getParameterTypes() != null
						&& method.getParameterTypes().length == 1
						&& method.getParameterTypes()[0] != HttpServletRequest.class);
			}
		});
		
		regStrategy(new JSONMethodStrategy()
		{

			@Override
			public void invoke(JSONMethodInfo methodInfo, HttpServletRequest req, HttpServletResponse resp) throws Exception
			{
				methodInfo.getJavaMethod().invoke(methodInfo.getParent().getModule(), req, resp.getWriter());
			}

			@Override
			public boolean isMethod(Method method)
			{
				return (method != null
						&& method.getReturnType() == Void.class
						&& method.getParameterTypes() != null
						&& method.getParameterTypes().length == 2
						&& method.getParameterTypes()[0] != HttpServletRequest.class
						&& method.getParameterTypes()[1] != Writer.class);
			}
		});
	}
	/**
	 * invoke a jsonMethod by request and response
	 * @param methodInfo method information
	 * @param req request
	 * @param resp response
	 * @throws Exception 
	 */
	public abstract void invoke(JSONMethodInfo methodInfo, HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
	/**
	 * check whether this method is match this strategy
	 * @param method
	 * @return
	 */
	public abstract boolean isMethod(Method method);
	
	
}
