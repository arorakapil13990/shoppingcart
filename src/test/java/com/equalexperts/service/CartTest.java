package com.equalexperts.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.equalexperts.entity.Cart;
import com.equalexperts.entity.Item;
import com.equalexperts.entity.Product;
import com.equalexperts.entity.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartTest {

	private static User user = null;
	CartService cartService = new CartService();

	@BeforeClass
	public static void setUp() {
		Product doveProduct= new Product(1, "Dove Soaps",39.99);
		Product axeProduct= new Product(2, "Axe Deo",99.99);
		Item item1 = new Item(1, doveProduct,2);
		Item item2 = new Item(2, axeProduct,2);
		List<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);

		Cart cart = new Cart(1, items);
		user = new User(1, "kapil", cart);
	}
	

	@Test
	public void testSellingPriceForUser() {
		assertEquals(279.96, cartService.getSellingPriceForUser(user), 0);
		
	}
	@Test
	public void testTotalPriceForUser() {
		assertEquals(314.96, cartService.getTotalPriceForUser(user), 0);
	}
	
	@Test
	public void testSalesTaxForCart() {
		assertEquals(35.00, cartService.getSalesTax(user), 0);
	}

	@Test
	public void testTotalQuantityOfItemsForUser() {
		assertEquals(4, cartService.totalNumberOfItems(user));
	}
}
