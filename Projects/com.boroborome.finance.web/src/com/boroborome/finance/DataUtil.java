/**
 * 
 */
package com.boroborome.finance;

import com.google.appengine.api.datastore.Entity;

/**
 * @author boroborome
 *
 */
public final class DataUtil
{
	private DataUtil()
	{
		
	}
	
	public static int getInt(Entity entity, String propertyName, int defaultValue)
	{
		Object value = entity.getProperty(propertyName);
		if (value instanceof Number)
		{
			return ((Number) value).intValue();
		}
		if (value instanceof String)
		{
			return Integer.parseInt((String) value);
		}
		return defaultValue;
	}
	
	public static long getLong(Entity entity, String propertyName, long defaultValue)
	{
		Object value = entity.getProperty(propertyName);
		if (value instanceof Number)
		{
			return ((Number) value).longValue();
		}
		if (value instanceof String)
		{
			return Long.parseLong((String) value);
		}
		return defaultValue;
	}
	
	public static String getString(Entity entity, String propertyName, String defaultValue)
	{
		Object value = entity.getProperty(propertyName);
		if (value == null)
		{
			return defaultValue;
		}
		return String.valueOf(value);
	}
}
