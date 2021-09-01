package top.lyunk.ddd.shop.goods.types;

import lombok.Data;
import top.lyunk.ddd.shop.goods.exception.IllegalAmountException;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 金额
 */
@Data
public final class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw IllegalAmountException.ofAmount(amount);
        }
        if (amount.scale() > 2) {
            throw IllegalAmountException.ofScale(amount.scale());
        }

        this.amount = amount;
        this.currency = currency;
    }
}
