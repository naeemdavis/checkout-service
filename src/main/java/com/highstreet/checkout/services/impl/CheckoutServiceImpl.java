package com.highstreet.checkout.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.perty.docbuilders.docStructureDocBuilder;

import com.highstreet.checkout.dao.PromotionDao;
import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.model.Promotion;
import com.highstreet.checkout.services.CheckoutService;
import com.highstreet.checkout.services.PromotionalRules;
import com.highstreet.checkout.type.DiscountType;
import com.highstreet.checkout.type.PromotionGroupType;

public class CheckoutServiceImpl implements CheckoutService {

    private List<Item> itemList;

    private PromotionalRules promotionalRules;
    
    private PromotionDao promotionDao;


    public CheckoutServiceImpl(PromotionalRules promotionalRules){
        this.itemList = new ArrayList<Item>();
        this.promotionalRules = promotionalRules;
    }


    @Override
    public Double total() {

        //scan items for discount if discount available
        Double totalPrice = 0d;
        Promotion promotion =  null;
        List<Item> groupItems = new ArrayList<Item>();

        for(Item item : itemList){
            promotion = promotionDao.getItemPromotion(item.getCode());

            if(promotion!=null){
            	if(promotion.getPromotionGroupType().equals(PromotionGroupType.GROUP)){
            		//totalPrice = evaluateGroupDiscountAmount(promotion, item, groupItems);
            	}else{
            		totalPrice = evaluateDiscountAmount(promotion, item);
            	}
            }else{
                totalPrice= totalPrice+item.getPrice();
            }


        }

        return null;
    }

    
    private Double evaluateGroupDiscountAmount(Promotion promotion, Item item) {
		// TODO Auto-generated method stub
		return null;
	}


	private Double evaluateDiscountAmount(Promotion promotion, Item item){
    	
    	Double discount = 0d;
    	
    	if(promotion.getDiscountType().equals(DiscountType.AMOUNT_PERCENT_DISCOUNT)){
    		
    		discount = item.getPrice() * (1/promotion.getValue());
    	}
    	
    	if(promotion.getDiscountType().equals(DiscountType.AMOUNT_VALUE_DISCOUNT)){
    		discount = item.getPrice() - promotion.getValue();    		
    	}
		return discount;
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
