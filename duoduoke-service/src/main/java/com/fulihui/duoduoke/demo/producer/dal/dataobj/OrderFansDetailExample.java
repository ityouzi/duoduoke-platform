package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFansDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderFansDetailExample() {
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

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPUserIdIsNull() {
            addCriterion("p_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPUserIdIsNotNull() {
            addCriterion("p_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPUserIdEqualTo(String value) {
            addCriterion("p_user_id =", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotEqualTo(String value) {
            addCriterion("p_user_id <>", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdGreaterThan(String value) {
            addCriterion("p_user_id >", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_user_id >=", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdLessThan(String value) {
            addCriterion("p_user_id <", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdLessThanOrEqualTo(String value) {
            addCriterion("p_user_id <=", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdLike(String value) {
            addCriterion("p_user_id like", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotLike(String value) {
            addCriterion("p_user_id not like", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdIn(List<String> values) {
            addCriterion("p_user_id in", values, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotIn(List<String> values) {
            addCriterion("p_user_id not in", values, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdBetween(String value1, String value2) {
            addCriterion("p_user_id between", value1, value2, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotBetween(String value1, String value2) {
            addCriterion("p_user_id not between", value1, value2, "pUserId");
            return (Criteria) this;
        }

        public Criteria andFansAmountIsNull() {
            addCriterion("fans_amount is null");
            return (Criteria) this;
        }

        public Criteria andFansAmountIsNotNull() {
            addCriterion("fans_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFansAmountEqualTo(Integer value) {
            addCriterion("fans_amount =", value, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountNotEqualTo(Integer value) {
            addCriterion("fans_amount <>", value, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountGreaterThan(Integer value) {
            addCriterion("fans_amount >", value, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans_amount >=", value, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountLessThan(Integer value) {
            addCriterion("fans_amount <", value, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountLessThanOrEqualTo(Integer value) {
            addCriterion("fans_amount <=", value, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountIn(List<Integer> values) {
            addCriterion("fans_amount in", values, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountNotIn(List<Integer> values) {
            addCriterion("fans_amount not in", values, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountBetween(Integer value1, Integer value2) {
            addCriterion("fans_amount between", value1, value2, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andFansAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("fans_amount not between", value1, value2, "fansAmount");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
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

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescIsNull() {
            addCriterion("order_status_desc is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescIsNotNull() {
            addCriterion("order_status_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescEqualTo(String value) {
            addCriterion("order_status_desc =", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotEqualTo(String value) {
            addCriterion("order_status_desc <>", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescGreaterThan(String value) {
            addCriterion("order_status_desc >", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescGreaterThanOrEqualTo(String value) {
            addCriterion("order_status_desc >=", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescLessThan(String value) {
            addCriterion("order_status_desc <", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescLessThanOrEqualTo(String value) {
            addCriterion("order_status_desc <=", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescLike(String value) {
            addCriterion("order_status_desc like", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotLike(String value) {
            addCriterion("order_status_desc not like", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescIn(List<String> values) {
            addCriterion("order_status_desc in", values, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotIn(List<String> values) {
            addCriterion("order_status_desc not in", values, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescBetween(String value1, String value2) {
            addCriterion("order_status_desc between", value1, value2, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotBetween(String value1, String value2) {
            addCriterion("order_status_desc not between", value1, value2, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andFansTypeIsNull() {
            addCriterion("fans_type is null");
            return (Criteria) this;
        }

        public Criteria andFansTypeIsNotNull() {
            addCriterion("fans_type is not null");
            return (Criteria) this;
        }

        public Criteria andFansTypeEqualTo(String value) {
            addCriterion("fans_type =", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotEqualTo(String value) {
            addCriterion("fans_type <>", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeGreaterThan(String value) {
            addCriterion("fans_type >", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fans_type >=", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeLessThan(String value) {
            addCriterion("fans_type <", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeLessThanOrEqualTo(String value) {
            addCriterion("fans_type <=", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeLike(String value) {
            addCriterion("fans_type like", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotLike(String value) {
            addCriterion("fans_type not like", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeIn(List<String> values) {
            addCriterion("fans_type in", values, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotIn(List<String> values) {
            addCriterion("fans_type not in", values, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeBetween(String value1, String value2) {
            addCriterion("fans_type between", value1, value2, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotBetween(String value1, String value2) {
            addCriterion("fans_type not between", value1, value2, "fansType");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotIsNull() {
            addCriterion("proportion_snapshot is null");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotIsNotNull() {
            addCriterion("proportion_snapshot is not null");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotEqualTo(Integer value) {
            addCriterion("proportion_snapshot =", value, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotNotEqualTo(Integer value) {
            addCriterion("proportion_snapshot <>", value, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotGreaterThan(Integer value) {
            addCriterion("proportion_snapshot >", value, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotGreaterThanOrEqualTo(Integer value) {
            addCriterion("proportion_snapshot >=", value, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotLessThan(Integer value) {
            addCriterion("proportion_snapshot <", value, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotLessThanOrEqualTo(Integer value) {
            addCriterion("proportion_snapshot <=", value, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotIn(List<Integer> values) {
            addCriterion("proportion_snapshot in", values, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotNotIn(List<Integer> values) {
            addCriterion("proportion_snapshot not in", values, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotBetween(Integer value1, Integer value2) {
            addCriterion("proportion_snapshot between", value1, value2, "proportionSnapshot");
            return (Criteria) this;
        }

        public Criteria andProportionSnapshotNotBetween(Integer value1, Integer value2) {
            addCriterion("proportion_snapshot not between", value1, value2, "proportionSnapshot");
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