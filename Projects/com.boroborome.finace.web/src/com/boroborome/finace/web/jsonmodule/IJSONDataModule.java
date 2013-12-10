/**
 * 
 */
package com.boroborome.finace.web.jsonmodule;

import javax.servlet.http.HttpServletRequest;

import com.boroborome.finace.web.jsonagent.IJSONModule;

/**
 * TODO to be implement in feature.
 * @author boroborome
 *
 */
public interface IJSONDataModule<DataType> extends IJSONModule
{
	String add(HttpServletRequest req) throws Exception;
	String query(HttpServletRequest req) throws Exception;
}
