package com.fulihui.duoduoke.demo.web.vo;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.result.PageResult;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class StoreInfoVo extends PageResult {

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
     * store.store_url

     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String storeUrl;

    /**
     *
     *
     * store.recommendation
     * 推荐语
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String recommendation;

    /**
     *
     *
     * store.start_time
     * 专场开始时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date startTime;

    /**
     *
     *
     * store.end_time
     * 专场结束时间
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Date endTime;

    /**
     *
     *
     * store.status
     * 专场状态 : 0关闭 1开启
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String status;

    /**
     *
     *
     * store.presentation
     * 展现形式:0 一行一个 1 一行两个
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String presentation;

    /**
     *
     *
     * store.is_preference
     * 是否优选显示: 0不显示 1显示
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String isPreference;

    /**
     *
     *
     * store.preference_number
     * 第几个优选显示
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private Integer preferenceNumber;

    /**
     *
     *
     * store.preference_url
     * 优选入口图
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String preferenceUrl;

    /**
     *
     *
     * store.pid
     * 专场PID
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String pid;

    /**
     *
     *
     * store.share_titile
     * 分享标题
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String shareTitile;

    /**
     *
     *
     * store.share_url
     * 分享图
     *
     * @mbg.generated 2018-10-16 13:58:18
     */
    private String shareUrl;

   private List<GoodsInfo> goodsInfoList;

}
