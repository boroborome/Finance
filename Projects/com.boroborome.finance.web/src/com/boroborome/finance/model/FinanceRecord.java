/**
 * 
 */
package com.boroborome.finance.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.boroborome.finance.DataUtil;
import com.google.appengine.api.datastore.Entity;

/**
 * @author boroborome
 * 
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class FinanceRecord
{
	public static final String CreateTime = "createTime";
	public static final String ConsumeTime = "consumeTime";
	public static final String WaresName = "waresName";
	public static final String Price = "price";
	public static final String Amount = "amount";
	public static final String Unit = "unit";
	public static final String Deadline = "deadline";
	public static final String Remark = "remark";
	public static final String Kind = "kind";
	
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

	
	
	public void loadFromEntity(Entity entity)
	{
		createTime = DataUtil.getLong(entity, CreateTime, -1);
		consumeTime = DataUtil.getInt(entity, ConsumeTime, -1);
		waresName = DataUtil.getString(entity, WaresName, null);
		price = DataUtil.getInt(entity, Price, -1);
		amount = DataUtil.getInt(entity, Amount, -1);
		unit = DataUtil.getString(entity, Unit, null);
		deadline = DataUtil.getInt(entity, Deadline, -1);
		remark = DataUtil.getString(entity, Remark, null);
		kind = DataUtil.getString(entity, Kind, null);
	}
	
	public void saveToEntity(Entity entity)
	{
		entity.setProperty(CreateTime, this.createTime);
		entity.setProperty(ConsumeTime, this.consumeTime);
		entity.setProperty(WaresName, this.waresName);
		entity.setProperty(Price, this.price);
		entity.setProperty(Amount, this.amount);
		entity.setProperty(Unit, this.unit);
		entity.setProperty(Deadline, this.deadline);
		entity.setProperty(Remark, this.remark);
		entity.setProperty(Kind, this.kind);
	}
}
