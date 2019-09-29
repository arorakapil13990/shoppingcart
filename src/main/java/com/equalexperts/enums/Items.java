package com.equalexperts.enums;

public enum Items {

    DOVE_SOAPS(39.99,"Dove Soaps");

    private double price;
    private String itemName;

    Items(double price, String itemName) {
      this.price = price;
      this.itemName=itemName;
    }

    public double getPrice() {
        return price;
    }
    public String getItemName() {
        return itemName;
    }
}

