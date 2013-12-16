/**
 * 
 */
package com.boroborome.finance.util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Stack;

/**
 * @author boroborome
 *
 */
public abstract class AbstractJSONOutputFrame
{
	protected boolean _isFinishOutput = false;
	protected Object obj;
	public AbstractJSONOutputFrame(Object obj)
	{
		super();
		this.obj = obj;
	}
	
	public static AbstractJSONOutputFrame parse(Object obj)
	{
		if (obj instanceof List)
		{
			return new ListJSONOutputFrame(obj);
		}
		return new ObjectJSONOutputFrame(obj);
	}
	


	/**
	 * @return the _isFinishOutput
	 */
	public boolean isFinishOutput()
	{
		return _isFinishOutput;
	}

	/**
	 * output something<br>
	 * this method may be invoked many times 
	 * @param writer
	 * @param stackObj
	 * @throws Exception
	 */
	public abstract void outputContent(Writer writer, Stack<AbstractJSONOutputFrame> stackObj) throws Exception;


	public abstract void closeOutput(Writer writer) throws IOException;
}
