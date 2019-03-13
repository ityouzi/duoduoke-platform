package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetail;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2018-8-1
 */
public interface ExtUserFansDetailMapper {

    List<UserFansDetail> querySumByUserId(@Param("userId") String userId,

                                          @Param("gmtCreate") Date gmtCreate);
}
