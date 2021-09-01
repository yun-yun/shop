package top.lyunk.ddd.shop.goods.types.strategy;

import top.lyunk.ddd.shop.common.util.Optional;
import top.lyunk.ddd.shop.goods.types.GoodsName;

public class GoodsNameStrategy {
    public String goodsNameToString(GoodsName goodsName){
        return Optional.ofNullable(goodsName).doIfPresent(GoodsName::value);
    }

    public GoodsName stringToGoodsName(String goodsName){
        return Optional.ofNullable(goodsName).doIfPresent(GoodsName::new);
    }
}
