package com.example.supermarket.domain.item;

public class ItemGroup {

    private Item item;
    private Integer quantity;

    public ItemGroup(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
