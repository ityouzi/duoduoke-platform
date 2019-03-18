package com.fulihui.duoduoke.demo.producer.service;



import com.fulihui.duoduoke.demo.api.api.BannerService;
import com.fulihui.duoduoke.demo.api.constant.MessageConstant;
import com.fulihui.duoduoke.demo.api.dto.BannerDto;
import com.fulihui.duoduoke.demo.api.request.BannerAddRequest;
import com.fulihui.duoduoke.demo.api.request.BannerSelectRequest;
import com.fulihui.duoduoke.demo.api.request.BannerUpdateRequest;
import com.fulihui.duoduoke.demo.producer.dal.dao.*;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.Banner;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.Position;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PositionBanner;
import com.fulihui.duoduoke.demo.producer.model.PositionAddSelectModel;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service(version = "${demo.service.version}")

public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    PositionBannerMapper positionBannerMapper;
    @Autowired
    PositionMapper positionMapper;

    @Autowired
    ExtBannerMapper extBannerMapper;
    @Autowired
    ExtPositionBannerMapper extPositionBannerMapper;
    @Autowired
    ExtPositionMapper extPositionMapper;

    @Override
    public BaseResult addBanner(BannerAddRequest bannerAddRequest) {

        //1.判断 模块位置是否存在，不存在，新增模块位置
        if (StringUtils.isEmpty(bannerAddRequest.getModuleCode()) || StringUtils.isEmpty(bannerAddRequest.getPositionCode())) {
            return ResultBuilder.fail(MessageConstant.ResultCode.PositionIdIsNull, MessageConstant.ResultMessage.PositionIdIsNull);
        }
        PositionAddSelectModel positionAddSelectModel = new PositionAddSelectModel();
        positionAddSelectModel.setModuleCode(bannerAddRequest.getModuleCode());
        positionAddSelectModel.setPostionCode(bannerAddRequest.getPositionCode());
        Long positionId = extPositionMapper.selectByPosition(positionAddSelectModel);
        if (positionId == null) {
            Position position = new Position();
            position.setGmtCreate(new Date());
            position.setGmtModified(new Date());
            position.setModuleCode(bannerAddRequest.getModuleCode());
            position.setModuleName(bannerAddRequest.getModuleName());
            position.setPositionCode(bannerAddRequest.getPositionCode());
            position.setPositionName(bannerAddRequest.getPositionName());
            positionMapper.insert(position);
            positionId = position.getId();
        }
        //2.存在
        Banner banner = new Banner();
        banner.setActionUrl(bannerAddRequest.getActionUrl());
        banner.setImageUrl(bannerAddRequest.getImageUrl());
        banner.setGmtCreate(new Date());
        banner.setGmtModified(new Date());
        banner.setStatus(bannerAddRequest.getStatus());
        bannerMapper.insert(banner);
        Long bannerId = banner.getId();
        //3.
        PositionBanner positionBanner = new PositionBanner();
        positionBanner.setBannerId(bannerId);
        positionBanner.setPositionCode(bannerAddRequest.getPositionCode());
        positionBanner.setPositionId(positionId);
        positionBanner.setGmtCreate(new Date());
        positionBanner.setGmtModified(new Date());
        positionBanner.setOrderBy(bannerAddRequest.getOrderBy());
        positionBanner.setStatus(bannerAddRequest.getStatus());
        positionBanner.setParamJson(bannerAddRequest.getParamsJson());
        positionBanner.setStartTime(bannerAddRequest.getStartTime());
        positionBanner.setEndTime(bannerAddRequest.getEndTime());
        positionBannerMapper.insert(positionBanner);
        if (positionBanner.getId() != null) {
            return ResultBuilder.succ();
        } else {
            return ResultBuilder.fail(MessageConstant.ResultCode.MysqlInsertFailed, MessageConstant.ResultMessage.MysqlInsertFailed);
        }
    }

    @Override
    public BaseResult deleteBanner(Long positionBannerId) {
        if (StringUtils.isEmpty(positionBannerId)) {
            return ResultBuilder.fail(MessageConstant.ResultCode.PositionIdIsNull, MessageConstant.ResultMessage.PositionIdIsNull);
        }
        PositionBanner p = positionBannerMapper.selectByPrimaryKey(positionBannerId);
        positionBannerMapper.deleteByPrimaryKey(positionBannerId);
        if (p != null) {
            bannerMapper.deleteByPrimaryKey(p.getBannerId());
        }
        return ResultBuilder.succ();
    }

    @Override
    public BaseResult updateBanner(BannerUpdateRequest bannerUpdateRequest) {
        if (StringUtils.isEmpty(bannerUpdateRequest.getPositionBannerId())) {
            return ResultBuilder.fail(MessageConstant.ResultCode.PositionIdIsNull, MessageConstant.ResultMessage.PositionIdIsNull);
        }
        //1.先查询 不存在 返回错误
        PositionBanner p = positionBannerMapper.selectByPrimaryKey(bannerUpdateRequest.getPositionBannerId());
        if (p == null) {
            return ResultBuilder.fail(MessageConstant.ResultCode.PositionIsNull, MessageConstant.ResultMessage.PositionIsNull);
        }
        //2.更新banner positionBanner; 只能更新排序 参数 图片 反应
        Banner banner = bannerMapper.selectByPrimaryKey(p.getBannerId());
        if (banner == null) {
            return ResultBuilder.fail(MessageConstant.ResultCode.BannerIsNull, MessageConstant.ResultMessage.BannerIsNull);
        }
        p.setGmtModified(new Date());
        p.setParamJson(bannerUpdateRequest.getParamsJson());
        p.setOrderBy(bannerUpdateRequest.getOrderBy());
        p.setStatus(bannerUpdateRequest.getStatus());
        p.setStartTime(bannerUpdateRequest.getStartTime());
        p.setEndTime(bannerUpdateRequest.getEndTime());
        positionBannerMapper.updateByPrimaryKey(p);
        banner.setGmtModified(new Date());
        banner.setImageUrl(bannerUpdateRequest.getImageUrl());
        banner.setActionUrl(bannerUpdateRequest.getActionUrl());
        banner.setStatus(bannerUpdateRequest.getStatus());
        bannerMapper.updateByPrimaryKey(banner);
        return ResultBuilder.succ();
    }

    @Override
    public TSingleResult<List<BannerDto>> selectBanner(BannerSelectRequest bannerSelectRequest) {
        if (StringUtils.isEmpty(bannerSelectRequest.getModuleCode())) {
            return ResultBuilder.failTSingle(MessageConstant.ResultCode.PositionIdIsNull, MessageConstant.ResultMessage.PositionIdIsNull);
        }
        List<BannerDto> list = extPositionBannerMapper.selectPositionBanner(bannerSelectRequest);
        return ResultBuilder.succTSingle(list);
    }


}
