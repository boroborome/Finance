/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.http.HttpServletRequest;

import com.boroborome.finance.logic.IDataLogic;
import com.boroborome.finance.model.DataPage;
import com.boroborome.finance.model.FinanceException;
import com.boroborome.finance.model.FinanceRecord;
import com.boroborome.finance.util.JSONUtil;
import com.boroborome.finance.web.annotation.JSONMethod;
import com.boroborome.finance.web.jsonagent.IJSONModule;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;

/**
 * @author boroborome
 *
 */
public class FinanceModule implements IJSONModule
{
	private IDataLogic<FinanceRecord> dataLogic;
	private PersistenceManagerFactory pmf;
	
	public FinanceModule(PersistenceManagerFactory pmf)
	{
		super();
		this.pmf = pmf;
	}

	@JSONMethod(name = "add")
	public String add(HttpServletRequest req)
	{
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
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(fr);
		pm.close();
		result = gson.toJson(fr);
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.out);
		}
	    return result;
	}
	
	@JSONMethod(name = "query")
	public String query(HttpServletRequest req) throws FinanceException, JSONException
	{
//		DataPage<FinanceRecord> resultPage = dataLogic.queryData(null, null);
		JSONArray aryRecord = new JSONArray();
//		while (resultPage.getResultIterator().hasNext())
		{
//			FinanceRecord r = resultPage.getResultIterator().next();
			JSONObject jsonRecord = new JSONObject();
			jsonRecord.put("date", "2013-12-11");
			jsonRecord.put("wares", "Apple");
			jsonRecord.put("price", "4");
			jsonRecord.put("unit", "Jin");
//			jsonRecord.append(r., arg1)
			
			aryRecord.put(jsonRecord);
		}
		return aryRecord.toString();
	}
}
