package com.highstreet.checkout.rules;

import java.math.BigDecimal;
import java.util.List;

import com.highstreet.checkout.model.Item;

public interface PromotionalRules {
	BigDecimal evaluateDiscountAmount(List<Item> item);
}
