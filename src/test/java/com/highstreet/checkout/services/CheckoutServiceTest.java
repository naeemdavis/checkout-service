package com.highstreet.checkout.services;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.rules.impl.PromotionRulesImpl;
import com.highstreet.checkout.services.impl.CheckoutServiceImpl;

public class CheckoutServiceTest {

	public CheckoutService checkoutService;

	@Before
	public void initilizeBeforeClass() {

		checkoutService = new CheckoutServiceImpl(
				PromotionRulesImpl.MULTIPLE_ITEMS_DISCOUNT);
	}

	@Test
	public void testCheckOut_totalDiscount() {

		checkoutService.scan(getItem1());
		checkoutService.scan(getItem2());
		checkoutService.scan(getItem3());

		BigDecimal total = checkoutService.total();
		Assert.assertEquals(total.toString(), "66.78");
	}

	@Test
	public void testCheckOut_itemDiscount() {

		checkoutService.scan(getItem1());
		checkoutService.scan(getItem1());
		checkoutService.scan(getItem3());

		BigDecimal total = checkoutService.total();
		Assert.assertEquals(total.toString(), "36.95");
	}

	@Test
	public void testCheckOut_itemAndTotalDiscount() {

		checkoutService.scan(getItem1());
		checkoutService.scan(getItem2());
		checkoutService.scan(getItem1());
		checkoutService.scan(getItem3());

		BigDecimal total = checkoutService.total();
		Assert.assertEquals(total.toString(), "73.76");
	}

	@Test
	public void testCheckOut_noDiscount() {

		checkoutService.scan(getItem1());
		checkoutService.scan(getItem2());

		BigDecimal total = checkoutService.total();
		Assert.assertEquals(total.toString(), "54.25");
	}

	@Test
	public void testCheckOut_itemAndTotalDiscount_randomScan() {

		checkoutService.scan(getItem1());
		checkoutService.scan(getItem2());
		checkoutService.scan(getItem1());
		checkoutService.scan(getItem3());

		BigDecimal total = checkoutService.total();
		Assert.assertEquals(total.toString(), "73.76");
	}

	private Item getItem3() {
		Item item3 = new Item();
		item3.setCode("003");
		item3.setName("Kids T-shirt");
		item3.setPrice(new BigDecimal("19.95"));
		return item3;
	}

	private Item getItem2() {
		Item item2 = new Item();
		item2.setCode("002");
		item2.setName("Personalized cufflinks");
		item2.setPrice(new BigDecimal("45.00"));
		return item2;
	}

	private Item getItem1() {
		Item item1 = new Item();
		item1.setCode("001");
		item1.setName("Travel Card Holder");
		item1.setPrice(new BigDecimal("9.25"));
		return item1;
	}

}
