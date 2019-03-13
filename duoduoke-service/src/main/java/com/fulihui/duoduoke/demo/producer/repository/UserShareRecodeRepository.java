package com.fulihui.duoduoke.demo.producer.repository;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserShareRecord;

/**
 * @author Administrator
 */
public interface UserShareRecodeRepository {


    UserShareRecord selectByPrimaryKey(Integer id);

    int insert(UserShareRecord userShareRecord);

}