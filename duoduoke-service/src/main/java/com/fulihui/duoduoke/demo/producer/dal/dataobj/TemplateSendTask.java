package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TemplateSendTask implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * template_send_task.id
     * 主键
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer id;
    /**
     * template_send_task.title
     * 标题
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String title;
    /**
     * template_send_task.user_behaviors
     * 用户行为多个以 ; 隔开
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String userBehaviors;
    /**
     * template_send_task.user_sex
     * 用户性别
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String userSex;
    /**
     * template_send_task.trigger_times
     * 定时发送时间多个以 ; 隔开
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String triggerTimes;
    /**
     * template_send_task.template_id
     * 小程序模板Id
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String templateId;
    /**
     * template_send_task.template_page
     * 小程序模板跳转地址
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String templatePage;
    /**
     * template_send_task.template_date
     * 模板发送数据
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String templateDate;
    /**
     * template_send_task.emphasis_keyword
     * 模板加粗、放大的字段
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String emphasisKeyword;
    /**
     * template_send_task.type
     * 任务类型 [1:被动任务][2:主动任务]
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer type;
    /**
     * template_send_task.state
     * 任务状态 [1:启用][2:已发送][3:停用]
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer state;
    /**
     * template_send_task.date_send_count
     * 每日单个用户最多发送次数
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer dateSendCount;
    /**
     * template_send_task.send_count
     * 发送总次数
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer sendCount;
    /**
     * template_send_task.open_count
     * 打开总次数
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer openCount;
    /**
     * template_send_task.success_count
     * 发送成功总次数
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer successCount;
    /**
     * template_send_task.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date gmtCreate;
    /**
     * template_send_task.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", userBehaviors=").append(userBehaviors);
        sb.append(", userSex=").append(userSex);
        sb.append(", triggerTimes=").append(triggerTimes);
        sb.append(", templateId=").append(templateId);
        sb.append(", templatePage=").append(templatePage);
        sb.append(", templateDate=").append(templateDate);
        sb.append(", emphasisKeyword=").append(emphasisKeyword);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", dateSendCount=").append(dateSendCount);
        sb.append(", sendCount=").append(sendCount);
        sb.append(", openCount=").append(openCount);
        sb.append(", successCount=").append(successCount);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}