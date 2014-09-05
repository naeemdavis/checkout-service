package com.highstreet.checkout.dao;

import com.highstreet.checkout.model.Promotion;

public interface PromotionDao {

	public Promotion getItemPromotionByItemId(Integer code);

	public Promotion getPromotionByPrice(Integer code);

}
