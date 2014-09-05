package com.highstreet.checkout.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.highstreet.checkout.model.Item;
import com.highstreet.checkout.services.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {


	@Autowired
    private CheckoutService checkoutService;

    /**
     * get rewards
     */
    @RequestMapping( value = {"/discount"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody BigDecimal getTotalPrice(@PathVariable List<Item> items) {
    	for(Item item: items){
    		checkoutService.scan(item);
    	}
        return checkoutService.total();
    }

}
