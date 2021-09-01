package top.lyunk.ddd.shop.goods.repository;

import top.lyunk.ddd.shop.goods.domain.entity.Goods;
import top.lyunk.ddd.shop.goods.types.GoodsId;

/**
 * 商品存储接口
 * 由实现类调用具体框架
 */
public interface GoodsRepository {
    Goods find(GoodsId id);
    Goods save(Goods account);
    Goods remove(GoodsId id);
}
