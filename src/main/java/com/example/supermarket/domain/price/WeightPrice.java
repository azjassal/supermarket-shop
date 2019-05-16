package com.example.supermarket.domain.price;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class WeightPrice implements Price {

    private BigDecimal weight;
    private BigDecimal amount;

    public WeightPrice(BigDecimal weight, BigDecimal amount) {
        this.weight = weight;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return weight.multiply(amount).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightPrice that = (WeightPrice) o;
        return Objects.equals(weight, that.weight) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, amount);
    }

}
