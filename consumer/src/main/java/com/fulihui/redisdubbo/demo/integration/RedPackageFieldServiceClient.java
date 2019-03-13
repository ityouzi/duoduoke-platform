package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.RedPackageFieldDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserRedPackageRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageFieldRequest;
import com.fulihui.redisdubbo.demo.api.request.UserRedPackageRecordRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;

/**
 * @author Administrator
 */
public interface RedPackageFieldServiceClient {

    /**
     * 列表
     * @param request
     * @return
     */
    TPageResult<RedPackageFieldDTO> list(RedPackageFieldRequest request);

    TMultiResult<UserRedPackageRecordDTO> queryRecord(UserRedPackageRecordRequest request);

    Boolean update(UserRedPackageRecordDTO dto);

    Long insertUserRedPackage(UserRedPackageRecordDTO dto);

}
