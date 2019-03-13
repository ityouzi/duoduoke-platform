package com.fulihui.redisdubbo.demo.integration.impl;


import com.fulihui.redisdubbo.demo.api.api.sign.SignUserRecordService;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.redisdubbo.demo.api.response.ProbabilityDrawResponse;
import com.fulihui.redisdubbo.demo.integration.SignUserRecordServiceClient;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-10-11
 */
@Component
public class SignUserRecordServiceClientImpl implements SignUserRecordServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    SignUserRecordService signUserRecordService;

    @Override
    public TMultiResult<SignUserRecordDTO> querySign(SignUserRecordRequest request) {
        TMultiResult result = signUserRecordService.querySign(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TPageResult<SignUserRecordDTO> queryPage(SignUserRecordRequest request) {
        TPageResult<SignUserRecordDTO> result = signUserRecordService.queryPage(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> sign(SignUserRecordRequest request) {
        TSingleResult<SignUserRecordDTO> result = signUserRecordService.sign(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> queryByPk(SignUserRecordRequest request) {
        TSingleResult<SignUserRecordDTO> result = signUserRecordService.queryByPk(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> supplementSign(SignUserRecordRequest request) {
        TSingleResult<SignUserRecordDTO> result = signUserRecordService.supplementSign(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> modifyLotteryCount(SignUserRecordRequest request) {
        TSingleResult<SignUserRecordDTO> result = signUserRecordService.modifyLotteryCount(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> querySignByUser(SignUserRecordRequest request) {
        TSingleResult<SignUserRecordDTO> result = signUserRecordService.querySignByUser(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<SignUserRecordDTO> takeShareCount(SignUserRecordRequest request) {
        TSingleResult<SignUserRecordDTO> result = signUserRecordService.takeShareCount(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<ProbabilityDrawResponse> probabilityDraw(SignUserRecordRequest request) {
        TSingleResult<ProbabilityDrawResponse> result = signUserRecordService
            .probabilityDraw(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

}
