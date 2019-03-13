package com.fulihui.redisdubbo.demo.integration.impl;

import com.fulihui.redisdubbo.demo.api.api.RedPackageGoodsService;
import com.fulihui.redisdubbo.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageGoodsRequest;
import com.fulihui.redisdubbo.demo.integration.RedPackageGoodsServiceClient;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-9-7
 */
@Component
public class RedPackageGoodsServiceClientImpl implements RedPackageGoodsServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    RedPackageGoodsService redPackageGoodsService;

    @Override
    public TPageResult<RedPackageGoodsDTO> list(RedPackageGoodsRequest request) {
        TPageResult<RedPackageGoodsDTO> result = redPackageGoodsService.list(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TPageResult<RedPackageGoodsDTO> listInAPI(RedPackageGoodsRequest request) {
        TPageResult<RedPackageGoodsDTO> result = redPackageGoodsService.listInAPI(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }
}
