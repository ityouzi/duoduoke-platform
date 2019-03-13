package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class GoodSearchRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * good_search_record.id
     *
     * @mbg.generated 2018-07-19 14:17:59
     */
    private Integer id;
    /**
     * good_search_record.user_id
     * 用户id
     *
     * @mbg.generated 2018-07-19 14:17:59
     */
    private String userId;
    /**
     * good_search_record.search_content
     * 搜索内容
     *
     * @mbg.generated 2018-07-19 14:17:59
     */
    private String searchContent;
    /**
     * good_search_record.is_result
     *
     * @mbg.generated 2018-07-19 14:17:59
     */
    private String isResult;
    /**
     * good_search_record.gmt_create
     *
     * @mbg.generated 2018-07-19 14:17:59
     */
    private Date gmtCreate;
    /**
     * good_search_record.open_id
     *
     * @mbg.generated 2018-07-19 14:17:59
     */
    private String openId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", searchContent=").append(searchContent);
        sb.append(", isResult=").append(isResult);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", openId=").append(openId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}