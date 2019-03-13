package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.TemplateSendTaskService;
import com.fulihui.duoduoke.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.duoduoke.demo.api.enums.TemplateSendTaskStateEnum;
import com.fulihui.duoduoke.demo.api.request.SendTaskRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.TemplateSendTask;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.TemplateSendTaskExample;
import com.fulihui.duoduoke.demo.producer.manager.TemplateSendTaskManager;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtTemplateSendTaskMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.TemplateSendTaskMapper;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Calendar;
import java.util.List;

import static org.near.servicesupport.result.ResultBuilder.succTPage;


/**
 * @author: JY
 * @date: 2018/8/13 15:56
 */
@Service(version = "${demo.service.version}")

public class TemplateSendTaskServiceImpl implements TemplateSendTaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateSendTaskServiceImpl.class);
    @Autowired
    TemplateSendTaskMapper templateSendTaskMapper;

    @Autowired
    ExtTemplateSendTaskMapper extTemplateSendTaskMapper;

    @Autowired
    TemplateSendTaskManager templateSendTaskManager;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 列表
     *
     * @param taskRequest
     * @return
     */
    @Override
    public TPageResult<TemplateSendTaskDTO> list(SendTaskRequest taskRequest) {
        TemplateSendTaskExample example = new TemplateSendTaskExample();
        example.setOffset(taskRequest.start4Mysql());
        example.setLimit(taskRequest.getRows());
        TemplateSendTaskExample.Criteria criteria = example.createCriteria();

        //状态
        if (taskRequest.getState() != null) {
            criteria.andStateIn(taskRequest.getState());
        }

        List<TemplateSendTask> sendTaskList = templateSendTaskMapper.selectByExample(example);

        List<TemplateSendTaskDTO> result = null;

        if (sendTaskList != null) {
            result = BeanConvUtil.copy(sendTaskList, TemplateSendTaskDTO.class);
        }

        long count = templateSendTaskMapper.countByExample(example);
        return succTPage(result, taskRequest.getPage(), taskRequest.getRows(), (int) count);
    }

    /**
     * 修改
     *
     * @param sendTaskDTO
     * @return
     */
    @Override
    public TSingleResult<Boolean> modify(TemplateSendTaskDTO sendTaskDTO) {
        TemplateSendTask model = new TemplateSendTask();
        BeanUtils.copyProperties(sendTaskDTO, model);
        model.setGmtModified(Calendar.getInstance().getTime());
        int i = templateSendTaskMapper.updateByPrimaryKeySelective(model);
        return ResultBuilder.succTSingle(i > 0);
    }

    /**
     * 添加
     *
     * @param sendTaskDTO
     * @return
     */
    @Override
    public TSingleResult<Boolean> insert(TemplateSendTaskDTO sendTaskDTO) {
        TemplateSendTask model = new TemplateSendTask();
        BeanUtils.copyProperties(sendTaskDTO, model);
        model.setGmtModified(Calendar.getInstance().getTime());
        model.setGmtCreate(Calendar.getInstance().getTime());
        model.setOpenCount(0);
        model.setSendCount(0);
        model.setSuccessCount(0);
        model.setState(Integer.parseInt(TemplateSendTaskStateEnum.ENABLE.getCode()));
        boolean b = templateSendTaskMapper.insert(model) > 0;
        return ResultBuilder.succTSingle(b);
    }

    /**
     * 检查待发送的消息
     */
    @Override
    public void checkSend() {
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    templateSendTaskManager.checkData();
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        });

    }

    /**
     * 获取单个详情
     *
     * @param id
     * @return
     */
    @Override
    public TSingleResult<TemplateSendTaskDTO> getModel(Integer id) {

        TemplateSendTask sendTask = templateSendTaskMapper.selectByPrimaryKey(id);
        TemplateSendTaskDTO sendTaskDTO = null;
        if (sendTask != null) {
            sendTaskDTO = BeanConvUtil.copy(sendTask, TemplateSendTaskDTO.class);
        }
        return ResultBuilder.succTSingle(sendTaskDTO);
    }

    /**
     * 状态次数记录 [1:发送成功,2:发送失败，3:用户打开]
     *
     * @param id
     * @param count
     * @param recordType
     * @return
     */
    @Override
    public boolean setCountRecord(Integer id, Integer count, int recordType) {

        return extTemplateSendTaskMapper.updateRecordCount(id, count, recordType) > 0;
    }

    /**
     * 任务推送状态
     *
     * @param id
     * @param sendTaskStateEnum
     * @return
     */
    @Override
    public boolean setState(Integer id, TemplateSendTaskStateEnum sendTaskStateEnum) {
        return extTemplateSendTaskMapper.updateState(id, Integer.parseInt(sendTaskStateEnum.getCode())) > 0;
    }

    @Override
    public void clearTaskQueue(Integer id) {
        templateSendTaskManager.clearTaskQueue(id);
    }
}
