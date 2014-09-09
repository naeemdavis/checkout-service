package com.highstreet.checkout.rules.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highstreet.checkout.dao.PromotionDao;
import com.highstreet.checkout.dao.impl.MockPromotionDaoImpl;
import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.model.Promotion;
import com.highstreet.checkout.rules.PromotionalRules;
import com.highstreet.checkout.type.DiscountType;
@Service
public enum PromotionRulesImpl implements PromotionalRules {

	multipleItemsDiscount {
		public BigDecimal evaluateDiscountAmount(List<Item> itemList) {
			List<Item> items = new ArrayList<Item>();

			for (Item item : itemList) {
				Promotion promotion = getItemPromotionByItemId(item.getCode());
				if (null != promotion
						&& item.getCode().equals(promotion.getItemCode())
						&& itemCount(item.getCode(), itemList) > 1) {
					item.setPrice(PromotionRulesImpl.calculateDiscount(
							promotion.getPromotionValue(), promotion));
					items.add(item);
				} else {
					items.add(item);
				}
			}

			return totalDiscount.evaluateDiscountAmount(items);
		}

		private int itemCount(String code, List<Item> itemList) {
			int countDuplicate = 0;
			for (Item item : itemList) {
				if (code.equals(item.getCode())) {
					countDuplicate++;
				}
			}
			return countDuplicate;
		}

	},

	totalDiscount {
		public BigDecimal evaluateDiscountAmount(List<Item> items) {

			BigDecimal amount = getTotalPrice(items);
			Promotion promotion = getPromotionByPrice(002);

			if (amount.compareTo(new BigDecimal("60")) == 1) {
				amount = PromotionRulesImpl
						.calculateDiscount(amount, promotion);
			}
			return amount;
		}

		private BigDecimal getTotalPrice(List<Item> items) {
			BigDecimal totalAmount = BigDecimal.ZERO;
			for (Item item : items) {
				totalAmount = totalAmount.add(item.getPrice());
			}
			return totalAmount;

		}

	};

	@Autowired
	private PromotionDao promotionDao;

	/**
	 * @return the promotionDao
	 */
	public PromotionDao getPromotionDao() {
		return promotionDao;
	}

	/**
	 * @param promotionDao
	 *            the promotionDao to set
	 */
	public void setPromotionDao(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	public Promotion getItemPromotionByItemId(String code) {
		return new MockPromotionDaoImpl().getItemPromotionByItemId(code);
	}

	public Promotion getPromotionByPrice(Integer code) {
		return new MockPromotionDaoImpl().getPromotionByPrice(code);
	}

	public static BigDecimal calculateDiscount(BigDecimal amount,
			Promotion promotion) {

		// if discount on %
		if (promotion.getDiscountType().equals(
				DiscountType.AMOUNT_PERCENT_DISCOUNT)) {
			amount = amount.subtract(amount.multiply(promotion
					.getPromotionValue().divide(BigDecimal.valueOf(100))));
		}
		// if discount on actual value
		if (promotion.getDiscountType().equals(
				DiscountType.AMOUNT_VALUE_DISCOUNT)) {
			amount.subtract(promotion.getPromotionValue());
		}
		return amount;
	}

}
