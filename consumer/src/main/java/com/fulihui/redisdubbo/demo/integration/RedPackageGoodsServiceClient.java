package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageGoodsRequest;
import org.near.servicesupport.result.TPageResult;

/**
 * @author: JY
 * @date: 2018/9/3 15:24
 */
public interface RedPackageGoodsServiceClient {

    /**
     * 列表数据
     * @param request
     * @return
     */
    TPageResult<RedPackageGoodsDTO> list(RedPackageGoodsRequest request);

    TPageResult<RedPackageGoodsDTO> listInAPI(RedPackageGoodsRequest request);

}
