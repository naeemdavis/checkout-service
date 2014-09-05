package com.highstreet.checkout.model;

import java.math.BigDecimal;

import com.highstreet.checkout.type.DiscountType;

public class Promotion {


    private String code;
    private DiscountType discountType;
    private BigDecimal PromotionValue;
    private String itemCode;
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
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
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }
    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
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
