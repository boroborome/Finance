/**
 * 
 */
package com.boroborome.finance.model;

import java.util.Iterator;

/**
 * @author boroborome
 *
 */
public class DataPage<DataType>
{
	private String sessionID;
	private int pageSize;
	private int curPageIndex;
	private int totalPageCount;
	private Iterator<DataType> resultIterator;
	/**
	 * @return the sessionID
	 */
	public String getSessionID()
	{
		return sessionID;
	}
	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(String sessionID)
	{
		this.sessionID = sessionID;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize()
	{
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	/**
	 * @return the curPageIndex
	 */
	public int getCurPageIndex()
	{
		return curPageIndex;
	}
	/**
	 * @param curPageIndex the curPageIndex to set
	 */
	public void setCurPageIndex(int curPageIndex)
	{
		this.curPageIndex = curPageIndex;
	}
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
