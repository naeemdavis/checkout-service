
package com.highstreet.checkout.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum DiscountType {

    AMOUNT_VALUE_DISCOUNT(1, "Discount in amount value"),
    AMOUNT_PERCENT_DISCOUNT(2, "Discount in percent value"),;

    private Integer code;

    private String description;


    private static final Map<Integer, DiscountType> lookupByResultCode = new HashMap<Integer, DiscountType>();
    static {
        for (DiscountType s : EnumSet.allOf(DiscountType.class)) {
            lookupByResultCode.put(s.getCode(), s);
        }
    }


    private DiscountType(Integer code, String description){
     this.code = code;
     this.description = description;
    }


    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }


}
