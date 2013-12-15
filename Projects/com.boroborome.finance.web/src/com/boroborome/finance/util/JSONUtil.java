/**
 * 
 */
package com.boroborome.finance.util;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author boroborome
 *
 */
public class JSONUtil
{
	/**
	 * All simple data in this map will should single value without "{}"
	 */
	private static Map<Class, Boolean> mapSimpleData = new HashMap<Class, Boolean>();
	static
	{
		mapSimpleData.put(Integer.class, Boolean.TRUE);
		mapSimpleData.put(String.class, Boolean.TRUE);
		mapSimpleData.put(Boolean.class, Boolean.TRUE);
		mapSimpleData.put(Long.class, Boolean.TRUE);
		mapSimpleData.put(Double.class, Boolean.TRUE);
	}
	
	public static void saveObj2WriterInJSON(Object obj, Writer writer) throws IOException
	{
		if (obj == null || mapSimpleData.containsKey(obj.getClass()))
		{
			writer.write(String.valueOf(obj));
			return;
		}
		
		Stack<Object> stackObj = new Stack<Object>();
		stackObj.push(obj);
		while (!stackObj.isEmpty())
		{
			Object curObj = stackObj.lastElement();
			
		}
	}
	
	private static class JSONOutputFrame
	{
		private Object obj;
		private List<Method> lstAttribute = new ArrayList<Method>();
		/**
		 * @param obj
		 */
		public JSONOutputFrame(Object obj)
		{
			super();
			this.obj = obj;
		}
		
		
	}
}
