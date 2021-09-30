package top.lyunk.ddd.shop.goods.persistence;

import lombok.Data;

import java.math.BigDecimal;

public record GoodsDO(
        /* 商品id */
        Long goodsId,
        /* 商品名称 */
        String goodsName,
        /* 商品价格 */
        BigDecimal goodsPrice,
        /* 商品价格 */
        String goodsPriceCurrency
) {
}
