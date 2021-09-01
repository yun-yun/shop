package top.lyunk.ddd.shop.goods.exception;

import java.math.BigDecimal;

/**
 * 不合法的金额值
 */
public class IllegalAmountException extends RuntimeException {
    public static IllegalAmountException ofAmount(BigDecimal amount) {
        return new IllegalAmountException(
                String.format("不合法的金额:[%s]", amount.toString()));
    }

    public static IllegalAmountException ofScale(int scale) {
        return new IllegalAmountException(
                String.format("不合法的金额精度:[%s]", scale));
    }

    private IllegalAmountException(String msg) {
        super(msg);
    }
}
