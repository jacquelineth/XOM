package com.ibm.odm.support;

import java.util.EnumSet;

public enum Product implements Article {
	Cola(1),Bread(2),Burger(5),CD(10),DVD(20),USBkey(25),Mouse(50),Game(75),LavaLamp(100),Laptop(300),Monitor(400),Phone(500);
	
	Euro  price;
	 public Euro getPrice() {
		    return price;
	 }
	 private Product(int i) {
		 this(new Euro(i));
		// TODO Auto-generated constructor stub
	}
	 Product(Euro p) {price=p;}
	 static public Product cheapestProduct(){
		 return (Product) EnumSet.allOf(Product.class).toArray()[0];
	 }
	 @Override
	public String toString() {
		
		return super.toString()+":�"+price;
	}
	 static public Product getAffordableProduct(Euro max){
		 Object[]list=  EnumSet.allOf(Product.class).toArray();
		 //sorting is needed, unless declared in order
		 int size=list.length-1;
		 while(size>0){
			 //if(max >((Product)list[size]).price)
			 if(Euro.comparator.compare(max, ((Product)list[size]).price) >0)
				 return ((Product)list[size]);
			 else size--;
		 }
		 return ((Product)list[0]);
	 }
	@Override
	public Article getAffordableArticle(Euro max) {
		
		return getAffordableProduct(max);
	}

}

