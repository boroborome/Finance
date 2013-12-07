/**
 * 
 */
package com.boroborome.finance.logicimpl;

import java.util.Iterator;

import com.boroborome.finance.logic.IDataLogic;
import com.boroborome.finance.model.DataPage;
import com.boroborome.finance.model.DataPageBase;
import com.boroborome.finance.model.FinanceException;
import com.boroborome.finance.model.FinanceRecord;

/**
 * @author boroborome
 *
 */
public class FinanceLogic implements IDataLogic<FinanceRecord>
{

	@Override
	public void addData(FinanceRecord data) throws FinanceException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataPage<FinanceRecord> queryData(String condition,
			DataPageBase pageInfo) throws FinanceException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyData(FinanceRecord data) throws FinanceException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyData(Iterator<FinanceRecord> itemIterator)
			throws FinanceException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Iterator<FinanceRecord> itemIterator)
			throws FinanceException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(String condition) throws FinanceException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllData()
	{
		// TODO Auto-generated method stub
		
	}

}
