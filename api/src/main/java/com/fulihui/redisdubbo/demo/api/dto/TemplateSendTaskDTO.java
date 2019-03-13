package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/13 15:41
 */
@Setter
@Getter
public class TemplateSendTaskDTO {

    /**
     *
     *
     * template_send_task.id
     * 主键
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Integer id;

    /**
     *
     *
     * template_send_task.title
     * 标题
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String title;

    /**
     *
     *
     * template_send_task.user_behaviors
     * 用户行为多个以 ; 隔开
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String userBehaviors;

    /**
     *
     *
     * template_send_task.user_sex
     * 用户性别
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String userSex;

    /**
     *
     *
     * template_send_task.trigger_times
     * 定时发送时间多个以 ; 隔开
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String triggerTimes;

    /**
     *
     *
     * template_send_task.template_id
     * 小程序模板Id
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String templateId;

    /**
     *
     *
     * template_send_task.template_page
     * 小程序模板跳转地址
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String templatePage;

    /**
     *
     *
     * template_send_task.template_date
     * 模板发送数据
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String templateDate;

    /**
     *
     *
     * template_send_task.emphasis_keyword
     * 模板加粗、放大的字段
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private String emphasisKeyword;

    /**
     * 任务类型 [1:被动任务] [2:主动任务]
     */
    private Integer type;

    /**
     *
     *
     * template_send_task.state
     * 任务状态 [1:启用][2:已发送][3:停用]
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Integer state;

    /**
     *
     *
     * template_send_task.date_send_count
     * 每日单个用户最多发送次数
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Integer dateSendCount;

    /**
     *
     *
     * template_send_task.send_count
     * 发送总次数
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Integer sendCount;

    /**
     *
     *
     * template_send_task.open_count
     * 打开总次数
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Integer openCount;

    /**
     *
     *
     * template_send_task.success_count
     * 发送成功总次数
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Integer successCount;

    /**
     *
     *
     * template_send_task.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Date gmtCreate;

    /**
     *
     *
     * template_send_task.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-13 15:37:33
     */
    private Date gmtModified;

}
