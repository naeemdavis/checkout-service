package com.highstreet.checkout.dao;

import com.highstreet.checkout.model.Promotion;

public interface PromotionDao {

	public Promotion getItemPromotionByItemId(String code);

	public Promotion getPromotionByPrice(Integer code);

}
