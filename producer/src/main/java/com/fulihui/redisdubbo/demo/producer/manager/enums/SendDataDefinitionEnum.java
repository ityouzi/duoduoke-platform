package com.fulihui.redisdubbo.demo.producer.manager.enums;


import com.fulihui.redisdubbo.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.redisdubbo.demo.producer.util.ApplicationUtil;
import lombok.Getter;

/**
 * @author: JY
 * @date: 2018/10/18 17:05
 */
public enum SendDataDefinitionEnum {

    /**
     * 通用被动任务发送
     */
    DefaultPassiveTaskDefinition(-1, "defaultPassiveTaskImpl"),

    /**
     * 签到提醒-临近结束 发送
     */
    BeforeSignRemind(-2, "beforeSignRemindImpl"),


    /**
     * 签到提醒-初期 发送
     */
    EndSignRemind(-3, "endSignRemindImpl"),

    /**
     * 签到周期结束后隔天11点发放通知
     */
    SignAccountRemind(-4, "signAccountRemindImpl"),
    /**
     * 昨天获得的签到奖金，但是今天截至21点尚未绑定订单的提醒通知
     */
    SignAccountOrderRemindImpl(-5, "signAccountOrderRemindImpl"),

    /**
     * 有效期最后一天的签到奖金，在最后一天21点还是未绑定，则触发即将失效提醒（多个符合签到奖金情况，也只发一次）
     */
    SignAccountEndOrderRemindImpl(-6, "signAccountEndOrderRemindImpl");

    @Getter
    private Integer taskId;

    @Getter
    private BaseSendDataDefinition sendDataDefinition;

    SendDataDefinitionEnum(Integer taskId, String beanName) {
        this.taskId = taskId;
        this.sendDataDefinition = (BaseSendDataDefinition) ApplicationUtil.applicationContext.getBean(beanName);
    }

    /**
     * 获取对象
     *
     * @param taskId
     * @return
     */
    public static SendDataDefinitionEnum get(Integer taskId) {
        for (SendDataDefinitionEnum item : values()) {
            if (item.taskId.equals(taskId)) {
                return item;
            }
        }
        return null;
    }
}
