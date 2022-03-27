package top.lyunk.ddd.shop.goods.types.strategy;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import top.lyunk.ddd.shop.common.util.Optional;
import top.lyunk.ddd.shop.goods.types.Currency;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public class CurrencyStrategy {
    public String currencyToLong(Currency currency){
        return Optional.ofNullable(currency).doIfPresent(Currency::value);
    }

    public Currency longToCurrency(String currency){
        return Optional.ofNullable(currency).doIfPresent(Currency::new);
    }
}
