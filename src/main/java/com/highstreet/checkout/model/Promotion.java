package com.highstreet.checkout.model;

import java.math.BigDecimal;

import com.highstreet.checkout.type.DiscountType;
import com.highstreet.checkout.type.PromotionGroupType;

public class Promotion {


    private Integer code;
    private DiscountType discountType;
    private BigDecimal PromotionValue;
    private PromotionGroupType promotionGroupType;
    private Integer itemCode;
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
    /**
     * @return the itemCode
     */
    public Integer getItemCode() {
        return itemCode;
    }
    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }
    /**
     * @return the promotionValue
     */
    public BigDecimal getPromotionValue() {
        return PromotionValue;
    }
    /**
     * @param promotionValue the promotionValue to set
     */
    public void setPromotionValue(BigDecimal promotionValue) {
        PromotionValue = promotionValue;
    }

}
