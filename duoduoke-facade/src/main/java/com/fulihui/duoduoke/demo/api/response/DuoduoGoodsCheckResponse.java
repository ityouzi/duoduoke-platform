package com.fulihui.duoduoke.demo.api.response;


import com.fulihui.duoduoke.demo.api.dto.DuoduoGoodsInfoDTO;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author Administrator
 */
@Setter
@Getter
public class DuoduoGoodsCheckResponse extends ToString {


    private static final long serialVersionUID = -6013479400946520076L;

    private List<DuoduoGoodsInfoDTO> result;
}