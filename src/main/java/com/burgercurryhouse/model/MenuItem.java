package com.burgercurryhouse.model;

public abstract class MenuItem {
    protected String name;
    protected int basePrice;

    public MenuItem(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    // Polymorphism: This method will be overridden by child classes
    public int calculatePrice(int quantity) {
        return this.basePrice * quantity;
    }
}