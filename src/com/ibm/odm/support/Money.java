package com.ibm.odm.support;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.BigInteger;
 

public class Money implements Serializable {

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
		this.value= new BigDecimal(BigInteger.ZERO,2);
	}

	public Money( Money m) {
		this();
		this.value= m.getValue();	
	}
	 
	public void setScale (int scale) {
		this.value.setScale(scale);
		System.out.println("setScale to "+scale );
	}
	public int getScale() {
		return this.value.scale();
	}
}
