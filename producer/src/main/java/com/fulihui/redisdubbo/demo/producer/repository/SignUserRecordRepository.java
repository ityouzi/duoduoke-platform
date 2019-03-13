package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * The interface Sign user record service.
 *
 * @author lizhi
 * @date 2018 -10-11
 */
public interface SignUserRecordRepository {

    long countByExample(SignUserRecordExample example);

    int updateByExampleSelective(SignUserRecord record, SignUserRecordExample example);

    int insertSelective(SignUserRecord record);

    boolean update(SignUserRecord record);

    List<SignUserRecordDTO> selectByExample(SignUserRecordExample example);

    List<SignUserRecordDTO> queryByCycleTime(String userId, Date cycleTime, String sortInfo);

    List<SignUserRecordDTO> queryBySignTimeExt(String userId, Date signTimeExt, String sortInfo);

    List<SignUserRecordDTO> queryBySignTimeExt(Date signTimeExt, String sortInfo, int page,
                                               int rows);

    List<SignUserRecordDTO> queryPk(String userId, Integer id);

    List<SignUserRecordDTO> queryByCycleTime(String userId, Integer id, Date signTimeExt,
                                             Date cycleTime);

    boolean modifyCount(SignUserRecord record);

    List<SignUserRecordDTO> select(@Param("cycleTime") Date cycleTime);

    //前

    List<SignUserRecordDTO> queryBeforeSignUser(int page, int rows);
}
