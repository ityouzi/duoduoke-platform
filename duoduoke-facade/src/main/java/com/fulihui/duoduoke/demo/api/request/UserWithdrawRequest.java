package com.fulihui.duoduoke.demo.api.request;


import com.fulihui.duoduoke.demo.api.enums.WithdrawStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.List;

/**
 *
 * @author lizhi
 * @date 2018-7-17
 */
@Setter @Getter
public class UserWithdrawRequest extends PageRequest {

    private static final long serialVersionUID = 5895428380986426640L;
    private String userId;

    /**
     * user_withdraw.status
     * 状态[101:待审核][102:审核通过][103:审核驳回][201:打款中][202:打款失败][203打款成功]
     *
     * @mbg.generated 2018-07-10 16:07:26
     * @see WithdrawStatusEnum
     */
    private List<String> status;

}
