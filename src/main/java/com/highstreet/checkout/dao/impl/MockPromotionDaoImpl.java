package com.highstreet.checkout.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.highstreet.checkout.dao.PromotionDao;
import com.highstreet.checkout.model.Promotion;
import com.highstreet.checkout.type.DiscountType;

@Service
public class MockPromotionDaoImpl implements PromotionDao {

	@Override
	public Promotion getItemPromotionByItemId(String code) {

	    Promotion promotion = null;

	    if("001".equals(code)){

	    promotion = new Promotion();
	    promotion.setCode("001");
	    promotion.setDiscountType(DiscountType.AMOUNT_VALUE_DISCOUNT);
	    promotion.setItemCode("001");
	    promotion.setPromotionValue(new BigDecimal("8.50"));

	    }

		return promotion;
	}

    @Override
    public Promotion getPromotionByPrice(Integer code) {

        Promotion promotion = new Promotion();
        promotion.setCode("002");
        promotion.setDiscountType(DiscountType.AMOUNT_PERCENT_DISCOUNT);
        promotion.setPromotionValue(new BigDecimal("10"));

        return promotion;
    }

}
