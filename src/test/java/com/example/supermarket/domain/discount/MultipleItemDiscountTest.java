package com.example.supermarket.domain.discount;

import com.example.supermarket.domain.item.ItemGroup;
import com.example.supermarket.domain.item.PhysicalItem;
import com.example.supermarket.domain.price.SinglePrice;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class MultipleItemDiscountTest {

    @Test
    public void testMultipleItemDiscount3ForPriceOf2With3Items() {
        MultipleItemDiscount discount = new MultipleItemDiscount("Beans", 3, 2);

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"), 3
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.50")));
    }

    @Test
    public void testMultipleItemDiscount3ForPriceOf2With6Items() {
        MultipleItemDiscount discount = new MultipleItemDiscount("Beans", 3, 2);

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"), 6
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("1.00")));
    }

    @Test
    public void ttestMultipleItemDiscount3ForPriceOf2With5Items() {
        MultipleItemDiscount discount = new MultipleItemDiscount("Beans", 3, 2);

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"), 5
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.50")));
    }

    @Test
    public void testMultipleItemDiscount3ForPriceOf2With1Item() {
        MultipleItemDiscount discount = new MultipleItemDiscount("Beans", 3, 2);

        BigDecimal totalDiscount = discount.apply(new ItemGroup(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"), 1
        ));

        assertThat(totalDiscount, comparesEqualTo(new BigDecimal("0.00")));
    }

}
