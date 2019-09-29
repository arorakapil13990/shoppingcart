package com.equalexperts.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.equalexperts.entity.Product;
import com.equalexperts.entity.User;
import com.equalexperts.enums.Items;

public class CartTest {
	
	private User user = null;
	Cart cart = new Cart();
	
	@Before
	public void setUp(){
		Product product = new Product(1, Items.DOVE_SOAPS.getItemName(), 5, Items.DOVE_SOAPS.getPrice());
		user = new User(1,"kapil",Arrays.asList(product));
		cart.addItem(user, product);
	}

	@Test
	public void testTotalPriceForUser() {
		assertEquals(199.95, cart.getTotalPriceForUser(user),0);
	}

}

