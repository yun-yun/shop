// package top.lyunk.ddd.shop.goods.persistence.impl;
//
// import top.lyunk.ddd.shop.common.util.Optional;
// import top.lyunk.ddd.shop.goods.domain.entity.Goods;
// import top.lyunk.ddd.shop.goods.persistence.GoodsBuilder;
// import top.lyunk.ddd.shop.goods.persistence.GoodsDO;
// import top.lyunk.ddd.shop.goods.types.GoodsId;
//
//
// public class GoodsBuilderImpl implements GoodsBuilder {
//     @Override
//     public Goods toGoods(GoodsDO goodsDO) throws Exception {
//         Goods entity = new Goods();
//         entity.setGoodsId(new GoodsId(goodsDO.getGoodsId()));
//         return entity;
//     }
//
//     @Override
//     public GoodsDO fromGoods(Goods goods) {
//         GoodsDO aDo = new GoodsDO();
//         aDo.setGoodsId(Optional.ofNullable(goods.getGoodsId()).doIfPresent(GoodsId::value));
//         return aDo;
//     }
// }
