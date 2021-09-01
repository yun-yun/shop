package top.lyunk.ddd.shop.goods.application.dto;

import lombok.Data;
import top.lyunk.ddd.shop.goods.types.GoodsId;
import top.lyunk.ddd.shop.goods.types.GoodsName;
import top.lyunk.ddd.shop.goods.types.Money;

@Data
public class GoodsDTO {
    /** 商品id */
    private Long goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 商品价格 */
    private Money goodsPrice;
}
