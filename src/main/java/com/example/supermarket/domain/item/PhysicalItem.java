package com.example.supermarket.domain.item;

import com.example.supermarket.domain.price.Price;

import java.util.Objects;

public class PhysicalItem implements Item {

    private Price price;
    private String label;

    public PhysicalItem(Price price, String label) {
        this.price = price;
        this.label = label;
    }

    public Price getPrice() {
        return price;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalItem that = (PhysicalItem) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, label);
    }

    @Override
    public String toString() {
        return "PhysicalItem{" +
                "price=" + price +
                ", label='" + label + '\'' +
                '}';
    }

}
