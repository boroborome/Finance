/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.boroborome.finance.model.FinanceRecord;
import com.boroborome.finance.web.annotation.JSONMethod;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.gson.Gson;

/**
 * @author boroborome
 *
 */
public class AbstractJSONDataModule<DataType extends IEntityObject> implements IJSONDataModule
{
	protected final Class<DataType> dataType;
	protected final String entityName;

	public AbstractJSONDataModule(Class<DataType> dataType, String entityName)
	{
		this.dataType = dataType;
		this.entityName = entityName;
	}
	
	@JSONMethod(name = "query")
	@Override
	public String query(HttpServletRequest req) throws Exception
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query(entityName);

		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);

		List<DataType> lst = new ArrayList<DataType>();

		for (Entity entity : pq.asIterable())
		{
			DataType data = dataType.newInstance();
			data.loadFromEntity(entity);
			data.setKey(KeyFactory.keyToString(entity.getKey()));
			lst.add(data);
		}
		Gson gson = new Gson();
		return gson.toJson(lst);
	}

	/**
	 * Something todo before save data into datastore
	 * @param data
	 */
	public void beforeCreate(DataType data)
	{
		//Now nothing to do.
		//This is used for do something by subModule only.
	}
	
	@JSONMethod(name = "add")
	@Override
	public String add(HttpServletRequest req) throws Exception
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		String value = req.getParameter("value");
		if (value == null || value.isEmpty())
		{
			return "Error:No input value.";
		}
		Gson gson = new Gson();
		String result = "error";
		try
		{
			DataType data = gson.fromJson(value, dataType);
			beforeCreate(data);
			Entity entity = new Entity(entityName);
			data.saveToEntity(entity);
			datastore.put(entity);
			data.setKey(KeyFactory.keyToString(entity.getKey()));
			result = gson.toJson(data);
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.out);
		}
	    return result;
	}

	@JSONMethod(name = "modify")
	@Override
	public String modify(HttpServletRequest req) throws Exception
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		String value = req.getParameter("value");
		if (value == null || value.isEmpty())
		{
			return "Error:No input value.";
		}
		Gson gson = new Gson();
		String result = "error";
		try
		{
			DataType data = gson.fromJson(value, dataType);
			Entity dataEntity = datastore.get(KeyFactory.stringToKey(data.getKey()));
			if (dataEntity == null)
			{
				return "error:entity not exist.";
			}
			data.saveToEntity(dataEntity);
			datastore.put(dataEntity);
			result = gson.toJson(data);
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.out);
		}
	    return result;
	}

	@JSONMethod(name = "delete")
	@Override
	public String delete(HttpServletRequest req) throws Exception
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		String value = req.getParameter("value");
		if (value == null || value.isEmpty())
		{
			return "Error:No input value.";
		}
		Gson gson = new Gson();
		String result = "error";
		try
		{
			List<String> aryKey = gson.fromJson(value, List.class);
			List<Key> lstKey = new ArrayList<Key>();
			
			for (String strKey : aryKey)
			{
				lstKey.add(KeyFactory.stringToKey(strKey));
			}
			datastore.delete(lstKey);
			result = "OK";
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.out);
		}
	    return result;
	}

}
