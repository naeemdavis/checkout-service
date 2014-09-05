package com.highstreet.checkout.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.rules.PromotionalRules;
import com.highstreet.checkout.services.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService {

	private List<Item> itemList;

	private PromotionalRules promotionalRules;

	public CheckoutServiceImpl(PromotionalRules promotionalRules) {
		this.itemList = new ArrayList<Item>();
		this.promotionalRules = promotionalRules;
	}

	@Override
	public BigDecimal total() {
		// to remove zero in end.
		return promotionalRules.evaluateDiscountAmount(itemList)
				.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();

	}

	@Override
	public void scan(Item item) {
		itemList.add(item);
	}

	@Override
	public void removeItem(Item item) {
		// If we need to remove it.
	}

	/**
	 * @return the itemList
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList
	 *            the itemList to set
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
