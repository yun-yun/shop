package top.lyunk.ddd.shop.goods.domain.entity;

import lombok.Data;
import top.lyunk.ddd.shop.goods.types.GoodsId;
import top.lyunk.ddd.shop.goods.types.GoodsName;
import top.lyunk.ddd.shop.goods.types.Money;

@Data
public class Goods {
    /** 商品id */
    private GoodsId goodsId;
    /** 商品名称 */
    private GoodsName goodsName;
    /** 商品价格 */
    private Money goodsPrice;
}
