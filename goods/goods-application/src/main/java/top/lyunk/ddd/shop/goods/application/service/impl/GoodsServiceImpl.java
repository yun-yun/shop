package top.lyunk.ddd.shop.goods.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lyunk.ddd.shop.goods.application.assembler.GoodsAssembler;
import top.lyunk.ddd.shop.goods.application.dto.GoodsDTO;
import top.lyunk.ddd.shop.goods.application.service.GoodsService;
import top.lyunk.ddd.shop.goods.domain.entity.Goods;
import top.lyunk.ddd.shop.goods.repository.GoodsRepository;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public GoodsDTO save(GoodsDTO dto) {
        Goods goods = GoodsAssembler.INSTANCE.toEntity(dto);
        Goods save = goodsRepository.save(goods);
        return GoodsAssembler.INSTANCE.toDTO(save);
    }
}
