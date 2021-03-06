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

	/**
	 * @return the createTime
	 */
	public int getCreateTime()
	{
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(int createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * @return the consumeTime
	 */
	public int getConsumeTime()
	{
		return consumeTime;
	}

	/**
	 * @param consumeTime the consumeTime to set
	 */
	public void setConsumeTime(int consumeTime)
	{
		this.consumeTime = consumeTime;
	}

	/**
	 * @return the waresName
	 */
	public String getWaresName()
	{
		return waresName;
	}

	/**
	 * @param waresName the waresName to set
	 */
	public void setWaresName(String waresName)
	{
		this.waresName = waresName;
	}

	/**
	 * @return the price
	 */
	public int getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}

	/**
	 * @return the amount
	 */
	public int getAmount()
	{
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the unit
	 */
	public String getUnit()
	{
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	/**
	 * @return the deadline
	 */
	public int getDeadline()
	{
		return deadline;
	}

	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(int deadline)
	{
		this.deadline = deadline;
	}

	/**
	 * @return the remark
	 */
	public String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * @return the kind
	 */
	public String getKind()
	{
		return kind;
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	
}
