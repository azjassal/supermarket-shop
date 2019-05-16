package com.example.supermarket.service;

import com.example.supermarket.domain.basket.Basket;
import com.example.supermarket.domain.discount.FixedPriceDiscount;
import com.example.supermarket.domain.discount.MultipleItemDiscount;
import com.example.supermarket.domain.item.PhysicalItem;
import com.example.supermarket.domain.price.SinglePrice;
import com.example.supermarket.domain.price.WeightPrice;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutServiceTest {

    @Test
    public void testCheckoutTotalSavingsAmount() {
        CheckoutService checkoutService = new CheckoutService(sampleDiscountService());
        BigDecimal totalSavings = checkoutService.getTotalSavings(sampleBasket());

        assertThat(totalSavings, Matchers.comparesEqualTo(new BigDecimal("0.90")));
    }

    @Test
    public void testCheckoutTotalAmountToPay() {
        CheckoutService checkoutService = new CheckoutService(sampleDiscountService());
        BigDecimal totalToPay = checkoutService.getTotalToPay(sampleBasket());

        assertThat(totalToPay, Matchers.comparesEqualTo(new BigDecimal("2.40")));
    }

    private DiscountService sampleDiscountService() {
        return new DiscountService(new MultipleItemDiscount("Beans", 3, 2), new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00")));
    }

    private Basket sampleBasket() {
        Basket basket = new Basket();
        basket.addItem(
                new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
                new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
                new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
                new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"),
                new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"),
                new PhysicalItem(new WeightPrice(new BigDecimal("0.20"), new BigDecimal("1.99")), "Oranges")
        );
        return basket;
    }

}
