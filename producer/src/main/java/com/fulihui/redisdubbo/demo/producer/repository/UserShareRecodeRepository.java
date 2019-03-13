package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserShareRecord;

/**
 * @author Administrator
 */
public interface UserShareRecodeRepository {


    UserShareRecord selectByPrimaryKey(Integer id);

    int insert(UserShareRecord userShareRecord);

}