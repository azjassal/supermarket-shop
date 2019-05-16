package com.example.supermarket.domain.basket;

import com.example.supermarket.domain.item.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;

public class Basket {

    private List<Item> items;

    public Basket() {
        this.items = new ArrayList();
    }

    public List<Item> getItems() {
        return unmodifiableList(items);
    }

    public void addItem(Item... item) {
        stream(item).forEach(i -> items.add(i));
    }

    public BigDecimal getSubTotal() {
        return items.stream().map(i -> i.getPrice().getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "items=" + items +
                '}';
    }

}
