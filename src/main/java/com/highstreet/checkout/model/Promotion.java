package com.highstreet.checkout.model;

import com.highstreet.checkout.type.DiscountType;

public class Promotion {


    private Integer code;
    private DiscountType discountType;
    private Double value;
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

}
