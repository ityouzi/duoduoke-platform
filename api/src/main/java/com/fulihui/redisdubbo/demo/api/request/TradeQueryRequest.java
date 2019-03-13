package com.fulihui.redisdubbo.demo.api.request;



import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

/**
 * @author Willard Hu on 2017/12/11.
 */
@Getter
@Setter
public class TradeQueryRequest extends PageRequest {
    private static final long serialVersionUID = -3170729852300672027L;

    /**
     * 交易号
     */
    private String tradeNo;
    /**
     * 第三方交易号
     */
    private String thirdTradeNo;
    /**
     * 交易状态
     */
    private String state;
    /**
     * 交易类型
     */
    private String category;
    /**
     * 交易支付类型
     * category 为 {@link TradeCategoryEnum#WITH_DRAW } 时，取值 {@link com.fulihui.redisdubbo.demo.producer.facade.enums.TradeWithDrawTypeEnum}<p/>
     */
    private String payType;
}
