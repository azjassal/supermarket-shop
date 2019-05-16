package com.example.supermarket.service;

import com.example.supermarket.domain.basket.Basket;
import com.example.supermarket.domain.discount.FixedPriceDiscount;
import com.example.supermarket.domain.discount.MultipleItemDiscount;
import com.example.supermarket.domain.item.PhysicalItem;
import com.example.supermarket.domain.price.SinglePrice;
import com.example.supermarket.domain.price.WeightPrice;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DiscountServiceTest {

    @Test
    public void testMultipleItemAndFixedPriceDiscountsAppliedToBasket() {
        DiscountService discountService = new DiscountService(new MultipleItemDiscount("Beans", 3, 2), new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00")));
        List<BigDecimal> discountAmounts = discountService.apply(sampleBasket());

        assertThat(discountAmounts, equalTo(asList(new BigDecimal("0.50"), new BigDecimal("0.40"))));
    }

    @Test
    public void testMultipleItemDiscountsAppliedToBasket() {
        DiscountService discountService = new DiscountService(new MultipleItemDiscount("Beans", 3, 2));
        List<BigDecimal> discountAmounts = discountService.apply(sampleBasket());

        assertThat(discountAmounts, equalTo(asList(new BigDecimal("0.50"))));
    }

    @Test
    public void testFixedPriceDiscountsAppliedToBasket() {
        DiscountService discountService = new DiscountService(new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00")));
        List<BigDecimal> discountAmounts = discountService.apply(sampleBasket());

        assertThat(discountAmounts, equalTo(asList(new BigDecimal("0.40"))));
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
