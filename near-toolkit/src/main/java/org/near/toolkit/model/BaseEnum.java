package org.near.toolkit.model;

/**
 * 枚举帮助累辅助接口，使用枚举帮助类的枚举必须继承该接口
 *
 * Created by Willard.Hu on 2015/8/3.
 */
public interface BaseEnum {

    /**
     * 获取枚举代码
     */
    String getCode();

    /**
     * 获取枚举描述
     */
    String getDesc();

}
