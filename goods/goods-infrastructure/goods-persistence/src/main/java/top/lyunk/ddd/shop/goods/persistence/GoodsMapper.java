package top.lyunk.ddd.shop.goods.persistence;

public interface GoodsMapper {
    GoodsDO selectById(Long id);
    int insert(GoodsDO goodsDO);

    int update(GoodsDO goodsDO);

    int deleteById(Long id);
}
