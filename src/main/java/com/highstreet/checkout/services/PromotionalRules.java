package com.highstreet.checkout.services;

import com.highstreet.checkout.model.Promotion;

public interface PromotionalRules {

    Promotion getItemPromotion(Integer code);

}
