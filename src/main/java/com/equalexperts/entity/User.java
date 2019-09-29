package com.equalexperts.entity;

import java.util.Objects;

public class User {

    private int id;
    private String name;
    private Cart cart;
    
    
    public User() {
    }

    public User(int id, String name, Cart cart) {
        super();
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
