package com.fulihui.duoduoke.demo.producer.service;

import com.alibaba.druid.util.StringUtils;
import com.fulihui.duoduoke.demo.api.api.RedPackageDBLConfigService;
import com.fulihui.duoduoke.demo.api.dto.RedPackageDBLConfigDTO;
import com.fulihui.duoduoke.demo.api.enums.RedPackageConfigStatusEnum;
import com.fulihui.duoduoke.demo.api.request.RedPackageDBLConfigRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageDoublingConfig;
import com.fulihui.duoduoke.demo.producer.manager.DuoduoGoodsManager;
import com.fulihui.duoduoke.demo.producer.dal.dao.RedPackageDoublingConfigMapper;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Service(version = "${demo.service.version}")

public class RedPackageDBLConfigServiceImpl implements RedPackageDBLConfigService {

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;
    @Autowired
    RedPackageDoublingConfigMapper redPackageDoublingConfigMapper;
    @Autowired
    DuoduoGoodsManager duoduoGoodsManager;
    //配置的值
    private int CONFIG_ID = 1;

    @Override
    public TSingleResult<RedPackageDBLConfigDTO> getRedPackageDBLConfig() {
        //1.查询数据库是否存在 记录Id=1的记录
        RedPackageDoublingConfig redPackageDoublingConfig = null;

        redPackageDoublingConfig = redPackageDoublingConfigMapper.selectByPrimaryKey(CONFIG_ID);

        //2.如果不存在 则 新建 返回新建结果
        if (redPackageDoublingConfig == null) {
            redPackageDoublingConfig = new RedPackageDoublingConfig();
            redPackageDoublingConfig.setGmtCreate(new Date());
            redPackageDoublingConfig.setGmtModified(new Date());
            redPackageDoublingConfig.setStatus(RedPackageConfigStatusEnum.OFF.getCode());
            redPackageDoublingConfig.setId(CONFIG_ID);
            redPackageDoublingConfigMapper.insert(redPackageDoublingConfig);
            RedPackageDBLConfigDTO redPackageDBLConfigDTO = BeanConvUtil
                    .copy(redPackageDoublingConfig, RedPackageDBLConfigDTO.class);

            return ResultBuilder.succTSingle(redPackageDBLConfigDTO);
        } else {
            //3.如果存在则返回结果

            RedPackageDBLConfigDTO redPackageDBLConfigDTO = BeanConvUtil
                    .copy(redPackageDoublingConfig, RedPackageDBLConfigDTO.class);

            return ResultBuilder.succTSingle(redPackageDBLConfigDTO);
        }
    }

    @Override
    public Boolean saveRedPackageDBLConfig(RedPackageDBLConfigRequest redPackageDBLConfigRequest) {
        //过滤字段
        if (redPackageDBLConfigRequest.getScale() == null) {
            redPackageDBLConfigRequest.setScale(0f);
        } else {
            if (redPackageDBLConfigRequest.getScale() > 100) {
                return false;
            }
        }
        RedPackageDoublingConfig redPackageDoublingConfig = redPackageDoublingConfigMapper
                .selectByPrimaryKey(CONFIG_ID);

        if (redPackageDoublingConfig == null) {
            redPackageDoublingConfig = BeanConvUtil.copy(redPackageDBLConfigRequest,
                    RedPackageDoublingConfig.class);
            redPackageDoublingConfig.setGmtCreate(new Date());
            redPackageDoublingConfig.setGmtModified(new Date());
            redPackageDoublingConfig.setStatus(RedPackageConfigStatusEnum.ON.getCode());
            redPackageDoublingConfig.setId(CONFIG_ID);
            return redPackageDoublingConfigMapper.insert(redPackageDoublingConfig) > 0;
        } else {
            if (StringUtils.isEmpty(redPackageDoublingConfig.getStatus())) {
                redPackageDoublingConfig.setStatus(RedPackageConfigStatusEnum.ON.getCode());
            }
            Date createDate = redPackageDoublingConfig.getGmtCreate();
            redPackageDoublingConfig = BeanConvUtil.copy(redPackageDBLConfigRequest,
                    RedPackageDoublingConfig.class);
            redPackageDoublingConfig.setGmtModified(new Date());
            redPackageDoublingConfig.setGmtCreate(createDate);
            redPackageDoublingConfig.setId(CONFIG_ID);

            return redPackageDoublingConfigMapper.updateByPrimaryKey(redPackageDoublingConfig) > 0;
        }

    }

}
