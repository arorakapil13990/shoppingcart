package com.equalexperts.service;

import static java.lang.Double.parseDouble;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.equalexperts.entity.Cart;
import com.equalexperts.entity.Item;
import com.equalexperts.entity.User;

public class CartService {

    private Map<User, Cart> userCartMap = new HashMap<>();
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    void addItem(User user, Cart cart) {
        userCartMap.computeIfAbsent(user, k -> cart);
    }


    double getTotalPriceForUser(User user) {
        return parseDouble(DECIMAL_FORMAT.format(user.getCart().getItems().stream().mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice()).sum()));
    }


    int totalNumberOfItems(User user) {
        return userCartMap.get(user).getItems().stream().mapToInt(Item::getQuantity).sum();
    }
}
