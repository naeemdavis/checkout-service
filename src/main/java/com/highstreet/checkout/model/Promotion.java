package com.highstreet.checkout.model;

import com.highstreet.checkout.type.DiscountType;
import com.highstreet.checkout.type.PromotionGroupType;

public class Promotion {


    private Integer code;
    private DiscountType discountType;
    private Double value;
    private PromotionGroupType promotionGroupType;
    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }
    /**
     * @return the discountType
     */
    public DiscountType getDiscountType() {
        return discountType;
    }
    /**
     * @param discountType the discountType to set
     */
    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
    /**
     * @return the value
     */
    public Double getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(Double value) {
        this.value = value;
    }
	/**
	 * @return the promotionGroupType
	 */
	public PromotionGroupType getPromotionGroupType() {
		return promotionGroupType;
	}
	/**
	 * @param promotionGroupType the promotionGroupType to set
	 */
	public void setPromotionGroupType(PromotionGroupType promotionGroupType) {
		this.promotionGroupType = promotionGroupType;
	}

}
