/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import javax.jdo.annotations.Persistent;


/**
 * @author boroborome
 *
 */
public abstract class AbstractEntityObject implements IEntityObject
{
	@Persistent
	protected String key;
	/* (non-Javadoc)
	 * @see com.boroborome.finance.web.jsonmodule.IEntityObject#getKey()
	 */
	@Override
	public String getKey()
	{
		return key;
	}

	/* (non-Javadoc)
	 * @see com.boroborome.finance.web.jsonmodule.IEntityObject#setKey(java.lang.String)
	 */
	@Override
	public void setKey(String key)
	{
		this.key = key;
	}

}
