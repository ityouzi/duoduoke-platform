package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.RedPackageFieldDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserRedPackageRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageFieldRequest;
import com.fulihui.redisdubbo.demo.api.request.UserRedPackageRecordRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;

/**
 * @author: JY
 * @date: 2018/9/3 15:23
 */
public interface RedPackageFieldService {

    /**
     * 添加
     * @param model
     * @return
     */
    Boolean insert(RedPackageFieldDTO model);

    TMultiResult<UserRedPackageRecordDTO> queryRecord(UserRedPackageRecordRequest request);

    Long insertUserRedPackage(UserRedPackageRecordDTO dto);


    Boolean update(UserRedPackageRecordDTO dto);
    /**
     * 修改
     * @param model
     * @return
     */
    Boolean modify(RedPackageFieldDTO model);

    /**
     * 获取单个
     * @param id
     * @return
     */
    RedPackageFieldDTO getModel(Integer id);

    /**
     * 列表
     * @param request
     * @return
     */
    TPageResult<RedPackageFieldDTO> list(RedPackageFieldRequest request);
}
