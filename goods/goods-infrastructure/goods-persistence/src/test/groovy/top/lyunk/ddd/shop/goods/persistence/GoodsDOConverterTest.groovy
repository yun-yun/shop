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
        def goodsDO = new GoodsDO(goodsId, goodsName, goodsPrice, goodsPriceCurrency)

        when:
        def goods = GoodsDOConverter.INSTANCE.toEntity(goodsDO)

        then:
        goods.goodsId().value() == goodsId
        goods.goodsName().value() == goodsName
        goods.goodsMoney().amount() == goodsPrice
        goods.goodsMoney().currency().value() == goodsPriceCurrency
    }

    def "ToDO Test"() {
        given:
        def goodsId = 1L;
        def goodsName = "张三";
        def goodsPrice = BigDecimal.valueOf(10);
        def goodsPriceCurrency = "RMB";
        def goods = new Goods(new GoodsId(goodsId),
                new GoodsName(goodsName),
                new Money(goodsPrice, new Currency(goodsPriceCurrency)))

        when:
        def goodsDO = GoodsDOConverter.INSTANCE.toDO(goods)

        then:
        goodsDO.goodsId() == goodsId
        goodsDO.goodsName() == goodsName
        goodsDO.goodsPrice() == goodsPrice
        goodsDO.goodsPriceCurrency() == goodsPriceCurrency
    }
}
