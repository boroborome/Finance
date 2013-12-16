/**
 * 
 */
package com.boroborome.finance.util;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Stack;

import javax.jdo.annotations.Persistent;

/**
 * output simple data and normal object
 * @author boroborome
 *
 */
public class ObjectJSONOutputFrame extends AbstractJSONOutputFrame
{

	private boolean isInitallized = false;
	
	private Field[] aryField;
	private int currentFieldIndex;
	
	private char chEnd = '\0';
	private boolean isFirstAttrOutput = false;
	
	public ObjectJSONOutputFrame(Object obj)
	{
		super(obj);
	}

	@Override
	public void outputContent(Writer writer, Stack<AbstractJSONOutputFrame> stackObj) throws Exception
	{
		if (this._isFinishOutput)
		{
			return;
		}
		if (!isInitallized)
		{
			if (obj == null)
			{
				writer.write("null");
				this._isFinishOutput = true;
				return;
			}
			if (JSONUtil.isSimpleData(obj.getClass()))
			{
				writer.write(String.valueOf(obj));
				this._isFinishOutput = true;
				return;
			}
			
			writer.write('{');
			chEnd = '}';
			//initallize field to be output
			aryField = obj.getClass().getFields();
			currentFieldIndex = 0;
		}
		
		for (; currentFieldIndex < aryField.length; ++currentFieldIndex)
		{
			Field f = aryField[currentFieldIndex];
			Persistent ann = f.getAnnotation(Persistent.class);
			if (ann == null)
			{
				continue;
			}
			
			if (!isFirstAttrOutput)
			{
				writer.write(',');
				isFirstAttrOutput = true;
			}
			
			writer.write(f.getName());
			writer.write(':');
			Object value = f.get(obj);
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
