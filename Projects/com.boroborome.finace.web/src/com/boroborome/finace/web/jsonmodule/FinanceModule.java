/**
 * 
 */
package com.boroborome.finace.web.jsonmodule;

import javax.servlet.http.HttpServletRequest;

import com.boroborome.finace.web.annotation.JSONMethod;
import com.boroborome.finace.web.jsonagent.IJSONModule;
import com.boroborome.finance.logic.IDataLogic;
import com.boroborome.finance.model.DataPage;
import com.boroborome.finance.model.FinanceException;
import com.boroborome.finance.model.FinanceRecord;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.Named;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 * @author boroborome
 *
 */
public class FinanceModule implements IJSONModule
{
	private IDataLogic<FinanceRecord> dataLogic;
	
	public FinanceModule(IDataLogic<FinanceRecord> dataLogic)
	{
		super();
		this.dataLogic = dataLogic;
	}

	@JSONMethod(name = "add")
	public String add(HttpServletRequest req)
	{
		return "add:" + req.getParameter("name");
	}
	
	@JSONMethod(name = "query")
	public String query(HttpServletRequest req) throws FinanceException
	{
		DataPage<FinanceRecord> resultPage = dataLogic.queryData(null, null);
		JSONArray aryRecord = new JSONArray();
		while (resultPage.getResultIterator().hasNext())
		{
			FinanceRecord r = resultPage.getResultIterator().next();
			JSONObject jsonRecord = new JSONObject();
//			jsonRecord.append(r., arg1)
		}
		return "add:" + req.getParameter("name");
	}
}
