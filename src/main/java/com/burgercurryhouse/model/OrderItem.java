package com.burgercurryhouse.model;

public class OrderItem {
    private MenuItem item;
    private int quantity;
    private int totalPrice;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = item.calculatePrice(quantity);
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getItemName() {
        return item.getName();
    }
}