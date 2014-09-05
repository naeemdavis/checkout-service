package com.highstreet.checkout.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.highstreet.checkout.dao.PromotionDao;
import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.services.CheckoutService;
import com.highstreet.checkout.services.PromotionalRules;

public class CheckoutServiceImpl implements CheckoutService {

    private List<Item> itemList;

    private PromotionalRules promotionalRules;

    private PromotionDao promotionDao;


    public CheckoutServiceImpl(PromotionalRules promotionalRules){
        this.itemList = new ArrayList<Item>();
        this.promotionalRules = promotionalRules;
    }


    @Override
    public BigDecimal total() {
        return promotionalRules.evaluateDiscountAmount(itemList);

    }




    @Override
    public void scan(Item item) {
        itemList.add(item);
    }


    @Override
    public void removeItem(Item item) {
     //If we need to remove it.
    }


    /**
     * @return the itemList
     */
    public List<Item> getItemList() {
        return itemList;
    }


    /**
     * @param itemList the itemList to set
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

}
