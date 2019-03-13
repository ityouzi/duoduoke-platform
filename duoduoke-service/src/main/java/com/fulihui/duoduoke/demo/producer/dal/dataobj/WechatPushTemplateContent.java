package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class WechatPushTemplateContent implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * wechat_push_template_content.id
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private Integer id;
    /**
     * wechat_push_template_content.app_id
     * APPID
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private String appId;
    /**
     * wechat_push_template_content.template_id
     * 模版id
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private String templateId;
    /**
     * wechat_push_template_content.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private Date gmtModified;
    /**
     * wechat_push_template_content.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private Date gmtCreate;
    /**
     * wechat_push_template_content.template_content
     * 模版内容
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private String templateContent;
    /**
     * wechat_push_template_content.page
     * 跳转地址
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private String page;
    /**
     * wechat_push_template_content.channle
     * 渠道类型
     *
     * @mbg.generated 2018-07-09 17:50:23
     */
    private String channle;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", templateId=").append(templateId);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", templateContent=").append(templateContent);
        sb.append(", page=").append(page);
        sb.append(", channle=").append(channle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}