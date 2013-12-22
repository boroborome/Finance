/**
 * 
 */
package com.boroborome.dataexchange;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author boroborome
 *
 */
public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args == null || args.length != 3
				|| !args[0].toLowerCase().endsWith(".xslt")
				|| !args[1].toLowerCase().endsWith(".xml")
				|| !args[2].toLowerCase().endsWith(".csv"))
		{
			printHelp();
			return;
		}
		
		String xsltFile = args[0];
		String xmlFile = args[1];
		String csvFile = args[2];
		
		try
		{
			convertData(xsltFile, xmlFile, csvFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			printHelp();
		}
		
	}

	private static void convertData(String xsltFile, String xmlFile, String csvFile) throws Exception
	{
		//Load xslt file
		TransformerFactory tFactory = TransformerFactory.newInstance();
		StreamSource stylesource = new StreamSource(xsltFile); 
        Transformer transformer = tFactory.newTransformer(stylesource);
		
		//load xml file
		//convert to csv file
        FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try
		{
			inputStream = new FileInputStream(new File(xmlFile));
			StreamSource source = new StreamSource(inputStream);
			outputStream = new FileOutputStream(new File(csvFile));
	        StreamResult result = new StreamResult(outputStream);
	        transformer.transform(source, result);
		}
		finally
		{
			if (inputStream != null)
			{
				inputStream.close();
			}
			if (outputStream != null)
			{
				outputStream.close();
			}
		}
	}

	private static void printHelp()
	{
		System.out.println("The right format is like this:");
		System.out.println("java dataexchange.jar XX.xslt xxx.xml xx.csv");
	}

}
