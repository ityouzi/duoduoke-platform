package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.Date;

/**
 * @author lizhi
 */
@Setter @Getter
public class GoodSearchRecordRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = -2071883751837168026L;
    /**
     * good_search_record.id
     */
    private Integer id;

    /**
     * good_search_record.user_id
     * 用户id
     */
    private String userId;

    /**
     * good_search_record.search_content
     * 搜索内容
     */
    private String searchContent;

    /**
     * good_search_record.is_result
     */
    private String isResult;

    /**
     * good_search_record.gmt_create
     */
    private Date gmtCreate;

    private String openId;


}