package com.equalexperts.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.equalexperts.entity.Cart;
import com.equalexperts.entity.Item;
import com.equalexperts.entity.User;

public class CartTest {

	private User user = null;
	CartService cartService = new CartService();

	@Before
	public void setUp() {
		Item item = new Item(1, "Dove Soaps", 5, 39.99);
		List<Item> items = new ArrayList<>();
		items.add(item);

		Cart cart = new Cart(1, items);
		user = new User(1, "kapil", cart);
		cartService.addItem(user, cart);
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
