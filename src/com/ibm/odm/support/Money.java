package com.ibm.odm.support;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.BigInteger;
 

public class Money implements Serializable {

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

	public void setValue( double d){
		this.value=new BigDecimal(d);
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
	}
	 
	public void setScale (int scale) {
		this.value.setScale(scale);
		System.out.println("setScale to "+scale );
		java.lang.Thread.dumpStack();
	}
	public int getScale() {
		return this.value.scale();
	}
}
