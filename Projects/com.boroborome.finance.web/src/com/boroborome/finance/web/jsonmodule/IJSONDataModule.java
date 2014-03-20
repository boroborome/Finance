/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import javax.servlet.http.HttpServletRequest;

import com.boroborome.finance.web.annotation.JSONMethod;
import com.boroborome.finance.web.jsonagent.IJSONModule;

/**
 * TODO to be implement in feature.
 * @author boroborome
 *
 */
public interface IJSONDataModule extends IJSONModule
{
	@JSONMethod(name = "query")
	String query(HttpServletRequest req) throws Exception;
	
	@JSONMethod(name = "add")
	String add(HttpServletRequest req) throws Exception;
	
	@JSONMethod(name = "modify")
	String modify(HttpServletRequest req) throws Exception;
	
	@JSONMethod(name = "delete")
	String delete(HttpServletRequest req) throws Exception;
}
