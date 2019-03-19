package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.api.RedPackageGoodsService;
import com.fulihui.duoduoke.demo.api.dto.GoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.RedPackageGoodsDTO;
import com.fulihui.duoduoke.demo.api.request.GetDuoduoGoodsListRequest;
import com.fulihui.duoduoke.demo.api.request.RedPackageGoodsRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageField;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageGoods;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.RedPackageGoodsExample;
import com.fulihui.duoduoke.demo.producer.manager.GoodsManager;
import com.fulihui.duoduoke.demo.producer.repository.GoodsInfoRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtRedPackageGoodsMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.RedPackageFieldMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.RedPackageGoodsMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: JY
 * @date: 2018/9/3 15:21
 */
@Service(version = "${demo.service.version}")

public class RedPackageGoodsServiceImpl implements RedPackageGoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedPackageGoodsServiceImpl.class);
    @Autowired
    RedPackageGoodsMapper redPackageGoodsMapper;
    @Autowired
    ExtRedPackageGoodsMapper extRedPackageGoodsMapper;
    @Autowired
    RedPackageFieldMapper redPackageFieldMapper;
    @Autowired
    GoodsInfoRepository goodsInfoRepository;
    @Autowired
    GoodsManager goodsManager;
    @Autowired
    GoodsInfoService goodsInfoService;

    /**
     * 插入数据
     *
     * @param goodsDTO
     * @return
     */
    @Override
    public TSingleResult<Boolean> insert(RedPackageGoodsDTO goodsDTO) {
        RedPackageGoods model = BeanConvUtil.copy(goodsDTO, RedPackageGoods.class);

        RedPackageGoodsExample goodsExample = new RedPackageGoodsExample();
        RedPackageGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsIdEqualTo(model.getGoodsId());
        criteria.andRpfTypeEqualTo(model.getRpfType());
        criteria.andRpfIdEqualTo(model.getRpfId());
        //查询是否存在
        long count = redPackageGoodsMapper.countByExample(goodsExample);
        if (count > 0) {
            return ResultBuilder.succTSingle(false);
        }

        model.setGmtCreate(new Date());

        boolean success = redPackageGoodsMapper.insert(model) > 0;
        ;

        return ResultBuilder.succTSingle(success);
    }

    /**
     * 查询列表
     *
     * @param request
     * @return
     */
    @Override
    public TPageResult<RedPackageGoodsDTO> list(RedPackageGoodsRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", request.start4Mysql());
        params.put("rows", request.getRows());
        params.put("rpfId", request.getRpfId());
        params.put("rpfType", request.getRpfType());
        params.put("goodsName", request.getGoodsName());
        params.put("goodsId", request.getGoodsId());
        params.put("state", request.getState());
        params.put("orderByClause", request.getOrderByClause());
        params.put("goodsTable", goodsInfoRepository.getUseTableName());

        //查询总条数
        long count = extRedPackageGoodsMapper.queryFieldGoodsCount(params);

        //列表数据
        List<RedPackageGoodsDTO> goodsDTOList = extRedPackageGoodsMapper.queryFieldGoods(params);

        return ResultBuilder.succTPage(goodsDTOList, request.getPage(), request.getRows(),
                (int) count);
    }

    @Override
    public TPageResult<RedPackageGoodsDTO> listInAPI(RedPackageGoodsRequest request) {

        //查询优惠券金额
        RedPackageField packageField = redPackageFieldMapper.selectByPrimaryKey(request.getRpfId());

        if (packageField == null) {
            return ResultBuilder.failTPage(1, "无效的红包专场");
        }

        GetDuoduoGoodsListRequest listRequest = new GetDuoduoGoodsListRequest();
        listRequest.setPage(request.getPage());
        listRequest.setPageSize(request.getRows());
        //默认综合排序
        listRequest.setSortType(0);
        //设置红包金额
        if (request.getRpfType() == 1) {
            listRequest.setCouponPrice(packageField.getBaseRedPacket());
        } else {
            listRequest.setCouponPrice(packageField.getAssistanceRedPacket());
        }

        TPageResult<GoodsInfoDTO> result = goodsInfoService.searchCouponGoods(listRequest);

        if (result != null && result.getValues() != null) {

            List<RedPackageGoodsDTO> redPackageGoodsDTOList = BeanConvUtil.copy(result.getValues(),
                    RedPackageGoodsDTO.class);

            return ResultBuilder.succTPage(redPackageGoodsDTOList, request.getPage(),
                    request.getRows(), result.getTotalRows());
        }

        return ResultBuilder.succTPage(Lists.newArrayList(), request.getPage(), request.getRows(),
                0);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public TSingleResult<Boolean> remove(Integer id) {
        boolean success = redPackageGoodsMapper.deleteByPrimaryKey(id) > 0;
        return ResultBuilder.succTSingle(success);
    }

    /**
     * 删除所有
     *
     * @param rpfId
     * @param rpfType
     * @return
     */
    @Override
    public TSingleResult<Boolean> removeAll(Integer rpfId, Integer rpfType) {
        RedPackageGoodsExample goodsExample = new RedPackageGoodsExample();
        RedPackageGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andRpfIdEqualTo(rpfId);
        criteria.andRpfTypeEqualTo(rpfType);
        boolean success = redPackageGoodsMapper.deleteByExample(goodsExample) > 0;
        return ResultBuilder.succTSingle(success);
    }

    /**
     * 修改状态
     *
     * @param id
     * @param sort
     * @return
     */
    @Override
    public TSingleResult<Boolean> modifySort(Integer id, Integer sort) {

        RedPackageGoods model = new RedPackageGoods();
        model.setSort(sort);
        model.setId(id);

        //修改
        boolean success = redPackageGoodsMapper.updateByPrimaryKeySelective(model) > 0;

        return ResultBuilder.succTSingle(success);
    }

    /**
     * 更新专场商品
     *
     * @param
     * @return
     */
    @Override
    public TSingleResult<Boolean> refreshGoods() {
        int skip = 0, rows = 100;
        while (true) {
            Map<String, Object> params = Maps.newHashMap();
            params.put("skip", skip);
            params.put("rows", rows);
            params.put("goodsTable", goodsInfoRepository.getUseTableName());

            List<DuoGoodsInfo> goodsInfos = extRedPackageGoodsMapper.queryUsingGoods(params);

            if (goodsInfos != null && goodsInfos.size() > 0) {
                try {
                    //最大的商品id
                    skip += goodsInfos.size();
                    goodsManager.updateGoods(goodsInfos, null, 0);
                    if (goodsInfos.size() < rows) {
                        break;
                    }
                } catch (Exception ex) {
                    LOGGER.error("更新红包专场商品失败:{}", ex);
                    skip += rows;
                }
            } else {
                break;
            }
        }

        LOGGER.info("更新红包专场商品中条数：" + skip);

        return ResultBuilder.succTSingle(true);
    }

}
