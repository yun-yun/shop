package top.lyunk.ddd.shop.goods.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lyunk.ddd.shop.common.web.Result;
import top.lyunk.ddd.shop.common.web.ResultCode;
import top.lyunk.ddd.shop.goods.application.dto.GoodsDTO;
import top.lyunk.ddd.shop.goods.application.service.GoodsService;
import top.lyunk.ddd.shop.goods.vo.GoodsVO;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/save")
    public Result<GoodsDTO> save(@RequestBody GoodsDTO dto){
        return ResultCode.SUCCESS.of(goodsService.save(dto));
    }
}
