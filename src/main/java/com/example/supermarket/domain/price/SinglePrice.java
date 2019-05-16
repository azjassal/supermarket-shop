package com.example.supermarket.domain.price;

import java.math.BigDecimal;
import java.util.Objects;

public class SinglePrice implements Price {

    private BigDecimal amount;

    public SinglePrice(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglePrice that = (SinglePrice) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "SinglePrice{" +
                "amount=" + amount +
                '}';
    }

}
