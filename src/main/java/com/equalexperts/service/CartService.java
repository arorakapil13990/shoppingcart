package com.equalexperts.service;

import static java.lang.Double.parseDouble;

import java.text.DecimalFormat;

import com.equalexperts.entity.Item;
import com.equalexperts.entity.User;

public class CartService {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####0.00");



    double getSellingPriceForUser(User user) {
        return  parseDouble(DECIMAL_FORMAT.format(user.getCart().getItems().stream().mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice()).sum()));
    }
    
    double getTotalPriceForUser(User user) {
        return  getSellingPriceForUser(user)+getSalesTax(user);
    }


    int totalNumberOfItems(User user) {
        return user.getCart().getItems().stream().mapToInt(Item::getQuantity).sum();
    }
    
    double getSalesTax(User user){
    	double sp = getSellingPriceForUser(user);
    	SalesTax st = new SalesTax();
    	double tax = st.getTax()/100;
    	return parseDouble(DECIMAL_FORMAT.format(Math.round(sp*tax)));
    }
}
