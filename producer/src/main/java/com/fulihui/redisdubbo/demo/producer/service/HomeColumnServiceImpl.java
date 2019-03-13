package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.HomeColumnService;
import com.fulihui.redisdubbo.demo.api.dto.HomeColumnDTO;
import com.fulihui.redisdubbo.demo.api.request.HomeColumnRequest;
import com.fulihui.redisdubbo.demo.producer.dal.convert.HomeColumnConvert;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.HomeColumn;
import com.fulihui.redisdubbo.demo.producer.repository.HomeColumnRepository;
import com.fulihui.redisdubbo.demo.weixin.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:55
 */
@Service(version = "${demo.service.version}")

public class HomeColumnServiceImpl implements HomeColumnService {

    @Autowired
    private HomeColumnRepository homeColumnRepository;

    @Override
    public TMultiResult<HomeColumnDTO> queryPage(HomeColumnRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        HomeColumn homeColumn = new HomeColumn();
        //数据转换
        BeanUtils.copyProperties(request, homeColumn);
        List<HomeColumn> list = homeColumnRepository.selectByExample(homeColumn);
        List<HomeColumnDTO> convert = HomeColumnConvert.convert(list);
        return ResultBuilder.succTMulti(convert);
    }

    @Override
    public TSingleResult<Boolean> update(HomeColumnDTO homeColumnDTO) {
        HomeColumn homeColumn = BeanConvUtil.copy(homeColumnDTO, HomeColumn.class);

        boolean success = homeColumnRepository.update(homeColumn) > 0;

        return ResultBuilder.succTSingle(success);
    }

    @Override
    public TSingleResult<HomeColumnDTO> querySingle(HomeColumnRequest request) {

        HomeColumn homeColumn = homeColumnRepository.selectByPrimaryKey(request.getId());
        HomeColumnDTO dto = new HomeColumnDTO();
        BeanUtils.copyProperties(homeColumn, dto);
        return ResultBuilder.succTSingle(dto);
    }
}
