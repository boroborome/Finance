/**
 * 
 */
package com.boroborome.finance.model;

/**
 * Basic information about a data page<br>
 * This struct is used in querying as an input situation
 * @author boroborome
 *
 */
public class DataPageBase
{
	private String sessionID;
	private int pageSize;
	private int curPageIndex;
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
	
	
}
