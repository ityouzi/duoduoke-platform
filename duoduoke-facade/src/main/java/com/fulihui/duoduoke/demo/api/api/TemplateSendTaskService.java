package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.enums.TemplateSendTaskStateEnum;
import com.fulihui.duoduoke.demo.api.request.SendTaskRequest;
import com.fulihui.duoduoke.demo.api.dto.TemplateSendTaskDTO;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;


/**
 * @author: JY
 * @date: 2018/8/13 15:41
 */
public interface TemplateSendTaskService {

    /**
     * 模板发送成功
     */
    static final Integer TEMPLATE_SEND_SUCCESS = 1;
    /**
     * 模板发送失败
     */
    static final Integer TEMPLATE_SEND_FAIL = 2;
    /**
     * 用户打开模板消息
     */
    static final Integer TEMPLATE_USER_OPEN = 3;

    /**
     * 查询数据列表
     *
     * @param taskRequest
     * @return
     */
    TPageResult<TemplateSendTaskDTO> list(SendTaskRequest taskRequest);

    /**
     * 修改
     *
     * @param sendTaskDTO
     * @return
     */
    TSingleResult<Boolean> modify(TemplateSendTaskDTO sendTaskDTO);

    /**
     * 插入
     *
     * @param sendTaskDTO
     * @return
     */
    TSingleResult<Boolean> insert(TemplateSendTaskDTO sendTaskDTO);

    /**
     * 获取单个详情
     *
     * @param id
     * @return
     */
    TSingleResult<TemplateSendTaskDTO> getModel(Integer id);

    /**
     * 检查待发送的任务消息
     */
    void checkSend();

    /**
     * 状态次数记录 [1:发送成功,2:发送失败，3:用户打开]
     *
     * @param id
     * @param count
     * @param recordType
     * @return
     */
    boolean setCountRecord(Integer id, Integer count, int recordType);

    /**
     * 任务推送状态
     *
     * @param id
     * @param sendTaskStateEnum
     * @return
     */
    boolean setState(Integer id, TemplateSendTaskStateEnum sendTaskStateEnum);


    /**
     * 清空消息队列
     *
     * @param id
     * @return
     */
    void clearTaskQueue(Integer id);

}
