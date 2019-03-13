package com.fulihui.redisdubbo.demo.api.api.sign;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.redisdubbo.demo.api.request.sign.SignAwardRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-10-17
 */
public interface SignAwardService {

    TPageResult<SignAwardDTO> queryPage(SignAwardRequest request);

    TSingleResult<Integer> bindOrder(SignAwardRequest request);

    TSingleResult<SignAwardDTO> queryUserIdOrderSn(SignAwardRequest request);

    TSingleResult<Long> sumPrizeMoney(SignAwardRequest request);

    TSingleResult<Integer> insert(SignAwardRequest request);

    BaseResult failure(SignAwardRequest request);

    BaseResult update(SignAwardRequest request);

    TMultiResult<SignAwardDTO> queryAsOfGmtCreate(SignAwardRequest request);

    TMultiResult<SignAwardDTO> queryLastValidity(SignAwardRequest request);

    TSingleResult<SignAwardDTO> selectByPrimaryKey(SignAwardRequest request);


    TPageResult<SignAwardDTO> queryReceipt(SignAwardRequest request);

    TSingleResult<SignAwardDTO> confirmReceiptAddBalance(SignAwardRequest request);

}
