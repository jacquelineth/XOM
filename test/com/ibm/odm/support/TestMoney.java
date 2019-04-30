package com.ibm.odm.support;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMoney {
	Money money;
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
		euro2.increasePercent(25.0f);
		assertEquals(125.0, euro2.getValue().doubleValue());
	}

	@Test
	void testDecreasePercent() {
		Euro euro2 = new Euro(45.0);  
		euro2.decreasePercent(25.0f);
		assertEquals(33.75, euro2.getValue().doubleValue());
	}



}
