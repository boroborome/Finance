/**
 * 
 */
package com.boroborome.finance.logic;

import java.util.Iterator;

import com.boroborome.finance.model.DataPage;
import com.boroborome.finance.model.DataPageBase;
import com.boroborome.finance.model.FinanceException;

/**
 * @author boroborome
 *
 */
public interface IDataLogic<DataType>
{
	public void addData(DataType data) throws FinanceException;
	
	/**
	 * @param condition JDOSQL
	 * @param pageInfo
	 * @return
	 * @throws FinanceException
	 */
	public DataPage<DataType> queryData(String condition, DataPageBase pageInfo) throws FinanceException;

	public void modifyData(DataType data) throws FinanceException;
	
	public void modifyData(Iterator<DataType> itemIterator) throws FinanceException;
	
	public void deleteData(Iterator<DataType> itemIterator) throws FinanceException;
	
	public void deleteData(String condition) throws FinanceException;
	
	public void deleteAllData();
}
