/**
 * 
 */
package com.boroborome.finance.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author boroborome
 * 
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class FinanceRecord
{
	/**
	 * The create time of record
	 */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	// @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private long createTime;
	
	/**
	 * The consume time
	 */
	@Persistent
	private int consumeTime;
	
	/**
	 * The goods name
	 */
	@Persistent
	private String waresName;
	
	/**
	 * unit is 0.01Yuan
	 */
	@Persistent
	private int price;
	
	/**
	 * The count of wares
	 */
	@Persistent
	private int amount;
	
	/**
	 * unit like kg, pack
	 */
	@Persistent
	private String unit;
	
	/**
	 * How long the ware can be used.The unit is day
	 */
	@Persistent
	private int deadline;
	
	@Persistent
	private String remark;
	
	@Persistent
	private String kind;

	/**
	 * @return the createTime
	 */
	public long getCreateTime()
	{
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime)
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
