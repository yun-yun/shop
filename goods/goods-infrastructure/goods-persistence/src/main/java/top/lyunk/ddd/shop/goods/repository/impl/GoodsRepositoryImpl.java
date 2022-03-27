package top.lyunk.ddd.shop.goods.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lyunk.ddd.shop.goods.domain.entity.Goods;
import top.lyunk.ddd.shop.goods.persistence.GoodsDO;
import top.lyunk.ddd.shop.goods.persistence.GoodsDOConverter;
import top.lyunk.ddd.shop.goods.persistence.GoodsMapper;
import top.lyunk.ddd.shop.goods.repository.GoodsRepository;
import top.lyunk.ddd.shop.goods.types.GoodsId;

/**
 * 商品持久化接口实现类
 */
@Slf4j
@Service
public class GoodsRepositoryImpl implements GoodsRepository {
    // @Autowired
    private GoodsMapper goodsDAO;

    @Override
    public Goods find(GoodsId id) {
        GoodsDO goodsDO = goodsDAO.selectById(id.value());
        log.debug("查找, Id:[{}], 查找到记录:[{}]", id, goodsDO);
        return GoodsDOConverter.INSTANCE.toEntity(goodsDO);
    }

    @Override
    public Goods save(Goods goods) {
        Goods e = find(goods.goodsId());
        log.debug("保存, 待被覆盖记录:[{}]", goods);
        GoodsDO goodsDO = GoodsDOConverter.INSTANCE.toDO(goods);
        log.debug("保存, 待保存记录:[{}]", goodsDO);
        if (e == null) {
            log.debug("保存, 新增:[{}]", goodsDO);
            goodsDAO.insert(goodsDO);
        } else {
            log.debug("保存, 更新:[{}]", goodsDO);
            goodsDAO.update(goodsDO);
        }
        return GoodsDOConverter.INSTANCE.toEntity(goodsDO);
    }

    @Override
    public Goods remove(GoodsId id) {
        Goods goods = find(id);
        log.debug("删除, Id:[{}], 待删除记录:[{}]", id, goods);
        int i = goodsDAO.deleteById(id.value());
        log.debug("删除, Id:[{}], 删除条数:[{}]", id, i);
        return goods;
    }
}
