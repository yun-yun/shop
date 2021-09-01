package top.lyunk.ddd.shop.goods.persistence

import spock.lang.Specification
import top.lyunk.ddd.shop.goods.domain.entity.Goods
import top.lyunk.ddd.shop.goods.types.Currency
import top.lyunk.ddd.shop.goods.types.GoodsId
import top.lyunk.ddd.shop.goods.types.GoodsName
import top.lyunk.ddd.shop.goods.types.Money

class GoodsDOConverterTest extends Specification {
    def "ToEntity Test"() {
        given:
        def goodsId = 1L;
        def goodsName = "张三";
        def goodsPrice = BigDecimal.valueOf(10);
        def goodsPriceCurrency = "RMB";
        def goodsDO = new GoodsDO()
        goodsDO.setGoodsId(goodsId);
        goodsDO.setGoodsName(goodsName);
        goodsDO.setGoodsPrice(goodsPrice);
        goodsDO.setGoodsPriceCurrency(goodsPriceCurrency);

        when:
        def goods = GoodsDOConverter.INSTANCE.toEntity(goodsDO)

        then:
        goods.getGoodsId().value() == goodsId
        goods.getGoodsName().value() == goodsName
        goods.getGoodsPrice().getAmount() == goodsPrice
        goods.getGoodsPrice().getCurrency().value() == goodsPriceCurrency
    }

    def "ToDO Test"() {
        given:
        def goodsId = 1L;
        def goodsName = "张三";
        def goodsPrice = BigDecimal.valueOf(10);
        def goodsPriceCurrency = "RMB";
        def goods = new Goods()
        goods.setGoodsId(new GoodsId(goodsId));
        goods.setGoodsName(new GoodsName(goodsName));
        goods.setGoodsPrice(new Money(goodsPrice, new Currency(goodsPriceCurrency)));

        when:
        def goodsDO = GoodsDOConverter.INSTANCE.toDO(goods)

        then:
        goodsDO.getGoodsId() == goodsId
        goodsDO.getGoodsName() == goodsName
        goodsDO.getGoodsPrice() == goodsPrice
        goodsDO.getGoodsPriceCurrency() == goodsPriceCurrency
    }
}
