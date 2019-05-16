package com.example.supermarket;

import com.example.supermarket.domain.basket.Basket;
import com.example.supermarket.domain.discount.FixedPriceDiscount;
import com.example.supermarket.domain.discount.MultipleItemDiscount;
import com.example.supermarket.domain.item.PhysicalItem;
import com.example.supermarket.domain.price.SinglePrice;
import com.example.supermarket.domain.price.WeightPrice;
import com.example.supermarket.service.CheckoutService;
import com.example.supermarket.service.DiscountService;

import java.math.BigDecimal;

public class SupermarketShop {

    public static void main(String[] args) {
        // My supermarket shop today:
        Basket basket = new Basket();
        basket.addItem(
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.50")), "Beans"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"),
            new PhysicalItem(new SinglePrice(new BigDecimal("0.70")), "Coke"),
            new PhysicalItem(new WeightPrice(new BigDecimal("0.20"), new BigDecimal("1.99")), "Oranges")
        );

        // Discounts offered by the supermarket today:
        DiscountService discountService = new DiscountService(new MultipleItemDiscount("Beans", 3, 2), new FixedPriceDiscount("Coke", 2, new BigDecimal("1.00")));

        // Lets checkout
        CheckoutService checkoutService = new CheckoutService(discountService);

        System.out.println(basket);
        System.out.println("Sub-total: " + basket.getSubTotal());
        System.out.println("Total savings: " + checkoutService.getTotalSavings(basket));
        System.out.println("Total to pay: " + checkoutService.getTotalToPay(basket));

    }

}
