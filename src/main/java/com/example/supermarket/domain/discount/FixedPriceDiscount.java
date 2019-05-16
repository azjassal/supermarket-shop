package com.example.supermarket.domain.discount;

import com.example.supermarket.domain.item.ItemGroup;

import java.math.BigDecimal;

import static java.lang.Math.floorDiv;

public class FixedPriceDiscount implements Discount {

    private String label;
    private Integer quantity;
    private BigDecimal discountedPrice;

    public FixedPriceDiscount(String label, Integer quantity, BigDecimal discountedPrice) {
        this.label = label;
        this.quantity = quantity;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public BigDecimal apply(ItemGroup itemGroup) {
        return new BigDecimal(floorDiv(itemGroup.getQuantity(), quantity))
            .multiply(itemGroup.getItem().getPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountedPrice));
    }

}
