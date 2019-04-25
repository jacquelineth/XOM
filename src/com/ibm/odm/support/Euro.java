package com.ibm.odm.support;

import java.math.BigDecimal;
import java.util.Comparator;

public class Euro extends Money {
    private static final long serialVersionUID = -8977175805707513872L;
    public static final Euro Zero = new Euro(0.0);    

    public Euro(){
        super();
    }

    public Euro (double d) {
        this();
        setValue(d);
    }
    static  java.util.Comparator<Euro> comparator= new Comparator<Euro>() {
		
		@Override
		public int compare(Euro o1, Euro o2) {
			// TODO Auto-generated method stub
			return o1.getValue().compareTo(o2.getValue());
		}
	};
	
	public void  increasePercent(float f) {
		
		BigDecimal bD= new BigDecimal(1+(f/100.0));
		bD.setScale(MONEY_UNIT);
		this.setValue( this.getValue().multiply(bD));
	}
	public void  decreasePercent(float f) {
		
		BigDecimal bD= new BigDecimal(1-(f/100.0));
		bD.setScale(MONEY_UNIT);
		this.setValue( this.getValue().multiply(bD));
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
}