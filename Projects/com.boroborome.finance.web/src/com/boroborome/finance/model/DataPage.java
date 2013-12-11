/**
 * 
 */
package com.boroborome.finance.model;

import java.util.Iterator;

/**
 * @author boroborome
 *
 */
public class DataPage<DataType> extends DataPageBase
{

	private int totalPageCount;
	private Iterator<DataType> resultIterator;
	/**
	 * @return the totalPageCount
	 */
	public int getTotalPageCount()
	{
		return totalPageCount;
	}
	/**
	 * @param totalPageCount the totalPageCount to set
	 */
	public void setTotalPageCount(int totalPageCount)
	{
		this.totalPageCount = totalPageCount;
	}
	/**
	 * @return the resultIterator
	 */
	public Iterator<DataType> getResultIterator()
	{
		return resultIterator;
	}
	/**
	 * @param resultIterator the resultIterator to set
	 */
	public void setResultIterator(Iterator<DataType> resultIterator)
	{
		this.resultIterator = resultIterator;
	}
	
	
}
