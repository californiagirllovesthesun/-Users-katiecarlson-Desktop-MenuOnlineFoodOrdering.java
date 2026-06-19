package com.burgercurryhouse.model;

public class Rice extends MenuItem {
    public Rice() {
        super("Burger and Curry House Rice", 8);
    }

    // Polymorphism: Rice has a special behavior (e.g., buy 3, get $2 off)
    @Override
    public int calculatePrice(int quantity) {
        int total = this.basePrice * quantity;
        if (quantity >= 3) {
            total -= 2;
        }
        return total;
    }
}