package com.example.supermarket.domain.item;

import com.example.supermarket.domain.price.Price;

public interface Item {

    Price getPrice();
    String getLabel();

}
