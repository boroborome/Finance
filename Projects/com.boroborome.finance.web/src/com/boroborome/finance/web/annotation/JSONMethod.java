/**
 * 
 */
package com.boroborome.finance.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The method should declare like <br>
 * public String funName(HttpServletRequest req) throws XXXException<br>
 * public void funName(HttpServletRequest req, Writer writer) throws XXXException<br>
 * @author boroborome
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONMethod
{
	/**
	 * @return method name
	 */
	String name();
}
