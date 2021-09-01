package top.lyunk.ddd.shop.goods.application.assembler

import spock.lang.Specification
import top.lyunk.ddd.shop.goods.application.dto.GoodsDTO
import top.lyunk.ddd.shop.goods.domain.entity.Goods
import top.lyunk.ddd.shop.goods.types.Currency
import top.lyunk.ddd.shop.goods.types.GoodsId
import top.lyunk.ddd.shop.goods.types.GoodsName
import top.lyunk.ddd.shop.goods.types.Money

class GoodsAssemblerTest extends Specification {
    def "ToDTO Test"() {
        given:
        def goodsId = 1L
        def goodsName = "礼品"
        def goodsPrice = 10
        def goodsPriceCurrency = "RMB"
        def goods = new Goods();
        goods.setGoodsId(new GoodsId(goodsId))
        goods.setGoodsName(new GoodsName(goodsName))
        goods.setGoodsPrice(new Money(BigDecimal.valueOf(goodsPrice), new Currency(goodsPriceCurrency)))


        when:
        def goodsDTO = GoodsAssembler.INSTANCE.toDTO(goods)

        then:
        goodsDTO.goodsId == goodsId
        goodsDTO.goodsName == goodsName
        goodsDTO.goodsPrice.amount.toInteger() == goodsPrice
        goodsDTO.goodsPrice.currency.value() == goodsPriceCurrency

    }

    def "ToEntity Test"() {
        given:
        def goodsId = 1L
        def goodsName = "礼品"
        def goodsPrice = 10
        def goodsPriceCurrency = "RMB"
        def goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsId(goodsId)
        goodsDTO.setGoodsName(goodsName)
        goodsDTO.setGoodsPrice(new Money(BigDecimal.valueOf(goodsPrice), new Currency(goodsPriceCurrency)))


        when:
        def goods = GoodsAssembler.INSTANCE.toEntity(goodsDTO)

        then:
        goods.goodsId.value() == goodsId
        goods.goodsName.value() == goodsName
        goods.goodsPrice.amount.toInteger() == goodsPrice
        goods.goodsPrice.currency.value() == goodsPriceCurrency
    }
}
