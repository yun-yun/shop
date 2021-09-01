package top.lyunk.ddd.shop.goods.types.strategy;

import top.lyunk.ddd.shop.common.util.Optional;
import top.lyunk.ddd.shop.goods.types.Currency;

public class CurrencyStrategy {
    public String currencyToLong(Currency currency){
        return Optional.ofNullable(currency).doIfPresent(Currency::value);
    }

    public Currency longToCurrency(String currency){
        return Optional.ofNullable(currency).doIfPresent(Currency::new);
    }
}
