package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public GoodsInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNull() {
            addCriterion("goods_desc is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNotNull() {
            addCriterion("goods_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescEqualTo(String value) {
            addCriterion("goods_desc =", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotEqualTo(String value) {
            addCriterion("goods_desc <>", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThan(String value) {
            addCriterion("goods_desc >", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            addCriterion("goods_desc >=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThan(String value) {
            addCriterion("goods_desc <", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThanOrEqualTo(String value) {
            addCriterion("goods_desc <=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLike(String value) {
            addCriterion("goods_desc like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotLike(String value) {
            addCriterion("goods_desc not like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIn(List<String> values) {
            addCriterion("goods_desc in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotIn(List<String> values) {
            addCriterion("goods_desc not in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescBetween(String value1, String value2) {
            addCriterion("goods_desc between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotBetween(String value1, String value2) {
            addCriterion("goods_desc not between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlIsNull() {
            addCriterion("goods_thumbnail_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlIsNotNull() {
            addCriterion("goods_thumbnail_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlEqualTo(String value) {
            addCriterion("goods_thumbnail_url =", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotEqualTo(String value) {
            addCriterion("goods_thumbnail_url <>", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlGreaterThan(String value) {
            addCriterion("goods_thumbnail_url >", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_thumbnail_url >=", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlLessThan(String value) {
            addCriterion("goods_thumbnail_url <", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_thumbnail_url <=", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlLike(String value) {
            addCriterion("goods_thumbnail_url like", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotLike(String value) {
            addCriterion("goods_thumbnail_url not like", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlIn(List<String> values) {
            addCriterion("goods_thumbnail_url in", values, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotIn(List<String> values) {
            addCriterion("goods_thumbnail_url not in", values, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlBetween(String value1, String value2) {
            addCriterion("goods_thumbnail_url between", value1, value2, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotBetween(String value1, String value2) {
            addCriterion("goods_thumbnail_url not between", value1, value2, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlIsNull() {
            addCriterion("goods_image_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlIsNotNull() {
            addCriterion("goods_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlEqualTo(String value) {
            addCriterion("goods_image_url =", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlNotEqualTo(String value) {
            addCriterion("goods_image_url <>", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlGreaterThan(String value) {
            addCriterion("goods_image_url >", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_image_url >=", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlLessThan(String value) {
            addCriterion("goods_image_url <", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_image_url <=", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlLike(String value) {
            addCriterion("goods_image_url like", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlNotLike(String value) {
            addCriterion("goods_image_url not like", value, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlIn(List<String> values) {
            addCriterion("goods_image_url in", values, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlNotIn(List<String> values) {
            addCriterion("goods_image_url not in", values, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlBetween(String value1, String value2) {
            addCriterion("goods_image_url between", value1, value2, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImageUrlNotBetween(String value1, String value2) {
            addCriterion("goods_image_url not between", value1, value2, "goodsImageUrl");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityIsNull() {
            addCriterion("sold_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityIsNotNull() {
            addCriterion("sold_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityEqualTo(Integer value) {
            addCriterion("sold_quantity =", value, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityNotEqualTo(Integer value) {
            addCriterion("sold_quantity <>", value, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityGreaterThan(Integer value) {
            addCriterion("sold_quantity >", value, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sold_quantity >=", value, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityLessThan(Integer value) {
            addCriterion("sold_quantity <", value, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("sold_quantity <=", value, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityIn(List<Integer> values) {
            addCriterion("sold_quantity in", values, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityNotIn(List<Integer> values) {
            addCriterion("sold_quantity not in", values, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityBetween(Integer value1, Integer value2) {
            addCriterion("sold_quantity between", value1, value2, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andSoldQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("sold_quantity not between", value1, value2, "soldQuantity");
            return (Criteria) this;
        }

        public Criteria andMallNameIsNull() {
            addCriterion("mall_name is null");
            return (Criteria) this;
        }

        public Criteria andMallNameIsNotNull() {
            addCriterion("mall_name is not null");
            return (Criteria) this;
        }

        public Criteria andMallNameEqualTo(String value) {
            addCriterion("mall_name =", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotEqualTo(String value) {
            addCriterion("mall_name <>", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameGreaterThan(String value) {
            addCriterion("mall_name >", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameGreaterThanOrEqualTo(String value) {
            addCriterion("mall_name >=", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameLessThan(String value) {
            addCriterion("mall_name <", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameLessThanOrEqualTo(String value) {
            addCriterion("mall_name <=", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameLike(String value) {
            addCriterion("mall_name like", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotLike(String value) {
            addCriterion("mall_name not like", value, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameIn(List<String> values) {
            addCriterion("mall_name in", values, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotIn(List<String> values) {
            addCriterion("mall_name not in", values, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameBetween(String value1, String value2) {
            addCriterion("mall_name between", value1, value2, "mallName");
            return (Criteria) this;
        }

        public Criteria andMallNameNotBetween(String value1, String value2) {
            addCriterion("mall_name not between", value1, value2, "mallName");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceIsNull() {
            addCriterion("min_normal_price is null");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceIsNotNull() {
            addCriterion("min_normal_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceEqualTo(Integer value) {
            addCriterion("min_normal_price =", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceNotEqualTo(Integer value) {
            addCriterion("min_normal_price <>", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceGreaterThan(Integer value) {
            addCriterion("min_normal_price >", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_normal_price >=", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceLessThan(Integer value) {
            addCriterion("min_normal_price <", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceLessThanOrEqualTo(Integer value) {
            addCriterion("min_normal_price <=", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceIn(List<Integer> values) {
            addCriterion("min_normal_price in", values, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceNotIn(List<Integer> values) {
            addCriterion("min_normal_price not in", values, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceBetween(Integer value1, Integer value2) {
            addCriterion("min_normal_price between", value1, value2, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("min_normal_price not between", value1, value2, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceIsNull() {
            addCriterion("min_group_price is null");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceIsNotNull() {
            addCriterion("min_group_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceEqualTo(Integer value) {
            addCriterion("min_group_price =", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceNotEqualTo(Integer value) {
            addCriterion("min_group_price <>", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceGreaterThan(Integer value) {
            addCriterion("min_group_price >", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_group_price >=", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceLessThan(Integer value) {
            addCriterion("min_group_price <", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceLessThanOrEqualTo(Integer value) {
            addCriterion("min_group_price <=", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceIn(List<Integer> values) {
            addCriterion("min_group_price in", values, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceNotIn(List<Integer> values) {
            addCriterion("min_group_price not in", values, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceBetween(Integer value1, Integer value2) {
            addCriterion("min_group_price between", value1, value2, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("min_group_price not between", value1, value2, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andOptNameIsNull() {
            addCriterion("opt_name is null");
            return (Criteria) this;
        }

        public Criteria andOptNameIsNotNull() {
            addCriterion("opt_name is not null");
            return (Criteria) this;
        }

        public Criteria andOptNameEqualTo(String value) {
            addCriterion("opt_name =", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotEqualTo(String value) {
            addCriterion("opt_name <>", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameGreaterThan(String value) {
            addCriterion("opt_name >", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("opt_name >=", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameLessThan(String value) {
            addCriterion("opt_name <", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameLessThanOrEqualTo(String value) {
            addCriterion("opt_name <=", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameLike(String value) {
            addCriterion("opt_name like", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotLike(String value) {
            addCriterion("opt_name not like", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameIn(List<String> values) {
            addCriterion("opt_name in", values, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotIn(List<String> values) {
            addCriterion("opt_name not in", values, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameBetween(String value1, String value2) {
            addCriterion("opt_name between", value1, value2, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotBetween(String value1, String value2) {
            addCriterion("opt_name not between", value1, value2, "optName");
            return (Criteria) this;
        }

        public Criteria andOptIdIsNull() {
            addCriterion("opt_id is null");
            return (Criteria) this;
        }

        public Criteria andOptIdIsNotNull() {
            addCriterion("opt_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptIdEqualTo(Integer value) {
            addCriterion("opt_id =", value, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdNotEqualTo(Integer value) {
            addCriterion("opt_id <>", value, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdGreaterThan(Integer value) {
            addCriterion("opt_id >", value, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_id >=", value, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdLessThan(Integer value) {
            addCriterion("opt_id <", value, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdLessThanOrEqualTo(Integer value) {
            addCriterion("opt_id <=", value, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdIn(List<Integer> values) {
            addCriterion("opt_id in", values, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdNotIn(List<Integer> values) {
            addCriterion("opt_id not in", values, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdBetween(Integer value1, Integer value2) {
            addCriterion("opt_id between", value1, value2, "optId");
            return (Criteria) this;
        }

        public Criteria andOptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_id not between", value1, value2, "optId");
            return (Criteria) this;
        }

        public Criteria andCatIdsIsNull() {
            addCriterion("cat_ids is null");
            return (Criteria) this;
        }

        public Criteria andCatIdsIsNotNull() {
            addCriterion("cat_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCatIdsEqualTo(String value) {
            addCriterion("cat_ids =", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsNotEqualTo(String value) {
            addCriterion("cat_ids <>", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsGreaterThan(String value) {
            addCriterion("cat_ids >", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsGreaterThanOrEqualTo(String value) {
            addCriterion("cat_ids >=", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsLessThan(String value) {
            addCriterion("cat_ids <", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsLessThanOrEqualTo(String value) {
            addCriterion("cat_ids <=", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsLike(String value) {
            addCriterion("cat_ids like", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsNotLike(String value) {
            addCriterion("cat_ids not like", value, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsIn(List<String> values) {
            addCriterion("cat_ids in", values, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsNotIn(List<String> values) {
            addCriterion("cat_ids not in", values, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsBetween(String value1, String value2) {
            addCriterion("cat_ids between", value1, value2, "catIds");
            return (Criteria) this;
        }

        public Criteria andCatIdsNotBetween(String value1, String value2) {
            addCriterion("cat_ids not between", value1, value2, "catIds");
            return (Criteria) this;
        }

        public Criteria andLevelOneIsNull() {
            addCriterion("level_one is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneIsNotNull() {
            addCriterion("level_one is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneEqualTo(Integer value) {
            addCriterion("level_one =", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotEqualTo(Integer value) {
            addCriterion("level_one <>", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThan(Integer value) {
            addCriterion("level_one >", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_one >=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThan(Integer value) {
            addCriterion("level_one <", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThanOrEqualTo(Integer value) {
            addCriterion("level_one <=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneIn(List<Integer> values) {
            addCriterion("level_one in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotIn(List<Integer> values) {
            addCriterion("level_one not in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneBetween(Integer value1, Integer value2) {
            addCriterion("level_one between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotBetween(Integer value1, Integer value2) {
            addCriterion("level_one not between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNull() {
            addCriterion("level_two is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotNull() {
            addCriterion("level_two is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoEqualTo(Integer value) {
            addCriterion("level_two =", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotEqualTo(Integer value) {
            addCriterion("level_two <>", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThan(Integer value) {
            addCriterion("level_two >", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_two >=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThan(Integer value) {
            addCriterion("level_two <", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThanOrEqualTo(Integer value) {
            addCriterion("level_two <=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIn(List<Integer> values) {
            addCriterion("level_two in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotIn(List<Integer> values) {
            addCriterion("level_two not in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBetween(Integer value1, Integer value2) {
            addCriterion("level_two between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotBetween(Integer value1, Integer value2) {
            addCriterion("level_two not between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIsNull() {
            addCriterion("level_three is null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIsNotNull() {
            addCriterion("level_three is not null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeEqualTo(Integer value) {
            addCriterion("level_three =", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotEqualTo(Integer value) {
            addCriterion("level_three <>", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeGreaterThan(Integer value) {
            addCriterion("level_three >", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_three >=", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeLessThan(Integer value) {
            addCriterion("level_three <", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeLessThanOrEqualTo(Integer value) {
            addCriterion("level_three <=", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIn(List<Integer> values) {
            addCriterion("level_three in", values, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotIn(List<Integer> values) {
            addCriterion("level_three not in", values, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeBetween(Integer value1, Integer value2) {
            addCriterion("level_three between", value1, value2, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotBetween(Integer value1, Integer value2) {
            addCriterion("level_three not between", value1, value2, "levelThree");
            return (Criteria) this;
        }

        public Criteria andHasCouponIsNull() {
            addCriterion("has_coupon is null");
            return (Criteria) this;
        }

        public Criteria andHasCouponIsNotNull() {
            addCriterion("has_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andHasCouponEqualTo(String value) {
            addCriterion("has_coupon =", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponNotEqualTo(String value) {
            addCriterion("has_coupon <>", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponGreaterThan(String value) {
            addCriterion("has_coupon >", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponGreaterThanOrEqualTo(String value) {
            addCriterion("has_coupon >=", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponLessThan(String value) {
            addCriterion("has_coupon <", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponLessThanOrEqualTo(String value) {
            addCriterion("has_coupon <=", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponLike(String value) {
            addCriterion("has_coupon like", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponNotLike(String value) {
            addCriterion("has_coupon not like", value, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponIn(List<String> values) {
            addCriterion("has_coupon in", values, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponNotIn(List<String> values) {
            addCriterion("has_coupon not in", values, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponBetween(String value1, String value2) {
            addCriterion("has_coupon between", value1, value2, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andHasCouponNotBetween(String value1, String value2) {
            addCriterion("has_coupon not between", value1, value2, "hasCoupon");
            return (Criteria) this;
        }

        public Criteria andAvgServIsNull() {
            addCriterion("avg_serv is null");
            return (Criteria) this;
        }

        public Criteria andAvgServIsNotNull() {
            addCriterion("avg_serv is not null");
            return (Criteria) this;
        }

        public Criteria andAvgServEqualTo(Integer value) {
            addCriterion("avg_serv =", value, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServNotEqualTo(Integer value) {
            addCriterion("avg_serv <>", value, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServGreaterThan(Integer value) {
            addCriterion("avg_serv >", value, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServGreaterThanOrEqualTo(Integer value) {
            addCriterion("avg_serv >=", value, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServLessThan(Integer value) {
            addCriterion("avg_serv <", value, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServLessThanOrEqualTo(Integer value) {
            addCriterion("avg_serv <=", value, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServIn(List<Integer> values) {
            addCriterion("avg_serv in", values, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServNotIn(List<Integer> values) {
            addCriterion("avg_serv not in", values, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServBetween(Integer value1, Integer value2) {
            addCriterion("avg_serv between", value1, value2, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgServNotBetween(Integer value1, Integer value2) {
            addCriterion("avg_serv not between", value1, value2, "avgServ");
            return (Criteria) this;
        }

        public Criteria andAvgLgstIsNull() {
            addCriterion("avg_lgst is null");
            return (Criteria) this;
        }

        public Criteria andAvgLgstIsNotNull() {
            addCriterion("avg_lgst is not null");
            return (Criteria) this;
        }

        public Criteria andAvgLgstEqualTo(Integer value) {
            addCriterion("avg_lgst =", value, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstNotEqualTo(Integer value) {
            addCriterion("avg_lgst <>", value, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstGreaterThan(Integer value) {
            addCriterion("avg_lgst >", value, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstGreaterThanOrEqualTo(Integer value) {
            addCriterion("avg_lgst >=", value, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstLessThan(Integer value) {
            addCriterion("avg_lgst <", value, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstLessThanOrEqualTo(Integer value) {
            addCriterion("avg_lgst <=", value, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstIn(List<Integer> values) {
            addCriterion("avg_lgst in", values, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstNotIn(List<Integer> values) {
            addCriterion("avg_lgst not in", values, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstBetween(Integer value1, Integer value2) {
            addCriterion("avg_lgst between", value1, value2, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgLgstNotBetween(Integer value1, Integer value2) {
            addCriterion("avg_lgst not between", value1, value2, "avgLgst");
            return (Criteria) this;
        }

        public Criteria andAvgDescIsNull() {
            addCriterion("avg_desc is null");
            return (Criteria) this;
        }

        public Criteria andAvgDescIsNotNull() {
            addCriterion("avg_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAvgDescEqualTo(Integer value) {
            addCriterion("avg_desc =", value, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescNotEqualTo(Integer value) {
            addCriterion("avg_desc <>", value, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescGreaterThan(Integer value) {
            addCriterion("avg_desc >", value, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescGreaterThanOrEqualTo(Integer value) {
            addCriterion("avg_desc >=", value, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescLessThan(Integer value) {
            addCriterion("avg_desc <", value, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescLessThanOrEqualTo(Integer value) {
            addCriterion("avg_desc <=", value, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescIn(List<Integer> values) {
            addCriterion("avg_desc in", values, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescNotIn(List<Integer> values) {
            addCriterion("avg_desc not in", values, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescBetween(Integer value1, Integer value2) {
            addCriterion("avg_desc between", value1, value2, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andAvgDescNotBetween(Integer value1, Integer value2) {
            addCriterion("avg_desc not between", value1, value2, "avgDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsIsNull() {
            addCriterion("goods_gallery_urls is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsIsNotNull() {
            addCriterion("goods_gallery_urls is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsEqualTo(String value) {
            addCriterion("goods_gallery_urls =", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsNotEqualTo(String value) {
            addCriterion("goods_gallery_urls <>", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsGreaterThan(String value) {
            addCriterion("goods_gallery_urls >", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_gallery_urls >=", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsLessThan(String value) {
            addCriterion("goods_gallery_urls <", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsLessThanOrEqualTo(String value) {
            addCriterion("goods_gallery_urls <=", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsLike(String value) {
            addCriterion("goods_gallery_urls like", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsNotLike(String value) {
            addCriterion("goods_gallery_urls not like", value, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsIn(List<String> values) {
            addCriterion("goods_gallery_urls in", values, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsNotIn(List<String> values) {
            addCriterion("goods_gallery_urls not in", values, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsBetween(String value1, String value2) {
            addCriterion("goods_gallery_urls between", value1, value2, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsGalleryUrlsNotBetween(String value1, String value2) {
            addCriterion("goods_gallery_urls not between", value1, value2, "goodsGalleryUrls");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountIsNull() {
            addCriterion("goods_eval_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountIsNotNull() {
            addCriterion("goods_eval_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountEqualTo(Integer value) {
            addCriterion("goods_eval_count =", value, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountNotEqualTo(Integer value) {
            addCriterion("goods_eval_count <>", value, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountGreaterThan(Integer value) {
            addCriterion("goods_eval_count >", value, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_eval_count >=", value, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountLessThan(Integer value) {
            addCriterion("goods_eval_count <", value, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_eval_count <=", value, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountIn(List<Integer> values) {
            addCriterion("goods_eval_count in", values, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountNotIn(List<Integer> values) {
            addCriterion("goods_eval_count not in", values, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_eval_count between", value1, value2, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_eval_count not between", value1, value2, "goodsEvalCount");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreIsNull() {
            addCriterion("goods_eval_score is null");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreIsNotNull() {
            addCriterion("goods_eval_score is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreEqualTo(String value) {
            addCriterion("goods_eval_score =", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreNotEqualTo(String value) {
            addCriterion("goods_eval_score <>", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreGreaterThan(String value) {
            addCriterion("goods_eval_score >", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreGreaterThanOrEqualTo(String value) {
            addCriterion("goods_eval_score >=", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreLessThan(String value) {
            addCriterion("goods_eval_score <", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreLessThanOrEqualTo(String value) {
            addCriterion("goods_eval_score <=", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreLike(String value) {
            addCriterion("goods_eval_score like", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreNotLike(String value) {
            addCriterion("goods_eval_score not like", value, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreIn(List<String> values) {
            addCriterion("goods_eval_score in", values, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreNotIn(List<String> values) {
            addCriterion("goods_eval_score not in", values, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreBetween(String value1, String value2) {
            addCriterion("goods_eval_score between", value1, value2, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsEvalScoreNotBetween(String value1, String value2) {
            addCriterion("goods_eval_score not between", value1, value2, "goodsEvalScore");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIsNull() {
            addCriterion("promotion_rate is null");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIsNotNull() {
            addCriterion("promotion_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionRateEqualTo(Integer value) {
            addCriterion("promotion_rate =", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotEqualTo(Integer value) {
            addCriterion("promotion_rate <>", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateGreaterThan(Integer value) {
            addCriterion("promotion_rate >", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_rate >=", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLessThan(Integer value) {
            addCriterion("promotion_rate <", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_rate <=", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIn(List<Integer> values) {
            addCriterion("promotion_rate in", values, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotIn(List<Integer> values) {
            addCriterion("promotion_rate not in", values, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateBetween(Integer value1, Integer value2) {
            addCriterion("promotion_rate between", value1, value2, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_rate not between", value1, value2, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeIsNull() {
            addCriterion("coupon_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeIsNotNull() {
            addCriterion("coupon_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeEqualTo(Date value) {
            addCriterion("coupon_end_time =", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeNotEqualTo(Date value) {
            addCriterion("coupon_end_time <>", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeGreaterThan(Date value) {
            addCriterion("coupon_end_time >", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_end_time >=", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeLessThan(Date value) {
            addCriterion("coupon_end_time <", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_end_time <=", value, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeIn(List<Date> values) {
            addCriterion("coupon_end_time in", values, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeNotIn(List<Date> values) {
            addCriterion("coupon_end_time not in", values, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_end_time between", value1, value2, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_end_time not between", value1, value2, "couponEndTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNull() {
            addCriterion("coupon_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNotNull() {
            addCriterion("coupon_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeEqualTo(Date value) {
            addCriterion("coupon_start_time =", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotEqualTo(Date value) {
            addCriterion("coupon_start_time <>", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThan(Date value) {
            addCriterion("coupon_start_time >", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_start_time >=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThan(Date value) {
            addCriterion("coupon_start_time <", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_start_time <=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIn(List<Date> values) {
            addCriterion("coupon_start_time in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotIn(List<Date> values) {
            addCriterion("coupon_start_time not in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_start_time between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_start_time not between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityIsNull() {
            addCriterion("coupon_remain_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityIsNotNull() {
            addCriterion("coupon_remain_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityEqualTo(Integer value) {
            addCriterion("coupon_remain_quantity =", value, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityNotEqualTo(Integer value) {
            addCriterion("coupon_remain_quantity <>", value, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityGreaterThan(Integer value) {
            addCriterion("coupon_remain_quantity >", value, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_remain_quantity >=", value, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityLessThan(Integer value) {
            addCriterion("coupon_remain_quantity <", value, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_remain_quantity <=", value, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityIn(List<Integer> values) {
            addCriterion("coupon_remain_quantity in", values, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityNotIn(List<Integer> values) {
            addCriterion("coupon_remain_quantity not in", values, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityBetween(Integer value1, Integer value2) {
            addCriterion("coupon_remain_quantity between", value1, value2, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponRemainQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_remain_quantity not between", value1, value2, "couponRemainQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityIsNull() {
            addCriterion("coupon_total_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityIsNotNull() {
            addCriterion("coupon_total_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityEqualTo(Integer value) {
            addCriterion("coupon_total_quantity =", value, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityNotEqualTo(Integer value) {
            addCriterion("coupon_total_quantity <>", value, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityGreaterThan(Integer value) {
            addCriterion("coupon_total_quantity >", value, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_total_quantity >=", value, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityLessThan(Integer value) {
            addCriterion("coupon_total_quantity <", value, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_total_quantity <=", value, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityIn(List<Integer> values) {
            addCriterion("coupon_total_quantity in", values, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityNotIn(List<Integer> values) {
            addCriterion("coupon_total_quantity not in", values, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total_quantity between", value1, value2, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponTotalQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total_quantity not between", value1, value2, "couponTotalQuantity");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountIsNull() {
            addCriterion("coupon_discount is null");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountIsNotNull() {
            addCriterion("coupon_discount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountEqualTo(Integer value) {
            addCriterion("coupon_discount =", value, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountNotEqualTo(Integer value) {
            addCriterion("coupon_discount <>", value, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountGreaterThan(Integer value) {
            addCriterion("coupon_discount >", value, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_discount >=", value, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountLessThan(Integer value) {
            addCriterion("coupon_discount <", value, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_discount <=", value, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountIn(List<Integer> values) {
            addCriterion("coupon_discount in", values, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountNotIn(List<Integer> values) {
            addCriterion("coupon_discount not in", values, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_discount between", value1, value2, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_discount not between", value1, value2, "couponDiscount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountIsNull() {
            addCriterion("coupon_min_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountIsNotNull() {
            addCriterion("coupon_min_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountEqualTo(Integer value) {
            addCriterion("coupon_min_order_amount =", value, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountNotEqualTo(Integer value) {
            addCriterion("coupon_min_order_amount <>", value, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountGreaterThan(Integer value) {
            addCriterion("coupon_min_order_amount >", value, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_min_order_amount >=", value, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountLessThan(Integer value) {
            addCriterion("coupon_min_order_amount <", value, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_min_order_amount <=", value, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountIn(List<Integer> values) {
            addCriterion("coupon_min_order_amount in", values, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountNotIn(List<Integer> values) {
            addCriterion("coupon_min_order_amount not in", values, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_min_order_amount between", value1, value2, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponMinOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_min_order_amount not between", value1, value2, "couponMinOrderAmount");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIsNull() {
            addCriterion("goods_sn is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIsNotNull() {
            addCriterion("goods_sn is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSnEqualTo(String value) {
            addCriterion("goods_sn =", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotEqualTo(String value) {
            addCriterion("goods_sn <>", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnGreaterThan(String value) {
            addCriterion("goods_sn >", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnGreaterThanOrEqualTo(String value) {
            addCriterion("goods_sn >=", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLessThan(String value) {
            addCriterion("goods_sn <", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLessThanOrEqualTo(String value) {
            addCriterion("goods_sn <=", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLike(String value) {
            addCriterion("goods_sn like", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotLike(String value) {
            addCriterion("goods_sn not like", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIn(List<String> values) {
            addCriterion("goods_sn in", values, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotIn(List<String> values) {
            addCriterion("goods_sn not in", values, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnBetween(String value1, String value2) {
            addCriterion("goods_sn between", value1, value2, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotBetween(String value1, String value2) {
            addCriterion("goods_sn not between", value1, value2, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateIsNull() {
            addCriterion("detail_update is null");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateIsNotNull() {
            addCriterion("detail_update is not null");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateEqualTo(Date value) {
            addCriterion("detail_update =", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateNotEqualTo(Date value) {
            addCriterion("detail_update <>", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateGreaterThan(Date value) {
            addCriterion("detail_update >", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("detail_update >=", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateLessThan(Date value) {
            addCriterion("detail_update <", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateLessThanOrEqualTo(Date value) {
            addCriterion("detail_update <=", value, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateIn(List<Date> values) {
            addCriterion("detail_update in", values, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateNotIn(List<Date> values) {
            addCriterion("detail_update not in", values, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateBetween(Date value1, Date value2) {
            addCriterion("detail_update between", value1, value2, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andDetailUpdateNotBetween(Date value1, Date value2) {
            addCriterion("detail_update not between", value1, value2, "detailUpdate");
            return (Criteria) this;
        }

        public Criteria andIsChooseIsNull() {
            addCriterion("is_choose is null");
            return (Criteria) this;
        }

        public Criteria andIsChooseIsNotNull() {
            addCriterion("is_choose is not null");
            return (Criteria) this;
        }

        public Criteria andIsChooseEqualTo(String value) {
            addCriterion("is_choose =", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotEqualTo(String value) {
            addCriterion("is_choose <>", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseGreaterThan(String value) {
            addCriterion("is_choose >", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseGreaterThanOrEqualTo(String value) {
            addCriterion("is_choose >=", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseLessThan(String value) {
            addCriterion("is_choose <", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseLessThanOrEqualTo(String value) {
            addCriterion("is_choose <=", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseLike(String value) {
            addCriterion("is_choose like", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotLike(String value) {
            addCriterion("is_choose not like", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseIn(List<String> values) {
            addCriterion("is_choose in", values, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotIn(List<String> values) {
            addCriterion("is_choose not in", values, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseBetween(String value1, String value2) {
            addCriterion("is_choose between", value1, value2, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotBetween(String value1, String value2) {
            addCriterion("is_choose not between", value1, value2, "isChoose");
            return (Criteria) this;
        }

        public Criteria andChooseSortIsNull() {
            addCriterion("choose_sort is null");
            return (Criteria) this;
        }

        public Criteria andChooseSortIsNotNull() {
            addCriterion("choose_sort is not null");
            return (Criteria) this;
        }

        public Criteria andChooseSortEqualTo(Integer value) {
            addCriterion("choose_sort =", value, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortNotEqualTo(Integer value) {
            addCriterion("choose_sort <>", value, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortGreaterThan(Integer value) {
            addCriterion("choose_sort >", value, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("choose_sort >=", value, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortLessThan(Integer value) {
            addCriterion("choose_sort <", value, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortLessThanOrEqualTo(Integer value) {
            addCriterion("choose_sort <=", value, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortIn(List<Integer> values) {
            addCriterion("choose_sort in", values, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortNotIn(List<Integer> values) {
            addCriterion("choose_sort not in", values, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortBetween(Integer value1, Integer value2) {
            addCriterion("choose_sort between", value1, value2, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andChooseSortNotBetween(Integer value1, Integer value2) {
            addCriterion("choose_sort not between", value1, value2, "chooseSort");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}