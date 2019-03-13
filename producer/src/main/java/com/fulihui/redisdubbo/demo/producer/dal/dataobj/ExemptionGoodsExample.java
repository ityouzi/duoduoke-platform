package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExemptionGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ExemptionGoodsExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
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

        public Criteria andExemptionGoodsNameIsNull() {
            addCriterion("exemption_goods_name is null");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameIsNotNull() {
            addCriterion("exemption_goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameEqualTo(String value) {
            addCriterion("exemption_goods_name =", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameNotEqualTo(String value) {
            addCriterion("exemption_goods_name <>", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameGreaterThan(String value) {
            addCriterion("exemption_goods_name >", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("exemption_goods_name >=", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameLessThan(String value) {
            addCriterion("exemption_goods_name <", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("exemption_goods_name <=", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameLike(String value) {
            addCriterion("exemption_goods_name like", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameNotLike(String value) {
            addCriterion("exemption_goods_name not like", value, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameIn(List<String> values) {
            addCriterion("exemption_goods_name in", values, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameNotIn(List<String> values) {
            addCriterion("exemption_goods_name not in", values, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameBetween(String value1, String value2) {
            addCriterion("exemption_goods_name between", value1, value2, "exemptionGoodsName");
            return (Criteria) this;
        }

        public Criteria andExemptionGoodsNameNotBetween(String value1, String value2) {
            addCriterion("exemption_goods_name not between", value1, value2, "exemptionGoodsName");
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

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Integer value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Integer value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Integer value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Integer value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Integer> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Integer> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountIsNull() {
            addCriterion("back_amount is null");
            return (Criteria) this;
        }

        public Criteria andBackAmountIsNotNull() {
            addCriterion("back_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBackAmountEqualTo(Integer value) {
            addCriterion("back_amount =", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountNotEqualTo(Integer value) {
            addCriterion("back_amount <>", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountGreaterThan(Integer value) {
            addCriterion("back_amount >", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("back_amount >=", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountLessThan(Integer value) {
            addCriterion("back_amount <", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountLessThanOrEqualTo(Integer value) {
            addCriterion("back_amount <=", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountIn(List<Integer> values) {
            addCriterion("back_amount in", values, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountNotIn(List<Integer> values) {
            addCriterion("back_amount not in", values, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountBetween(Integer value1, Integer value2) {
            addCriterion("back_amount between", value1, value2, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("back_amount not between", value1, value2, "backAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionNumIsNull() {
            addCriterion("exemption_num is null");
            return (Criteria) this;
        }

        public Criteria andExemptionNumIsNotNull() {
            addCriterion("exemption_num is not null");
            return (Criteria) this;
        }

        public Criteria andExemptionNumEqualTo(Integer value) {
            addCriterion("exemption_num =", value, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumNotEqualTo(Integer value) {
            addCriterion("exemption_num <>", value, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumGreaterThan(Integer value) {
            addCriterion("exemption_num >", value, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("exemption_num >=", value, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumLessThan(Integer value) {
            addCriterion("exemption_num <", value, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumLessThanOrEqualTo(Integer value) {
            addCriterion("exemption_num <=", value, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumIn(List<Integer> values) {
            addCriterion("exemption_num in", values, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumNotIn(List<Integer> values) {
            addCriterion("exemption_num not in", values, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumBetween(Integer value1, Integer value2) {
            addCriterion("exemption_num between", value1, value2, "exemptionNum");
            return (Criteria) this;
        }

        public Criteria andExemptionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("exemption_num not between", value1, value2, "exemptionNum");
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

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andSurplusNumIsNull() {
            addCriterion("surplus_num is null");
            return (Criteria) this;
        }

        public Criteria andSurplusNumIsNotNull() {
            addCriterion("surplus_num is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusNumEqualTo(Integer value) {
            addCriterion("surplus_num =", value, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumNotEqualTo(Integer value) {
            addCriterion("surplus_num <>", value, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumGreaterThan(Integer value) {
            addCriterion("surplus_num >", value, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplus_num >=", value, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumLessThan(Integer value) {
            addCriterion("surplus_num <", value, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumLessThanOrEqualTo(Integer value) {
            addCriterion("surplus_num <=", value, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumIn(List<Integer> values) {
            addCriterion("surplus_num in", values, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumNotIn(List<Integer> values) {
            addCriterion("surplus_num not in", values, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumBetween(Integer value1, Integer value2) {
            addCriterion("surplus_num between", value1, value2, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andSurplusNumNotBetween(Integer value1, Integer value2) {
            addCriterion("surplus_num not between", value1, value2, "surplusNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumIsNull() {
            addCriterion("receive_num is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNumIsNotNull() {
            addCriterion("receive_num is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNumEqualTo(Integer value) {
            addCriterion("receive_num =", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotEqualTo(Integer value) {
            addCriterion("receive_num <>", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumGreaterThan(Integer value) {
            addCriterion("receive_num >", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_num >=", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumLessThan(Integer value) {
            addCriterion("receive_num <", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumLessThanOrEqualTo(Integer value) {
            addCriterion("receive_num <=", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumIn(List<Integer> values) {
            addCriterion("receive_num in", values, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotIn(List<Integer> values) {
            addCriterion("receive_num not in", values, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumBetween(Integer value1, Integer value2) {
            addCriterion("receive_num between", value1, value2, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_num not between", value1, value2, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumIsNull() {
            addCriterion("order_quantity_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumIsNotNull() {
            addCriterion("order_quantity_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumEqualTo(Integer value) {
            addCriterion("order_quantity_num =", value, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumNotEqualTo(Integer value) {
            addCriterion("order_quantity_num <>", value, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumGreaterThan(Integer value) {
            addCriterion("order_quantity_num >", value, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_quantity_num >=", value, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumLessThan(Integer value) {
            addCriterion("order_quantity_num <", value, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_quantity_num <=", value, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumIn(List<Integer> values) {
            addCriterion("order_quantity_num in", values, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumNotIn(List<Integer> values) {
            addCriterion("order_quantity_num not in", values, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumBetween(Integer value1, Integer value2) {
            addCriterion("order_quantity_num between", value1, value2, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_quantity_num not between", value1, value2, "orderQuantityNum");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIsNull() {
            addCriterion("gmt_receive is null");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIsNotNull() {
            addCriterion("gmt_receive is not null");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveEqualTo(Date value) {
            addCriterion("gmt_receive =", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotEqualTo(Date value) {
            addCriterion("gmt_receive <>", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveGreaterThan(Date value) {
            addCriterion("gmt_receive >", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_receive >=", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveLessThan(Date value) {
            addCriterion("gmt_receive <", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveLessThanOrEqualTo(Date value) {
            addCriterion("gmt_receive <=", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIn(List<Date> values) {
            addCriterion("gmt_receive in", values, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotIn(List<Date> values) {
            addCriterion("gmt_receive not in", values, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveBetween(Date value1, Date value2) {
            addCriterion("gmt_receive between", value1, value2, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotBetween(Date value1, Date value2) {
            addCriterion("gmt_receive not between", value1, value2, "gmtReceive");
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