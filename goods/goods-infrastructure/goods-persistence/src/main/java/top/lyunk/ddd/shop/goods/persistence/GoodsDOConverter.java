package top.lyunk.ddd.shop.goods.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.lyunk.ddd.shop.goods.domain.entity.Goods;
import top.lyunk.ddd.shop.goods.types.Currency;
import top.lyunk.ddd.shop.goods.types.Money;
import top.lyunk.ddd.shop.goods.types.strategy.GoodsIdStrategy;
import top.lyunk.ddd.shop.goods.types.strategy.GoodsNameStrategy;

@Mapper(uses = {GoodsIdStrategy.class, GoodsNameStrategy.class})
public interface GoodsDOConverter {
    GoodsDOConverter INSTANCE = Mappers.getMapper(GoodsDOConverter.class);

    @Mapping(target = "goodsMoney", source = "source")
    Goods toEntity(GoodsDO goodsDO);

    /**
     * 用于映射Money的值
     * @param goodsDO
     * @return
     */
    default Money mapMoney(GoodsDO goodsDO){
        return new Money(goodsDO.goodsPrice(), goodsDO.goodsPriceCurrency());
    }

    // GoodsDO toDO(Goods goods);
}
