package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.KeywordInfoService;
import com.fulihui.redisdubbo.demo.api.dto.GoodsKeywordInfoDTO;
import com.fulihui.redisdubbo.demo.api.request.GoodsKeywordInfoRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.GoodsKeywordInfoMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsKeywordInfo;
import com.fulihui.redisdubbo.demo.producer.repository.KeywordInfoRepository;
import com.fulihui.redisdubbo.demo.weixin.common.util.BeanConvUtil;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.List;

/**
 * Created by lizhi on 2018-7-7.
 */
@Service(version = "${demo.service.version}")

public class GoodsKeywordServiceImpl implements KeywordInfoService {

    @Autowired
    private KeywordInfoRepository keywordInfoRepository;

    @Autowired
    private GoodsKeywordInfoMapper keywordInfoMapper;

    @Override
    public TPageResult<GoodsKeywordInfoDTO> queryInfo(GoodsKeywordInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        List<GoodsKeywordInfoDTO> goodsKeywordInfoDTOs = keywordInfoRepository
                .queryKeywordInfo(request.getKeyword(), request.start4Mysql(), request.getRows());
        if (CollectionUtils.isEmpty(goodsKeywordInfoDTOs)) {
            return ResultBuilder.succTPage(Lists.newArrayList(), request.getPage(),
                    request.getRows(), 0);
        }

        //查询条数
        long count = keywordInfoRepository.count(request.getKeyword());

        return ResultBuilder.succTPage(goodsKeywordInfoDTOs, request.getPage(), request.getRows(),
                (int) count);
    }

    /**
     * 修改
     *
     * @param keywordInfoDTO
     * @return
     */
    @Override
    public TSingleResult<Boolean> modifyById(GoodsKeywordInfoDTO keywordInfoDTO) {

        GoodsKeywordInfo keywordInfo = BeanConvUtil.copy(keywordInfoDTO, GoodsKeywordInfo.class);

        keywordInfo.setGmtModified(Calendar.getInstance().getTime());

        int count = keywordInfoMapper.updateByPrimaryKeySelective(keywordInfo);

        return ResultBuilder.succTSingle(count > 0);
    }

    /**
     * 插入
     *
     * @param keywordInfoDTO
     * @return
     */
    @Override
    public TSingleResult<Integer> insert(GoodsKeywordInfoDTO keywordInfoDTO) {

        GoodsKeywordInfo keywordInfo = BeanConvUtil.copy(keywordInfoDTO, GoodsKeywordInfo.class);

        keywordInfo.setGmtCreate(Calendar.getInstance().getTime());

        keywordInfo.setGmtModified(Calendar.getInstance().getTime());

        keywordInfoMapper.insert(keywordInfo);

        return ResultBuilder.succTSingle(keywordInfo.getId());
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public TSingleResult<Boolean> delById(Integer id) {

        int count = keywordInfoMapper.deleteByPrimaryKey(id);

        return ResultBuilder.succTSingle(count > 0);
    }
}
