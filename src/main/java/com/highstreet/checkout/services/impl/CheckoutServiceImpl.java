package com.highstreet.checkout.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.model.Promotion;
import com.highstreet.checkout.services.CheckoutService;
import com.highstreet.checkout.services.PromotionalRules;

public class CheckoutServiceImpl implements CheckoutService {

    private List<Item> itemList;

    private PromotionalRules promotionalRules;


    public CheckoutServiceImpl(PromotionalRules promotionalRules){
        this.itemList = new ArrayList<Item>();
        this.promotionalRules = promotionalRules;
    }


    @Override
    public Double total() {

        //scan items for discount if discount available
        Double totalPrice = Double.valueOf(0);
        Promotion promotion =  null;

        for(Item item : itemList){
            promotion = promotionalRules.getItemPromotion(item.getCode());

            if(promotion!=null){

            }else{
                totalPrice= totalPrice+item.getPrice();
            }


        }

        return null;
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
