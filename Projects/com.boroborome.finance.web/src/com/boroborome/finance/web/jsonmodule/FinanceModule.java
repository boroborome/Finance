/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import javax.jdo.PersistenceManagerFactory;

import com.boroborome.finance.logic.IDataLogic;
import com.boroborome.finance.model.FinanceRecord;

/**
 * @author boroborome
 *
 */
public class FinanceModule extends AbstractJSONDataModule<FinanceRecord>
{
	public FinanceModule()
	{
		super(FinanceRecord.class, "FinanceRecord");
	}

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

	/* (non-Javadoc)
	 * @see com.boroborome.finance.web.jsonmodule.AbstractJSONDataModule#beforeCreate(com.boroborome.finance.web.jsonmodule.IEntityObject)
	 */
	@Override
	public void beforeCreate(FinanceRecord data)
	{
		data.setCreateTime(System.currentTimeMillis());
	}
	
}
