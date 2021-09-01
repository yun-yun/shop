package top.lyunk.ddd.shop.goods.persistence;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDO {
    /** 商品id */
    private Long goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 商品价格 */
    private BigDecimal goodsPrice;
    /** 商品价格 */
    private String goodsPriceCurrency;
}
