package com.fulihui.duoduoke.demo.web.manager;

/**
 * @author: JY
 * @date: 2018/8/17 15:38
 */
public interface UserManager {

    void visitToday(String userId);

    /**
     * 打开模板消息
     * @param userId 用户id
     * @param taskId 任务id
     */
    void userOpenTemplate(String userId, Integer taskId, String batchId);
}
