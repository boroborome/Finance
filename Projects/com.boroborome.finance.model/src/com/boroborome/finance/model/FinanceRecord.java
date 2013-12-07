/**
 * 
 */
package com.boroborome.finance.model;

/**
 * @author boroborome
 * 
 */
public class FinanceRecord
{
	/**
	 * The create time of record
	 */
	private int createTime;
	
	/**
	 * The consume time
	 */
	private int consumeTime;
	
	/**
	 * The goods name
	 */
	private String waresName;
	
	/**
	 * unit is 0.01Yuan
	 */
	private int price;
	
	/**
	 * The count of wares
	 */
	private int amount;
	
	/**
	 * unit like kg, pack
	 */
	private String unit;
	
	/**
	 * How long the ware can be used.The unit is day
	 */
	private int deadline;
	
	private String remark;
	
	private String kind;
}
