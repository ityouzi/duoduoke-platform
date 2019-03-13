package com.fulihui.redisdubbo.demo.manager;


import com.fulihui.redisdubbo.demo.api.dto.DuoduoGoodsInfoDTO;
import com.fulihui.redisdubbo.demo.vo.GoodsInfo;
import org.near.webmvcsupport.view.PageForm;
import org.near.webmvcsupport.view.PageView;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lizhi
 * @date 2018-9-10
 */
public interface GoodsInfoManager {

    List<GoodsInfo> toVOList(List<DuoduoGoodsInfoDTO> list);

    GoodsInfo toVO(DuoduoGoodsInfoDTO dto, BigDecimal yuanBig, Integer commission,
                   Integer shareProportion);

    /**
     * 热推爆品商品列表
     * @param pageForm
     * @return
     */
    PageView<GoodsInfo> hotPushGoods(PageForm pageForm);

}
