package com.example.supermarket.domain.basket;

import com.example.supermarket.domain.item.PhysicalItem;
import com.example.supermarket.domain.price.SinglePrice;
import com.example.supermarket.domain.price.WeightPrice;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class BasketTest {

    @Test
    public void testSubtotalForItemsInBasket() {
        Basket basket = new Basket();
        basket.addItem(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"),
            new PhysicalItem(new WeightPrice(new BigDecimal("0.20"), new BigDecimal("1.99")), "Oranges")
        );

        assertThat(basket.getSubTotal(), comparesEqualTo(new BigDecimal("3.30")));
    }

}
