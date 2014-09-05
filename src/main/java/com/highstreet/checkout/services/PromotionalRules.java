package com.highstreet.checkout.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.highstreet.checkout.dao.PromotionDao;
import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.model.Promotion;

public interface PromotionalRules {


	BigDecimal evaluateDiscountAmount(List<Item> item);

	BigDecimal evaluateDiscountAmount(BigDecimal amount);

}
