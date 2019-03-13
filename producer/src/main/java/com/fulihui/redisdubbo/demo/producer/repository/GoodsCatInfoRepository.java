package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.GoodsCatInfoTreeNodeDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsCatInfo;

import java.util.List;


/**
 * @author Administrator
 */
public interface GoodsCatInfoRepository {


    GoodsCatInfo selectByPrimaryKey(Integer id);

    int insert(GoodsCatInfo goodsCatInfo);

    int count(GoodsCatInfo dataModel);


    List<GoodsCatInfoTreeNodeDTO> tree(Integer parentCatId, List levelList, String status);

    List<GoodsCatInfo> selectBylevel(Integer level);

    List<GoodsCatInfoTreeNodeDTO> queryTree(GoodsCatInfo dataModel, int page, int rows);

}