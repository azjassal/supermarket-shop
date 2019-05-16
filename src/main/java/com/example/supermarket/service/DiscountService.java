package com.example.supermarket.service;

import com.example.supermarket.domain.basket.Basket;
import com.example.supermarket.domain.discount.Discount;
import com.example.supermarket.domain.item.Item;
import com.example.supermarket.domain.item.ItemGroup;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class DiscountService {

    private List<Discount> discounts;

    public DiscountService(Discount... discounts) {
        this.discounts = asList(discounts);
    }

    public List<BigDecimal> apply(Basket basket) {
        Map<Item, Long> groupedItems = basket.getItems().stream().collect(groupingBy(identity(), counting()));

        return groupedItems.entrySet().stream()
            .map(es ->
                getDiscountForLabel(es.getKey().getLabel(), discounts)
                    .map(discount -> discount.apply(new ItemGroup(es.getKey(), es.getValue().intValue())))
            )
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(toList());
    }

    private Optional<Discount> getDiscountForLabel(String label, List<Discount> discounts) {
        return discounts.stream().filter(discount -> discount.getLabel().equals(label)).findFirst();
    }

}
