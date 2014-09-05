package com.highstreet.checkout.type;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.highstreet.checkout.dao.PromotionDao;
import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.model.Promotion;
import com.highstreet.checkout.services.PromotionalRules;

public enum PromotionRulesImpl implements PromotionalRules {

    MULTIPLE_ITEMS_DISCOUNT {
        public BigDecimal evaluateDiscountAmount(List<Item> itemList) {
            BigDecimal discount = BigDecimal.ZERO;

            for (Item item : itemList) {
                Promotion promotion = getItemPromotionByItemId(item.getCode());
                if (null != promotion && item.getCode().equals(promotion.getItemCode())
                                && itemCount(item.getCode(), itemList) > 1) {
                    discount.add(promotion.getPromotionValue());
                }else{
                 discount.add(item.getPrice());
                }
            }

            if (discount.compareTo(new BigDecimal("60")) == 1){

            }

            return discount;
        }

        private int itemCount(Integer code, List<Item> itemList) {
            int countDuplicate = 0;
            for (Item item : itemList) {
                if (item.getCode().equals(code)) {
                    countDuplicate++;
                }
            }
            return countDuplicate;
        }

        @Override
        public BigDecimal evaluateDiscountAmount(BigDecimal amount) {
            // TODO Auto-generated method stub
            return null;
        }

    },

    TOTAL_DISCOUNT {
        @Override
        public BigDecimal evaluateDiscountAmount(BigDecimal amount) {
            Promotion promotion = getPromotionByPrice(002);

            if (amount.compareTo(new BigDecimal("60")) == 1) {

                if (promotion.getDiscountType().equals(DiscountType.AMOUNT_PERCENT_DISCOUNT)) {
                    return amount = amount
                                    .subtract(amount.multiply(promotion.getPromotionValue().divide(BigDecimal.valueOf(100))));
                }

                if (promotion.getDiscountType().equals(DiscountType.AMOUNT_VALUE_DISCOUNT)) {
                    return amount.subtract(promotion.getPromotionValue());
                }
            }

            return amount;
        }

        public BigDecimal evaluateDiscountAmount(List<Item> item) {
            // TODO Auto-generated method stub
            return null;
        }

    };

    @Autowired
    private PromotionDao promotionDao;

    /**
     * @return the promotionDao
     */
    public PromotionDao getPromotionDao() {
        return promotionDao;
    }

    /**
     * @param promotionDao the promotionDao to set
     */
    public void setPromotionDao(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }




    public Promotion getItemPromotionByItemId(Integer itemId) {

        Promotion promotion = null;

        if(itemId == 001){

        promotion = new Promotion();
        promotion.setCode(001);
        promotion.setDiscountType(DiscountType.AMOUNT_VALUE_DISCOUNT);
        promotion.setItemCode(001);
        promotion.setPromotionValue(new BigDecimal("8.50"));

        }

        return promotion;
    }


    public Promotion getPromotionByPrice(Integer code) {

        Promotion promotion = new Promotion();
        promotion.setCode(002);
        promotion.setDiscountType(DiscountType.AMOUNT_PERCENT_DISCOUNT);
        promotion.setPromotionValue(new BigDecimal("10"));

        return promotion;
    }




}
