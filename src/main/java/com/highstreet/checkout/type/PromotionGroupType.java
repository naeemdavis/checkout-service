
package com.highstreet.checkout.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PromotionGroupType {

    SINGLE(1, "Discount on single item"),
    GROUP(2, "Discount on group item"),;

    private Integer code;

    private String description;


    private static final Map<Integer, PromotionGroupType> lookupByResultCode = new HashMap<Integer, PromotionGroupType>();
    static {
        for (PromotionGroupType s : EnumSet.allOf(PromotionGroupType.class)) {
            lookupByResultCode.put(s.getCode(), s);
        }
    }


    private PromotionGroupType(Integer code, String description){
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
