package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.UserWithdrawDTO;
import com.fulihui.redisdubbo.demo.api.request.UserWithdrawCreateRequest;
import com.fulihui.redisdubbo.demo.api.request.UserWithdrawModifyRequest;
import com.fulihui.redisdubbo.demo.api.request.UserWithdrawRequest;
import org.near.servicesupport.request.TPageRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author: JY
 * @date: 2018/7/12 14:20
 */
public interface UserWithdrawService {

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    TPageResult<UserWithdrawDTO> queryPage(TPageRequest<UserWithdrawDTO> request);

    /**
     * @param request
     * @return
     */
    TSingleResult<Long> queryCount(UserWithdrawRequest request);

    /**
     * 新增
     *
     * @param request
     * @return
     */
    TSingleResult<Long> insert(UserWithdrawCreateRequest request);

    /**
     * 查询详情
     *

     * @return
     */
    TSingleResult<UserWithdrawDTO> detailById(Long id);

    /**
     * 修改状态
     *
     * @param request
     * @return
     */
    TSingleResult<Boolean> modifyStatus(UserWithdrawModifyRequest request);
}
