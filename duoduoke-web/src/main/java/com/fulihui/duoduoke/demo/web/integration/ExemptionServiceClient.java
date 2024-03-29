package com.fulihui.duoduoke.demo.web.integration;


import com.fulihui.duoduoke.demo.api.dto.ActivityConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.dto.UserExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.request.ExemptionRequest;
import com.fulihui.duoduoke.demo.api.request.IdRequest;
import com.fulihui.duoduoke.demo.web.param.ExemptionGoodsParam;
import com.fulihui.duoduoke.demo.web.vo.ExemptionActivityVO;
import com.fulihui.duoduoke.demo.web.vo.ExemptionGoodsVO;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.webmvcsupport.view.PageView;

import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 9:48
 */
public interface ExemptionServiceClient {
    TMultiResult<ExemptionGoodsDTO> query(ExemptionRequest request);

    ExemptionGoodsDTO select(IdRequest idRequest);

    List<UserExemptionGoodsDTO> queryUserExemptionGoods(UserExemptionGoodsDTO userExemptionGoodsDTO);

    Boolean insertUserExemption(UserExemptionGoodsDTO userExemptionGoodsDTO);

    ActivityConfigDTO queryActivity(Integer id);

    /**
     * 查询当前免单活动信息
     * @return
     */
    ExemptionActivityVO getExemption();

    /**
     * 查询免单商品信息
     * @param request
     * @return
     */
    PageView<ExemptionGoodsVO> list(ExemptionGoodsParam request);

    boolean modifyNum(ExemptionGoodsDTO exemptionGoodsDTO);



    BaseResult robbingOrder(ExemptionGoodsDTO exemptionGoodsDTO, UserExemptionGoodsDTO userExemptionGoodsDTO);

    boolean subNum(ExemptionGoodsDTO exemptionGoodsDTO);

}
