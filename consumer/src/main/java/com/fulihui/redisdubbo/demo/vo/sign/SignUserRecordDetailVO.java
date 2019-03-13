package com.fulihui.redisdubbo.demo.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-12
 */
@Getter
@Setter
public class SignUserRecordDetailVO extends ToString {

    private static final long serialVersionUID = 4980496764383499611L;
    /**
     * sign_user_record.id
     */
    @ApiModelProperty(value = "主键pk")
    private Integer           id;

    /**
     *sign_user_record.sign_time_ext
     * 签到时间扩展
     */
    @ApiModelProperty(value = "签到时间扩展")
    private String            signTimeExt;

    /**
     * sign_user_record.cycle_time
     * 用户签到周期
     */
    @ApiModelProperty(value = "用户签到周期")
    private String            cycleTime;

    /**
     * sign_user_record.sign_status
     * [1：已签到,0:未签到]
     */
    @ApiModelProperty(value = "[0:未签到,1：已签到,2:漏签,3:已补签]")
    private String            signStatus;

    @ApiModelProperty(value = "天")
    private Integer           days;

    @ApiModelProperty(value = "是否可签到,true=可以签到,false=不可以签到")
    private Boolean           isSign;

    /**
     * sign_user_record.sign_flop_count
     * 签到翻牌机会
     *
     * @mbg.generated 2018-10-15 13:26:35
     */

    @ApiModelProperty(value = "签到翻牌机会,字段为null=用户今天未签到,没有翻牌机会, 0=用户今天已经翻牌过")
    private Integer           signFlopCount;

    /**
     * sign_user_record.share_flop_count
     * 分享翻牌机会
     *
     * @mbg.generated 2018-10-15 13:26:35
     */
    @ApiModelProperty(value = "分享翻牌机会")
    private Integer           shareFlopCount;

}
