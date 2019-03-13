package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.biz.model.GoodsCatInfoPageCount;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsCatInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Ext goods cat info mapper.
 *
 * @author lizhi
 */
public interface ExtGoodsCatInfoMapper {

    /**
     * tree
     *
     * @param parentCatId the parent cat id
     * @param offset      the offset
     * @param limit       the limit
     * @param levelList   the level list
     * @return list
     */
    List<GoodsCatInfo> tree(@Param("parentCatId") Integer parentCatId,
                            @Param("offset") Integer offset, @Param("limit") Integer limit
            , @Param("levelList") List levelList, @Param("status") String status
    );

    /**
     * Count list.
     *
     * @param parentCatId the parent cat id
     * @param levelList   the level list
     * @return the list
     */
    List<GoodsCatInfoPageCount> count(@Param("parentCatId") Integer parentCatId, @Param("levelList") List levelList
    );

    /**
     * 查询分类信息
     *
     * @param catIds the cat ids
     * @return list
     */
    List<GoodsCatInfo> queryByIDArray(@Param("catIds") List<Integer> catIds);
}