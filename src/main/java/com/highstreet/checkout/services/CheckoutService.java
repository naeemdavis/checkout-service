package com.highstreet.checkout.services;

import com.highstreet.checkout.model.Item;



public interface CheckoutService {

    Double total();

    void scan(Item item);

    void removeItem(Item item);

}
