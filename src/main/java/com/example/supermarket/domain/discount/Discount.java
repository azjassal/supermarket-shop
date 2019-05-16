package com.example.supermarket.domain.discount;

import com.example.supermarket.domain.item.ItemGroup;

import java.math.BigDecimal;

public interface Discount {

    String getLabel();
    BigDecimal apply(ItemGroup itemGroup);

}
