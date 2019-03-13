package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetailAdmin;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ExtUserDetailCount;

import java.util.List;
import java.util.Map;

/**
 * @author: JY
 * @date: 2018/8/1 14:34
 */
public interface ExtUserDetailMapper {

    List<UserDetailAdmin> queryAdminList(Map<String, Object> params);

    int count(Map<String, Object> params);

    List<UserDetail> queryUser();

    List<ExtUserDetailCount> queryData();

    int updateByPrimaryKeySelective(UserDetail record);
}
