package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageGoodsRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author: JY
 * @date: 2018/9/3 15:24
 */
public interface RedPackageGoodsService {

    /**
     * 插入数据
     * @param goodsDTO
     * @return
     */
    TSingleResult<Boolean> insert(RedPackageGoodsDTO goodsDTO);

    /**
     * 列表数据
     * @param request
     * @return
     */
    TPageResult<RedPackageGoodsDTO> list(RedPackageGoodsRequest request);

    /**
     * 直接查询平多多接口数据
     * @param request
     * @return
     */
    TPageResult<RedPackageGoodsDTO> listInAPI(RedPackageGoodsRequest request);

    /**
     * 删除单个
     * @param id
     * @return
     */
    TSingleResult<Boolean> remove(Integer id);

    /**
     * 删除所有
     * @param rpfId
     * @param rpfType
     * @return
     */
    TSingleResult<Boolean> removeAll(Integer rpfId, Integer rpfType);

    /**
     * 修改状态
     * @param id
     * @param sort
     * @return
     */
    TSingleResult<Boolean> modifySort(Integer id, Integer sort);

    /**
     * 刷新商品
     * @return
     */
    TSingleResult<Boolean> refreshGoods();

}
