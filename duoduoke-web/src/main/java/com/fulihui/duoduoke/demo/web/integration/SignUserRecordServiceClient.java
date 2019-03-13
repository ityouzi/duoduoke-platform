package com.fulihui.duoduoke.demo.web.integration;


import com.fulihui.duoduoke.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.duoduoke.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.duoduoke.demo.api.response.ProbabilityDrawResponse;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 *
 * @author lizhi
 * @date 2018-10-11
 */
public interface SignUserRecordServiceClient {

    TMultiResult<SignUserRecordDTO> querySign(SignUserRecordRequest request);

    TPageResult<SignUserRecordDTO> queryPage(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> sign(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> queryByPk(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> supplementSign(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> modifyLotteryCount(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> querySignByUser(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> takeShareCount(SignUserRecordRequest request);

    TSingleResult<ProbabilityDrawResponse> probabilityDraw(SignUserRecordRequest request);

}
