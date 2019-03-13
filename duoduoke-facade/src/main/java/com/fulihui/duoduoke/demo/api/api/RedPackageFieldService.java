package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.RedPackageFieldRequest;
import com.fulihui.duoduoke.demo.api.request.UserRedPackageRecordRequest;
import com.fulihui.duoduoke.demo.api.dto.RedPackageFieldDTO;
import com.fulihui.duoduoke.demo.api.dto.UserRedPackageRecordDTO;
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
