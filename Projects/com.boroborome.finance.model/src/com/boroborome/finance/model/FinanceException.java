/**
 * 
 */
package com.boroborome.finance.model;

/**
 * @author boroborome
 *
 */
public class FinanceException extends Exception
{
	private String messageKey;
	private Object[] params;
	
	/**
	 * @param messageKey
	 * @param params
	 * @param cause
	 */
	public FinanceException(String messageKey, Object[] params, Throwable cause)
	{
		super(cause);
		this.messageKey = messageKey;
		this.params = params;
	}

	/**
	 * @return the messageKey
	 */
	public String getMessageKey()
	{
		return messageKey;
	}

	/**
	 * @return the params
	 */
	public Object[] getParams()
	{
		return params;
	}
	
	
}
