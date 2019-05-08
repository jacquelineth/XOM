package com.ibm.odm.support;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.BigInteger;
 

public class Money implements Serializable, Comparable<Money>{

	 public static final int MONEY_UNIT = 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8977175805707513871L;
	private  BigDecimal value ;


	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
/**
 * Transform parameter to a String to ensure that we use java.math.BigDecimal.BigDecimal(String string)
 * @param d
 */
	public void setValue( double d){
		this.value=new BigDecimal(Double.toString(d));
	} 

	public Money(BigDecimal rvalue) {
		super();
		this.value = rvalue;
	}
	/**
	 * Constructor 
	 */
	public Money() {
		super();
		this.value= new BigDecimal(BigInteger.ZERO,Money.MONEY_UNIT);
	}

	public Money( Money m) {
		this();
		this.value= m.getValue();	
		// Should be implicit
		//this.setScale(m.getScale());
	}
	 
	public void setScale (int scale) {
		this.value=this.value.setScale(scale);
		//java.lang.Thread.dumpStack();
	}
	public int getScale() {
		return this.value.scale();
	}

	@Override
	public int compareTo(Money o) {
		int res= this.getValue().compareTo(o.getValue());
		return res;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Money)
			return value.equals(((Money)o).value);

		return super.equals(o);
	}
}
