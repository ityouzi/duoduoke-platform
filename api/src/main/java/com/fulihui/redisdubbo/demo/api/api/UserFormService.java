package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.UserFormIdDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.UserFormInsertRequest;
import com.fulihui.redisdubbo.demo.api.request.UserFormInvalidRequest;
import com.fulihui.redisdubbo.demo.api.request.UserFormRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-13
 */
public interface UserFormService {
    /**
     * @param request
     * @return
     */
    TPageResult<UserFormRecordDTO> queryPage(UserFormRequest request);

    /**
     * updateInvalid
     *
     * @param request
     * @return
     */
    BaseResult updateInvalid(UserFormInvalidRequest request);

    /**
     * 记录用户 formId
     *
     * @param request
     * @return
     */
    TSingleResult<Integer> insert(UserFormInsertRequest request);

    /**
     * 查询可用的FormId
     *
     * @param userIds
     * @return
     */
    List<UserFormIdDTO> queryFormIdByUserIds(List<String> userIds);


    TMultiResult<UserFormRecordDTO> query(String userId, String code);

    /**
     * 设置formId已使用
     *
     * @return
     */
   void setFormIdUsed(List<String> formIds, String desc);
}
