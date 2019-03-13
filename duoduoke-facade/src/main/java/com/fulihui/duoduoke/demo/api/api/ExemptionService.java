package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.ExemptionRequest;
import com.fulihui.duoduoke.demo.api.request.IdRequest;
import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface ExemptionService {

    /**
     * @param request
     * @return
     */
    TMultiResult<ExemptionGoodsDTO> query(ExemptionRequest request);

    /**
     * 分页查询
     * @param request
     * @return
     */
    TPageResult<ExemptionGoodsDTO> queryPage(ExemptionRequest request);

    /**
     * 插入数据
     * @param
     * @return
     */
    TSingleResult<Boolean> insert(ExemptionGoodsDTO exemptionGoodsDTO);

    /**
     * 修改数据
     * @param
     * @return
     */
    TSingleResult<Boolean> update(ExemptionGoodsDTO exemptionGoodsDTO);

    /**
     * 删除
     * @param request
     * @return
     */
    TSingleResult<Boolean> del(IdRequest request);

    TSingleResult<ExemptionGoodsDTO> selectByPrimaryKey(IdRequest request);

    boolean modifyNum(ExemptionGoodsDTO exemptionGoodsDTO);


    /**
     * 商品剩余数量-1 ，领取数量 +1
     * 查询条件 id
     */
    boolean addReceiveNum(ExemptionGoodsDTO request);


    /**
     * 商品剩余数量+1 ，领取数量 -1
     * 查询条件 id
     */
    boolean subReceiveNum(ExemptionGoodsDTO request);

}
