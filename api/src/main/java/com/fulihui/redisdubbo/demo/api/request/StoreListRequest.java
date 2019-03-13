package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

@Getter
@Setter
public class StoreListRequest extends PageRequest {

    /**
     *
     *
     * store.id

     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Long id;

    /**
     *
     *
     * store.store_name
     * 专场名称
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String storeName;
    /**
     *
     *
     * store.status
     * 专场状态 : 0关闭 1开启
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String status;

}
