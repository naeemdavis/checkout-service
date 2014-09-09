package com.highstreet.checkout.services;

import java.math.BigDecimal;
import java.util.List;

import com.highstreet.checkout.model.Item;



public interface CheckoutService {

    BigDecimal total();

    void scan(Item item);

    void removeItem(Item item);

    void setItemList(List<Item> itemList);

    List<Item> getItemList();

}
