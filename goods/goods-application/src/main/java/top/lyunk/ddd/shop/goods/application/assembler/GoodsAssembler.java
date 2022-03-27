package top.lyunk.ddd.shop.goods.application.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import top.lyunk.ddd.shop.goods.application.dto.GoodsDTO;
import top.lyunk.ddd.shop.goods.domain.entity.Goods;
import top.lyunk.ddd.shop.goods.types.strategy.GoodsIdStrategy;
import top.lyunk.ddd.shop.goods.types.strategy.GoodsNameStrategy;

/**
 * Goods DTO Assembler
 */
@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        uses = {GoodsAssembler.class, GoodsIdStrategy.class, GoodsNameStrategy.class}
)
public interface GoodsAssembler {
    GoodsAssembler INSTANCE = Mappers.getMapper(GoodsAssembler.class);


    /**
     * 通过各种实体，生成DTO
     *
     * @param goods 商品实体
     * @return 商品DTO
     */
    GoodsDTO toDTO(Goods goods);

    /**
     * 通过DTO，生成实体
     *
     * @param goodsDTO 商品DTO
     * @return 商品实体
     */
    Goods toEntity(GoodsDTO goodsDTO);
}
