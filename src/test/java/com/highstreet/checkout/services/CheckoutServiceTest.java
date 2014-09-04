package com.highstreet.checkout.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.services.impl.CheckoutServiceImpl;

public class CheckoutServiceTest {


    public CheckoutService checkoutService;



    @Before
    public void initilizeBeforeClass() {

     checkoutService = new CheckoutServiceImpl()

    }

    @Test
    public void testCheckOut_promotionRule_totalDiscount() {

        Item item1 = new Item();
        item1.setCode(001);
        item1.setName("Travel Card Holder");
        item1.setPrice(9.25);

        Item item2 = new Item();
        item2.setCode(002);
        item2.setName("Personalized cufflinks");
        item2.setPrice(45.00);

        Item item3 = new Item();
        item3.setCode(003);
        item3.setName("Kids T-shirt");
        item3.setPrice(19.95);

    }

    @Test
    public void testRewardService_promotionRule_itemDiscount() {

        Item item1 = new Item();
        item1.setCode(001);
        item1.setName("Travel Card Holder");
        item1.setPrice(9.25);

        Item item2 = new Item();
        item2.setCode(002);
        item2.setName("Personalized cufflinks");
        item2.setPrice(45.00);

        Item item3 = new Item();
        item3.setCode(001);
        item3.setName("Travel Card Holder");
        item3.setPrice(9.25);




    }

    @Test
    public void testRewardService_promotionRule_allDiscounts() {

        Item item1 = new Item();
        item1.setCode(001);
        item1.setName("Travel Card Holder");
        item1.setPrice(9.25);

        Item item2 = new Item();
        item2.setCode(002);
        item2.setName("Personalized cufflinks");
        item2.setPrice(45.00);

        Item item3 = new Item();
        item3.setCode(001);
        item3.setName("Travel Card Holder");
        item3.setPrice(9.25);

        Item item4 = new Item();
        item4.setCode(001);
        item4.setName("Travel Card Holder");
        item4.setPrice(9.25);

    }

}
