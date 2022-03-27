package top.lyunk.ddd.shop.goods.domain.entity;

import top.lyunk.ddd.shop.goods.types.GoodsId;
import top.lyunk.ddd.shop.goods.types.GoodsName;
import top.lyunk.ddd.shop.goods.types.Money;

public record Goods(
        /* 商品id */
        GoodsId goodsId,
        /* 商品名称 */
        GoodsName goodsName,
        /* 商品价格&货币 */
        Money goodsMoney
) {
}
