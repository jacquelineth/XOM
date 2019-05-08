package com.ibm.odm.support;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestEuro {
	Euro euro;
	@BeforeEach
	void setUp() throws Exception {
		euro = new Euro();
	}

	@Test
	void testEuro() {
		assertNotNull(euro);

		assertEquals(BigDecimal.ZERO.longValue(), euro.getValue().longValue());
		assertEquals(2, euro.getValue().scale());
	}

	@Test
	void testEuroDouble() {
		double f=45.24;
		Euro euro2 = new Euro(f);  
		assertEquals(f, euro2.getValue().doubleValue());
	}

	@Test
	void testIncreasePercent() {
		Euro euro2 = new Euro(100.0);  
		euro2.increasePercent(25.0);
		assertEquals(125.0, euro2.getValue().doubleValue());
	}
	@Test
	void testIncreasePercent15() {
		Euro euro2 = new Euro(50.0);  
		euro2.increasePercent(15.0);
		Euro res = new  Euro (57.50);res.setScale(Euro.MONEY_UNIT);
//		System.err.println("TestEuro.testIncreasePercent "+euro2 +" ref "+res);
		assertEquals(res, euro2);
	}
	@Test
	void testIncreasePercentBD() {
		Euro euro2 = new Euro(100.0);  
		euro2.increasePercent(25.0);
		BigDecimal b=  BigDecimal.valueOf(125.00);b=b.setScale(2);//BigDecimal.valueOf(125, Money.MONEY_UNIT);
//		System.out.println("TestEuro.testIncreasePercentBD() "+b.scale()+ "  "+b.doubleValue());
		assertTrue(b.equals(euro2.getValue()));
		
	}

	@Test
	void testDecreasePercent() {
		Euro euro2 = new Euro(45.0);  
		euro2.decreasePercent(25.0);
		assertEquals(33.75, euro2.getValue().doubleValue());
	}
	
	@Test
	void testCompare() {
		Euro euro2 = new Euro(45.0);  
		Euro euro3 = new Euro();  
		assertEquals(1,Euro.comparator.compare(euro2, euro));
		assertEquals(0,Euro.comparator.compare(euro3, euro));
		assertEquals(-1,Euro.comparator.compare(euro3, euro2));
	}


}
