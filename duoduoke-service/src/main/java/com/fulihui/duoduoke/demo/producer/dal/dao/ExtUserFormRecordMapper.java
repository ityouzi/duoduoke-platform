package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserFormId;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 */
public interface ExtUserFormRecordMapper {
    long update(@Param("formStatus") String formStatus,
                @Param("day") Integer day,
                @Param("desc") String desc,
                @Param("oldStatus") String oldStatus);

    /**
     * 根据用户Id查询有效的formId
     *
     * @param userIds
     * @param expireTime
     * @return
     */
    List<UserFormId> queryFormIdByUserIds(@Param("userIds") List<String> userIds, @Param("expireTime") Date expireTime);

    /**
     * 修改formId状态
     *
     * @param formIds
     * @param desc
     * @return
     */
    int updateFormIdState(@Param("formIds") List<String> formIds, @Param("state") String state, @Param("desc") String desc);

}