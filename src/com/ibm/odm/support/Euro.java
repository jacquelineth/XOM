package com.ibm.odm.support;

import java.math.BigDecimal;
import java.util.Comparator;

public class Euro extends Money {
    private static final long serialVersionUID = -8977175805707513872L;
    public static final Euro Zero = new Euro(0,2);    

    public Euro(){
        super();
        
    }

    public Euro (double d) {
        this();
        setValue(d);
        
    }
    public Euro(double i, int scale) {
		super();
		setValue(i);
		setScale(scale);
	}
	static  java.util.Comparator<Euro> comparator= new Comparator<Euro>() {
		
		@Override
		public int compare(Euro o1, Euro o2) {
//			System.out.println("Euro.enclosing_method()");
//			java.lang.Thread.dumpStack();
			return o1.getValue().compareTo(o2.getValue());
		}
	};
	
	public void  increasePercent(double f) {
		f/=100.0;
		f+=1.0;
		BigDecimal bD= new BigDecimal(Double.toString(f));
		bD=bD.setScale(MONEY_UNIT);
		this.setValue( this.getValue().multiply(bD));
		this.setScale(MONEY_UNIT);
	}
	public void  decreasePercent(double d) {
		
		double res= 1-(d/100.0);
		BigDecimal bD= new BigDecimal(Double.toString(res));
		bD=bD.setScale(MONEY_UNIT);
		this.setValue( this.getValue().multiply(bD));
		this.setScale(MONEY_UNIT);
	}

	public void increase(Euro plus) {
		this.setValue(this.getValue().add(plus.getValue()));
		
	}

	public boolean decrease(Euro moins) {

		BigDecimal Bmoins= moins.getValue();
		boolean res=true;
		BigDecimal result= this.getValue().subtract(Bmoins);
		if(result.signum()== -1) {
			result= BigDecimal.ZERO;
			res=false;
		}
		this.setValue(result);
		return res;
	}
	
	@Override
	public String toString() {

		return "Value: "+ this.getValue();
	}
}