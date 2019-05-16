package com.example.supermarket.domain.discount;

import com.example.supermarket.domain.item.ItemGroup;

import java.math.BigDecimal;

import static java.lang.Math.floorDiv;

public class MultipleItemDiscount implements Discount {

    private String label;
    private Integer quantity;
    private Integer priceOf;

    public MultipleItemDiscount(String label, Integer quantity, Integer priceOf) {
        this.label = label;
        this.quantity = quantity;
        this.priceOf = priceOf;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public BigDecimal apply(ItemGroup itemGroup) {
        return new BigDecimal(floorDiv(itemGroup.getQuantity(), quantity))
            .multiply(itemGroup.getItem().getPrice().getAmount().multiply(new BigDecimal(quantity))
            .subtract(itemGroup.getItem().getPrice().getAmount().multiply(new BigDecimal(priceOf))));
    }

}
