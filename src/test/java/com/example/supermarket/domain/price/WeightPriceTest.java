package com.example.supermarket.domain.price;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;


public class WeightPriceTest {

    @Test
    public void testItemPriceBasedOnWeightWhenUnderUnit() {
        WeightPrice weightPrice = new WeightPrice(new BigDecimal("0.20"), new BigDecimal("1.99"));

        assertThat(weightPrice.getAmount(), comparesEqualTo(new BigDecimal("0.40")));
    }

    @Test
    public void testItemPriceBasedOnWeightWhenOverUnit() {
        WeightPrice weightPrice = new WeightPrice(new BigDecimal("2.00"), new BigDecimal("1.99"));

        assertThat(weightPrice.getAmount(), comparesEqualTo(new BigDecimal("3.98")));
    }

}
