package com.ibm.odm.support;

public interface Article {
	
	
	
	  Euro  price = null;

	public default Euro getPrice() {
		return price;
	}

	public Article getAffordableArticle(Euro max);
	

}
