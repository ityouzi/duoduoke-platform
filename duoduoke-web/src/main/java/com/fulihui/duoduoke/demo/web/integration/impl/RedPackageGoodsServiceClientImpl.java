package com.fulihui.duoduoke.demo.web.integration.impl;

import com.fulihui.duoduoke.demo.api.api.RedPackageGoodsService;
import com.fulihui.duoduoke.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.duoduoke.demo.api.request.RedPackageGoodsRequest;
import com.fulihui.duoduoke.demo.web.integration.RedPackageGoodsServiceClient;
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
