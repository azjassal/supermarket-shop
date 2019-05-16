package com.example.supermarket.domain.discount;

import com.example.supermarket.domain.item.ItemGroup;
import com.example.supermarket.domain.item.PhysicalItem;
import com.example.supermarket.domain.price.SinglePrice;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class FixedPriceDiscountTest {

    @Test
    public void testFixedPriceDiscount2ForPriceOf1PoundWhen2InBasket() {
        FixedPriceDiscount discount = new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00"));

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"), 2
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.40")));
    }

    @Test
    public void testFixedPriceDiscount2ForPriceOf1PoundWhen4InBasket() {
        FixedPriceDiscount discount = new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00"));

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"), 4
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.80")));
    }

    @Test
    public void testFixedPriceDiscount2ForPriceOf1PoundWhen3InBasket() {
        FixedPriceDiscount discount = new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00"));

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"), 3
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.40")));
    }

    @Test
    public void testFixedPriceDiscount2ForPriceOf1PoundWhen1InBasket() {
        FixedPriceDiscount discount = new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00"));

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"), 1
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.00")));
    }

    @Test
    public void testFixedPriceDiscount3ForPriceOf1PoundWhen3InBasket() {
        FixedPriceDiscount discount = new FixedPriceDiscount("Coke", 3, new BigDecimal("1.00"));

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"), 3
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("1.10")));
    }

}
