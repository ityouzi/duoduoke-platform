package com.fulihui.duoduoke.demo.web.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-10-17
 */
@Setter
@Getter
public class DrawVO extends ToString {
    private static final long serialVersionUID = -8939922037931218305L;
    @ApiModelProperty(value = "抽中奖品的id")
    private Integer prizeId;
    @ApiModelProperty(value = "能不能在分享,true=可以,false=不可以")
    private Boolean shareAgain;
    @ApiModelProperty(value = "翻牌的奖品信息")
    private List<SignInPrizeVO> list;
    @ApiModelProperty(value = "用户中奖后关联的id")
    private Integer signAwardId;

}
