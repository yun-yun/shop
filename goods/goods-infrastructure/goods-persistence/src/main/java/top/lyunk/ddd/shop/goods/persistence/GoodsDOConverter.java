package top.lyunk.ddd.shop.goods.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.lyunk.ddd.shop.goods.domain.entity.Goods;
import top.lyunk.ddd.shop.goods.types.strategy.GoodsIdStrategy;
import top.lyunk.ddd.shop.goods.types.strategy.GoodsNameStrategy;

@Mapper(uses = {GoodsIdStrategy.class, GoodsNameStrategy.class})
public interface GoodsDOConverter {
    GoodsDOConverter INSTANCE = Mappers.getMapper(GoodsDOConverter.class);


    @Mapping(expression = "java(new top.lyunk.ddd.shop.goods.types.Money(goodsDO.getGoodsPrice(), new top.lyunk.ddd.shop.goods.types.Currency(goodsDO.getGoodsPriceCurrency())))",
            target = "goodsPrice")
    // @Mapping(source = "goodsPriceCurrency", target = null, ignore = true)
    Goods toEntity(GoodsDO goodsDO);

    @Mapping(expression = "java(goods.getGoodsPrice().getAmount())", target = "goodsPrice")
    @Mapping(expression = "java(goods.getGoodsPrice().getCurrency().value())", target = "goodsPriceCurrency")
    GoodsDO toDO(Goods goods);
}
