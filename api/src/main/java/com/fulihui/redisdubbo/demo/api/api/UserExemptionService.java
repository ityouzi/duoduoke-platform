package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.UserExemptionGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.IdRequest;
import com.fulihui.redisdubbo.demo.api.request.UserExemptionRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface UserExemptionService {

    /**
     * @param
     * @return
     */
    TMultiResult<UserExemptionGoodsDTO> query(UserExemptionGoodsDTO userExemptionGoodsDTO);

    /**
     * 插入数据
     * @param
     * @return
     */
    TSingleResult<Boolean> insert(UserExemptionGoodsDTO userExemptionGoodsDTO);

    /**
     * 修改数据
     * @param
     * @return
     */
    TSingleResult<Boolean> update(UserExemptionGoodsDTO userExemptionGoodsDTO);

    BaseResult robbingOrder(UserExemptionRequest userExemptionRequest);

    /**
     * 删除
     * @param request
     * @return
     */
    TSingleResult<Boolean> del(IdRequest request);

    TSingleResult<UserExemptionGoodsDTO> selectByPrimaryKey(IdRequest request);

    TPageResult<UserExemptionGoodsDTO> queryReceipt(IdRequest request);

    TSingleResult<UserExemptionGoodsDTO> confirmReceipt(IdRequest request);

    BaseResult updateStateAndNums(UserExemptionGoodsDTO userExemptionGoodsDTO);

}
