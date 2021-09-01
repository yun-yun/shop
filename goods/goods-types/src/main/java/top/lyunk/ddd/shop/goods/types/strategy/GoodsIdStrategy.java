package top.lyunk.ddd.shop.goods.types.strategy;

import top.lyunk.ddd.shop.common.util.Optional;
import top.lyunk.ddd.shop.goods.types.GoodsId;

public class GoodsIdStrategy {
    public Long goodsIdToLong(GoodsId goodsId){
        return Optional.ofNullable(goodsId).doIfPresent(GoodsId::value);
    }

    public GoodsId longToGoodsId(Long goodsId){
        return Optional.ofNullable(goodsId).doIfPresent(GoodsId::new);
    }
}
