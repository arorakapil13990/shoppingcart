package com.equalexperts.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.equalexperts.entity.Product;
import com.equalexperts.entity.User;

public class Cart {
	
	Map<User,List<Product>> userItemsMap = new HashMap<User, List<Product>>();
	DecimalFormat decimalFormat =  new DecimalFormat("0.00"); 
	
	public void addItem(User user, Product product){
		userItemsMap.computeIfAbsent(user, k -> new ArrayList<>()).add(product);
	}
	
	public double getTotalPriceForUser(User user) {
		double totalPrice=0;
		List<Product> products = userItemsMap.get(user);
		for (Product product : products) {
			totalPrice += (product.getQuantity() * product.getPrice());
		}
		return Double.valueOf(decimalFormat.format(totalPrice));
	}

}
