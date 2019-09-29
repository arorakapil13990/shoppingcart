package com.equalexperts.service;

import static java.lang.Double.parseDouble;

import java.text.DecimalFormat;

import com.equalexperts.entity.Item;
import com.equalexperts.entity.User;

public class CartService {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");



    double getTotalPriceForUser(User user) {
        return parseDouble(DECIMAL_FORMAT.format(user.getCart().getItems().stream().mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice()).sum()));
    }


    int totalNumberOfItems(User user) {
        return user.getCart().getItems().stream().mapToInt(Item::getQuantity).sum();
    }
}
