package com.example.supermarket.service;

import com.example.supermarket.domain.basket.Basket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckoutService {

    private DiscountService discountService;

    public CheckoutService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public BigDecimal getTotalSavings(Basket basket) {
        return discountService.apply(basket).stream().reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getTotalToPay(Basket basket) {
        return basket.getSubTotal().subtract(getTotalSavings(basket));
    }

}
