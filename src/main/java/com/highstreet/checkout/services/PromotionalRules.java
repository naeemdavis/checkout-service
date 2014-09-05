package com.highstreet.checkout.services;

import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.model.Promotion;

public interface PromotionalRules {

	Double evaluateDiscountAmount(Promotion promotion, Item item);

}
