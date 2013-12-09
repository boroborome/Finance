/**
 * 
 */
package com.boroborome.finace.web.jsonmodule;

import javax.servlet.http.HttpServletRequest;

import com.boroborome.finace.web.annotation.JSONMethod;
import com.boroborome.finace.web.jsonagent.IJSONModule;

/**
 * @author boroborome
 *
 */
public class FinanceModule implements IJSONModule
{
	@JSONMethod(name = "add")
	public String addRecord(HttpServletRequest req)
	{
		return "add:" + req.getParameter("name");
	}
}
