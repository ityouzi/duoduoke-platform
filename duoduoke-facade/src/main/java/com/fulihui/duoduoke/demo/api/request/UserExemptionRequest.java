package com.fulihui.duoduoke.demo.api.request;


import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.dto.UserExemptionGoodsDTO;
import lombok.Data;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/19 0019 14:29
 */
@Data
public class UserExemptionRequest extends ToString {

    private UserExemptionGoodsDTO userExemptionGoodsDTO;

    private ExemptionGoodsDTO exemptionGoodsDTO;


}
