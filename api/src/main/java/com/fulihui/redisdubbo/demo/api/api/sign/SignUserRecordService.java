package com.fulihui.redisdubbo.demo.api.api.sign;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.redisdubbo.demo.api.response.ProbabilityDrawResponse;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface Sign user record service.
 *
 * @author lizhi
 * @date 2018 -10-11
 */
public interface SignUserRecordService {

    /**
     * 用户签到
     *
     * @param request the request
     * @return the t single result
     */
    TSingleResult<SignUserRecordDTO> sign(SignUserRecordRequest request);

    /**
     * 查询用户当前签到情况
     *
     * @param request the request
     * @return the t multi resultSignUserRecordRequest
     */
    TMultiResult<SignUserRecordDTO> querySign(SignUserRecordRequest request);

    /**
     * 查询用户 签到流水信息
     *
     * @param request the request
     * @return the t multi resultSignUserRecordRequest
     */
    TPageResult<SignUserRecordDTO> queryPage(SignUserRecordRequest request);

    /**
     * 分享加翻牌机会
     *
     * @param request the request
     * @return the t single result
     */
    TSingleResult<SignUserRecordDTO> takeShareCount(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> querySignByUser(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> supplementSign(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> modifyLotteryCount(SignUserRecordRequest request);

    TSingleResult<SignUserRecordDTO> queryByPk(SignUserRecordRequest request);

    TSingleResult<ProbabilityDrawResponse> probabilityDraw(SignUserRecordRequest request);

    TMultiResult<SignUserRecordDTO> queryCurrentCycle(SignUserRecordRequest request);

    TMultiResult<SignUserRecordDTO> queryNearingEnd(SignUserRecordRequest request);

    TMultiResult<SignUserRecordDTO> queryBeforeSignUser(SignUserRecordRequest request);


}
