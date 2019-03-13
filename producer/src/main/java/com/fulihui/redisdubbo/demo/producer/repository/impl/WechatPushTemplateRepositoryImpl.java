package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.producer.dal.dao.WechatPushTemplateContentMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatPushTemplateContent;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatPushTemplateContentExample;
import com.fulihui.redisdubbo.demo.producer.repository.WechatPushTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Repository
public class WechatPushTemplateRepositoryImpl implements WechatPushTemplateRepository {

    @Autowired
    private WechatPushTemplateContentMapper wechatPushTemplateContentMapper;

    @Override
    public WechatPushTemplateContent selectByType(String type) {
        WechatPushTemplateContentExample example = new WechatPushTemplateContentExample();
        WechatPushTemplateContentExample.Criteria criteria = example.createCriteria();
        criteria.andChannleEqualTo(type);
        List<WechatPushTemplateContent> list = wechatPushTemplateContentMapper
                .selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
