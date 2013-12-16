/**
 * 
 */
package com.boroborome.finance.util;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Stack;

import javax.jdo.annotations.Persistent;

/**
 * @author boroborome
 *
 */
public class ListJSONOutputFrame extends AbstractJSONOutputFrame
{
	private boolean isInitallized = false;
	private char chEnd;
	private int currentFieldIndex;
	private List lstObj;
	private boolean isFirstAttrOutput = false;

	public ListJSONOutputFrame(Object obj)
	{
		super(obj);
		lstObj = (List) obj;
	}

	@Override
	public void outputContent(Writer writer, Stack<AbstractJSONOutputFrame> stackObj) throws Exception
	{
		if (this._isFinishOutput)
		{
			return;
		}
		if (!isInitallized )
		{
			writer.write('[');
			chEnd = ']';
			//initallize field to be output
			currentFieldIndex = 0;
		}
		
		for (; currentFieldIndex < lstObj.size(); ++currentFieldIndex)
		{
			if (isFirstAttrOutput )
			{
				writer.write(',');
			}
			isFirstAttrOutput = false;
			
			Object value = lstObj.get(currentFieldIndex);
			if (value == null)
			{
				writer.write("null");
			}
			else if (JSONUtil.isSimpleData(value.getClass()))
			{
				writer.write(String.valueOf(value));
			}
			else
			{
				stackObj.push(AbstractJSONOutputFrame.parse(value));
				return;
			}
		}
		this._isFinishOutput = true;
	}

	@Override
	public void closeOutput(Writer writer) throws IOException
	{
		if (this.chEnd != '\0')
		{
			writer.write(chEnd);
		}
	}

}
