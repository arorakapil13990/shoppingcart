package com.equalexperts.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.equalexperts.entity.Product;
import com.equalexperts.entity.User;

import static java.lang.Double.*;

public class Cart {

    private Map<User, List<Product>> userItemsMap = new HashMap<>();
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    void addItem(User user, Product product) {
        userItemsMap.computeIfAbsent(user, k -> new ArrayList<>()).add(product);
    }

    double getTotalPriceForUser(User user) {
        return parseDouble(DECIMAL_FORMAT.format(userItemsMap.get(user).stream().mapToDouble(product -> product.getQuantity() * product.getPrice()).sum()));
    }


    int totalNumberOfItems(User user) {
        return userItemsMap.get(user).stream().mapToInt(Product::getQuantity).sum();
    }
}
