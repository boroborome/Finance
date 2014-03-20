/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManagerFactory;
import javax.servlet.http.HttpServletRequest;

import com.boroborome.finance.logic.IDataLogic;
import com.boroborome.finance.model.FinanceException;
import com.boroborome.finance.model.FinanceRecord;
import com.boroborome.finance.web.annotation.JSONMethod;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.gson.Gson;

/**
 * @author boroborome
 *
 */
public class FinanceModule implements IJSONDataModule
{
	private IDataLogic<FinanceRecord> dataLogic;
	private PersistenceManagerFactory pmf;
	
	private static final String[] FinanceFields = new String[]
			{
		"createTime",
		"consumeTime",
		"waresName",
		"price",
		"amount",
		"unit",
		"deadline",
		"remark",
		"kind",
			};
	
	public FinanceModule(PersistenceManagerFactory pmf)
	{
		super();
		this.pmf = pmf;
	}

	@JSONMethod(name = "add")
	@Override
	public String add(HttpServletRequest req)
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
			FinanceRecord fr = gson.fromJson(value, FinanceRecord.class);
			fr.setCreateTime(System.currentTimeMillis());
			Entity record = new Entity("FinanceRecord");
			fr.saveToEntity(record);
			datastore.put(record);
			result = gson.toJson(fr);
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.out);
		}
	    return result;
	}
	
	@JSONMethod(name = "query")
	@Override
	public String query(HttpServletRequest req) throws FinanceException, JSONException
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("FinanceRecord");

		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);

		List<FinanceRecord> lst = new ArrayList<FinanceRecord>();

		for (Entity entity : pq.asIterable())
		{
			FinanceRecord record = new FinanceRecord();
			record.loadFromEntity(entity);
			lst.add(record);
		}
		Gson gson = new Gson();
		return gson.toJson(lst);
				
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
			FinanceRecord fr = gson.fromJson(value, FinanceRecord.class);
			Entity record = new Entity("FinanceRecord");
			fr.saveToEntity(record);
			datastore.put(record);
			result = gson.toJson(fr);
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
		// TODO Auto-generated method stub
		return null;
	}
}
