package com.highstreet.checkout.services;

import java.math.BigDecimal;

import com.highstreet.checkout.model.Item;



public interface CheckoutService {

    BigDecimal total();

    void scan(Item item);

    void removeItem(Item item);

}
