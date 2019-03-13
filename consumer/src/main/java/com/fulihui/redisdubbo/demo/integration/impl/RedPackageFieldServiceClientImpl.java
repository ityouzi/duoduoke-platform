package com.fulihui.redisdubbo.demo.integration.impl;


import com.fulihui.redisdubbo.demo.api.api.RedPackageFieldService;
import com.fulihui.redisdubbo.demo.api.dto.RedPackageFieldDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserRedPackageRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageFieldRequest;
import com.fulihui.redisdubbo.demo.api.request.UserRedPackageRecordRequest;
import com.fulihui.redisdubbo.demo.integration.RedPackageFieldServiceClient;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-9-7
 */
@Component
public class RedPackageFieldServiceClientImpl implements RedPackageFieldServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    RedPackageFieldService redPackageFieldService;

    @Override
    public TPageResult<RedPackageFieldDTO> list(RedPackageFieldRequest request) {
        TPageResult<RedPackageFieldDTO> result = redPackageFieldService.list(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TMultiResult<UserRedPackageRecordDTO> queryRecord(UserRedPackageRecordRequest request) {
        TMultiResult<UserRedPackageRecordDTO> result = redPackageFieldService.queryRecord(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public Boolean update(UserRedPackageRecordDTO dto) {
        return redPackageFieldService.update(dto);

    }

    @Override
    public Long insertUserRedPackage(UserRedPackageRecordDTO dto) {
        return redPackageFieldService.insertUserRedPackage(dto);

    }
}
