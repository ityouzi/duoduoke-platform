package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/19 0019 15:37
 */
@Getter
public enum DuoDuoGoodsTableEnum {

                                  /**
                                   * DuoduoGoodsInfoZEROMapper
                                   */
                                  ZERO(0, "DuoduoGoodsInfoZEROMapper"),
                                  /**
                                   * DuoduoGoodsInfoMapper
                                   */
                                  ONE(1, "DuoduoGoodsInfoMapper");

    int    code;
    String desc;

    DuoDuoGoodsTableEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
