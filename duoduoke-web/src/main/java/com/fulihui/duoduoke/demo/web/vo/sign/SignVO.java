package com.fulihui.duoduoke.demo.web.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 *
 * @author lizhi
 * @date 2018-10-17
 */
@Setter
@Getter
public class SignVO extends ToString {
    private static final long   serialVersionUID = 5939967319748996325L;
    @ApiModelProperty(value = "签到是否成功 ,true=成功 ,false=失败")
    private Boolean             signStatus;

    @ApiModelProperty(value = "翻牌开关是否开启 ,true=开启 ,false=未开启")
    private Boolean             flopStatus;
    @ApiModelProperty(value = "翻牌的奖品信息")
    private List<SignInPrizeVO> list;
    @ApiModelProperty(value = "翻牌分享")
    private FlopShareVO         shareVO;
}
