package top.lyunk.ddd.shop.goods.types;

import cn.hutool.core.util.NumberUtil;
import lombok.Data;
import top.lyunk.ddd.shop.goods.exception.IllegalAmountException;

import java.math.BigDecimal;

/**
 * 金额
 */
public record Money(BigDecimal amount, Currency currency) {
    /**
     * 最大精度（小数位数）
     */
    private static final int MAX_SCALE = 2;

    public Money {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw IllegalAmountException.ofAmount(amount);
        }
        if (amount.scale() > MAX_SCALE) {
            throw IllegalAmountException.ofScale(amount.scale());
        }
    }

    public Money(BigDecimal amount, String currency) {
        this(amount, new Currency(currency));
    }
}
