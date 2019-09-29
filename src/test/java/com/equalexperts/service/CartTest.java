package com.equalexperts.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.equalexperts.entity.Cart;
import com.equalexperts.entity.Item;
import com.equalexperts.entity.Product;
import com.equalexperts.entity.User;

public class CartTest {

	private User user = null;
	CartService cartService = new CartService();

	@Before
	public void setUp() {
		Product product= new Product(1, "Dove Soaps",39.99);
		Item item = new Item(1, product,5);
		List<Item> items = new ArrayList<>();
		items.add(item);

		Cart cart = new Cart(1, items);
		user = new User(1, "kapil", cart);
	}
	

	@Test
	public void testTotalPriceForUser() {
		assertEquals(199.95, cartService.getTotalPriceForUser(user), 0);
	}

	@Test
	public void testTotalQuantityOfItemsForUser() {
		assertEquals(5, cartService.totalNumberOfItems(user));
	}
}
