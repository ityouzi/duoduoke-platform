package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsDoublesRewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public GoodsDoublesRewardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
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

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andRewardPercentIsNull() {
            addCriterion("reward_percent is null");
            return (Criteria) this;
        }

        public Criteria andRewardPercentIsNotNull() {
            addCriterion("reward_percent is not null");
            return (Criteria) this;
        }

        public Criteria andRewardPercentEqualTo(Float value) {
            addCriterion("reward_percent =", value, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentNotEqualTo(Float value) {
            addCriterion("reward_percent <>", value, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentGreaterThan(Float value) {
            addCriterion("reward_percent >", value, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentGreaterThanOrEqualTo(Float value) {
            addCriterion("reward_percent >=", value, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentLessThan(Float value) {
            addCriterion("reward_percent <", value, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentLessThanOrEqualTo(Float value) {
            addCriterion("reward_percent <=", value, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentIn(List<Float> values) {
            addCriterion("reward_percent in", values, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentNotIn(List<Float> values) {
            addCriterion("reward_percent not in", values, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentBetween(Float value1, Float value2) {
            addCriterion("reward_percent between", value1, value2, "rewardPercent");
            return (Criteria) this;
        }

        public Criteria andRewardPercentNotBetween(Float value1, Float value2) {
            addCriterion("reward_percent not between", value1, value2, "rewardPercent");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(Date value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(Date value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(Date value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(Date value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<Date> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<Date> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(Date value1, Date value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeIsNull() {
            addCriterion("activity_stop_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeIsNotNull() {
            addCriterion("activity_stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeEqualTo(Date value) {
            addCriterion("activity_stop_time =", value, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeNotEqualTo(Date value) {
            addCriterion("activity_stop_time <>", value, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeGreaterThan(Date value) {
            addCriterion("activity_stop_time >", value, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_stop_time >=", value, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeLessThan(Date value) {
            addCriterion("activity_stop_time <", value, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_stop_time <=", value, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeIn(List<Date> values) {
            addCriterion("activity_stop_time in", values, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeNotIn(List<Date> values) {
            addCriterion("activity_stop_time not in", values, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeBetween(Date value1, Date value2) {
            addCriterion("activity_stop_time between", value1, value2, "activityStopTime");
            return (Criteria) this;
        }

        public Criteria andActivityStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_stop_time not between", value1, value2, "activityStopTime");
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

        public Criteria andMinNormalPriceIsNull() {
            addCriterion("min_normal_price is null");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceIsNotNull() {
            addCriterion("min_normal_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceEqualTo(Long value) {
            addCriterion("min_normal_price =", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceNotEqualTo(Long value) {
            addCriterion("min_normal_price <>", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceGreaterThan(Long value) {
            addCriterion("min_normal_price >", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("min_normal_price >=", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceLessThan(Long value) {
            addCriterion("min_normal_price <", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceLessThanOrEqualTo(Long value) {
            addCriterion("min_normal_price <=", value, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceIn(List<Long> values) {
            addCriterion("min_normal_price in", values, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceNotIn(List<Long> values) {
            addCriterion("min_normal_price not in", values, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceBetween(Long value1, Long value2) {
            addCriterion("min_normal_price between", value1, value2, "minNormalPrice");
            return (Criteria) this;
        }

        public Criteria andMinNormalPriceNotBetween(Long value1, Long value2) {
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

        public Criteria andMinGroupPriceEqualTo(Long value) {
            addCriterion("min_group_price =", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceNotEqualTo(Long value) {
            addCriterion("min_group_price <>", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceGreaterThan(Long value) {
            addCriterion("min_group_price >", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("min_group_price >=", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceLessThan(Long value) {
            addCriterion("min_group_price <", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceLessThanOrEqualTo(Long value) {
            addCriterion("min_group_price <=", value, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceIn(List<Long> values) {
            addCriterion("min_group_price in", values, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceNotIn(List<Long> values) {
            addCriterion("min_group_price not in", values, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceBetween(Long value1, Long value2) {
            addCriterion("min_group_price between", value1, value2, "minGroupPrice");
            return (Criteria) this;
        }

        public Criteria andMinGroupPriceNotBetween(Long value1, Long value2) {
            addCriterion("min_group_price not between", value1, value2, "minGroupPrice");
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

        public Criteria andPromotionRateEqualTo(String value) {
            addCriterion("promotion_rate =", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotEqualTo(String value) {
            addCriterion("promotion_rate <>", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateGreaterThan(String value) {
            addCriterion("promotion_rate >", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_rate >=", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLessThan(String value) {
            addCriterion("promotion_rate <", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLessThanOrEqualTo(String value) {
            addCriterion("promotion_rate <=", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLike(String value) {
            addCriterion("promotion_rate like", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotLike(String value) {
            addCriterion("promotion_rate not like", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIn(List<String> values) {
            addCriterion("promotion_rate in", values, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotIn(List<String> values) {
            addCriterion("promotion_rate not in", values, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateBetween(String value1, String value2) {
            addCriterion("promotion_rate between", value1, value2, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotBetween(String value1, String value2) {
            addCriterion("promotion_rate not between", value1, value2, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionIsNull() {
            addCriterion("self_promotion is null");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionIsNotNull() {
            addCriterion("self_promotion is not null");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionEqualTo(String value) {
            addCriterion("self_promotion =", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionNotEqualTo(String value) {
            addCriterion("self_promotion <>", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionGreaterThan(String value) {
            addCriterion("self_promotion >", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionGreaterThanOrEqualTo(String value) {
            addCriterion("self_promotion >=", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionLessThan(String value) {
            addCriterion("self_promotion <", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionLessThanOrEqualTo(String value) {
            addCriterion("self_promotion <=", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionLike(String value) {
            addCriterion("self_promotion like", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionNotLike(String value) {
            addCriterion("self_promotion not like", value, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionIn(List<String> values) {
            addCriterion("self_promotion in", values, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionNotIn(List<String> values) {
            addCriterion("self_promotion not in", values, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionBetween(String value1, String value2) {
            addCriterion("self_promotion between", value1, value2, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSelfPromotionNotBetween(String value1, String value2) {
            addCriterion("self_promotion not between", value1, value2, "selfPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionIsNull() {
            addCriterion("sum_promotion is null");
            return (Criteria) this;
        }

        public Criteria andSumPromotionIsNotNull() {
            addCriterion("sum_promotion is not null");
            return (Criteria) this;
        }

        public Criteria andSumPromotionEqualTo(String value) {
            addCriterion("sum_promotion =", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionNotEqualTo(String value) {
            addCriterion("sum_promotion <>", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionGreaterThan(String value) {
            addCriterion("sum_promotion >", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionGreaterThanOrEqualTo(String value) {
            addCriterion("sum_promotion >=", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionLessThan(String value) {
            addCriterion("sum_promotion <", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionLessThanOrEqualTo(String value) {
            addCriterion("sum_promotion <=", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionLike(String value) {
            addCriterion("sum_promotion like", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionNotLike(String value) {
            addCriterion("sum_promotion not like", value, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionIn(List<String> values) {
            addCriterion("sum_promotion in", values, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionNotIn(List<String> values) {
            addCriterion("sum_promotion not in", values, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionBetween(String value1, String value2) {
            addCriterion("sum_promotion between", value1, value2, "sumPromotion");
            return (Criteria) this;
        }

        public Criteria andSumPromotionNotBetween(String value1, String value2) {
            addCriterion("sum_promotion not between", value1, value2, "sumPromotion");
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
    }
}