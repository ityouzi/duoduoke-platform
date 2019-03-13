package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SignAwardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SignAwardExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andActivityTypeIsNull() {
            addCriterion("activity_type is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNotNull() {
            addCriterion("activity_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeEqualTo(String value) {
            addCriterion("activity_type =", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotEqualTo(String value) {
            addCriterion("activity_type <>", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThan(String value) {
            addCriterion("activity_type >", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("activity_type >=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThan(String value) {
            addCriterion("activity_type <", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThanOrEqualTo(String value) {
            addCriterion("activity_type <=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLike(String value) {
            addCriterion("activity_type like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotLike(String value) {
            addCriterion("activity_type not like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIn(List<String> values) {
            addCriterion("activity_type in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotIn(List<String> values) {
            addCriterion("activity_type not in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeBetween(String value1, String value2) {
            addCriterion("activity_type between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotBetween(String value1, String value2) {
            addCriterion("activity_type not between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andSignCountIsNull() {
            addCriterion("sign_count is null");
            return (Criteria) this;
        }

        public Criteria andSignCountIsNotNull() {
            addCriterion("sign_count is not null");
            return (Criteria) this;
        }

        public Criteria andSignCountEqualTo(Integer value) {
            addCriterion("sign_count =", value, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountNotEqualTo(Integer value) {
            addCriterion("sign_count <>", value, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountGreaterThan(Integer value) {
            addCriterion("sign_count >", value, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_count >=", value, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountLessThan(Integer value) {
            addCriterion("sign_count <", value, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountLessThanOrEqualTo(Integer value) {
            addCriterion("sign_count <=", value, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountIn(List<Integer> values) {
            addCriterion("sign_count in", values, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountNotIn(List<Integer> values) {
            addCriterion("sign_count not in", values, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountBetween(Integer value1, Integer value2) {
            addCriterion("sign_count between", value1, value2, "signCount");
            return (Criteria) this;
        }

        public Criteria andSignCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_count not between", value1, value2, "signCount");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusIsNull() {
            addCriterion("prize_status is null");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusIsNotNull() {
            addCriterion("prize_status is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusEqualTo(String value) {
            addCriterion("prize_status =", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusNotEqualTo(String value) {
            addCriterion("prize_status <>", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusGreaterThan(String value) {
            addCriterion("prize_status >", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("prize_status >=", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusLessThan(String value) {
            addCriterion("prize_status <", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusLessThanOrEqualTo(String value) {
            addCriterion("prize_status <=", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusLike(String value) {
            addCriterion("prize_status like", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusNotLike(String value) {
            addCriterion("prize_status not like", value, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusIn(List<String> values) {
            addCriterion("prize_status in", values, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusNotIn(List<String> values) {
            addCriterion("prize_status not in", values, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusBetween(String value1, String value2) {
            addCriterion("prize_status between", value1, value2, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeStatusNotBetween(String value1, String value2) {
            addCriterion("prize_status not between", value1, value2, "prizeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNull() {
            addCriterion("prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(String value) {
            addCriterion("prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(String value) {
            addCriterion("prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(String value) {
            addCriterion("prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(String value) {
            addCriterion("prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(String value) {
            addCriterion("prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLike(String value) {
            addCriterion("prize_type like", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotLike(String value) {
            addCriterion("prize_type not like", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<String> values) {
            addCriterion("prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<String> values) {
            addCriterion("prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(String value1, String value2) {
            addCriterion("prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(String value1, String value2) {
            addCriterion("prize_type not between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizePercentIsNull() {
            addCriterion("prize_percent is null");
            return (Criteria) this;
        }

        public Criteria andPrizePercentIsNotNull() {
            addCriterion("prize_percent is not null");
            return (Criteria) this;
        }

        public Criteria andPrizePercentEqualTo(Integer value) {
            addCriterion("prize_percent =", value, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentNotEqualTo(Integer value) {
            addCriterion("prize_percent <>", value, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentGreaterThan(Integer value) {
            addCriterion("prize_percent >", value, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_percent >=", value, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentLessThan(Integer value) {
            addCriterion("prize_percent <", value, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentLessThanOrEqualTo(Integer value) {
            addCriterion("prize_percent <=", value, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentIn(List<Integer> values) {
            addCriterion("prize_percent in", values, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentNotIn(List<Integer> values) {
            addCriterion("prize_percent not in", values, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentBetween(Integer value1, Integer value2) {
            addCriterion("prize_percent between", value1, value2, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizePercentNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_percent not between", value1, value2, "prizePercent");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyIsNull() {
            addCriterion("prize_money is null");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyIsNotNull() {
            addCriterion("prize_money is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyEqualTo(Integer value) {
            addCriterion("prize_money =", value, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyNotEqualTo(Integer value) {
            addCriterion("prize_money <>", value, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyGreaterThan(Integer value) {
            addCriterion("prize_money >", value, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_money >=", value, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyLessThan(Integer value) {
            addCriterion("prize_money <", value, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("prize_money <=", value, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyIn(List<Integer> values) {
            addCriterion("prize_money in", values, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyNotIn(List<Integer> values) {
            addCriterion("prize_money not in", values, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyBetween(Integer value1, Integer value2) {
            addCriterion("prize_money between", value1, value2, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andPrizeMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_money not between", value1, value2, "prizeMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyIsNull() {
            addCriterion("over_order_money is null");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyIsNotNull() {
            addCriterion("over_order_money is not null");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyEqualTo(Integer value) {
            addCriterion("over_order_money =", value, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyNotEqualTo(Integer value) {
            addCriterion("over_order_money <>", value, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyGreaterThan(Integer value) {
            addCriterion("over_order_money >", value, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("over_order_money >=", value, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyLessThan(Integer value) {
            addCriterion("over_order_money <", value, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("over_order_money <=", value, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyIn(List<Integer> values) {
            addCriterion("over_order_money in", values, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyNotIn(List<Integer> values) {
            addCriterion("over_order_money not in", values, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyBetween(Integer value1, Integer value2) {
            addCriterion("over_order_money between", value1, value2, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andOverOrderMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("over_order_money not between", value1, value2, "overOrderMoney");
            return (Criteria) this;
        }

        public Criteria andUsefulDayIsNull() {
            addCriterion("useful_day is null");
            return (Criteria) this;
        }

        public Criteria andUsefulDayIsNotNull() {
            addCriterion("useful_day is not null");
            return (Criteria) this;
        }

        public Criteria andUsefulDayEqualTo(Integer value) {
            addCriterion("useful_day =", value, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayNotEqualTo(Integer value) {
            addCriterion("useful_day <>", value, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayGreaterThan(Integer value) {
            addCriterion("useful_day >", value, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("useful_day >=", value, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayLessThan(Integer value) {
            addCriterion("useful_day <", value, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayLessThanOrEqualTo(Integer value) {
            addCriterion("useful_day <=", value, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayIn(List<Integer> values) {
            addCriterion("useful_day in", values, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayNotIn(List<Integer> values) {
            addCriterion("useful_day not in", values, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayBetween(Integer value1, Integer value2) {
            addCriterion("useful_day between", value1, value2, "usefulDay");
            return (Criteria) this;
        }

        public Criteria andUsefulDayNotBetween(Integer value1, Integer value2) {
            addCriterion("useful_day not between", value1, value2, "usefulDay");
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

        public Criteria andCycleTimeIsNull() {
            addCriterion("cycle_time is null");
            return (Criteria) this;
        }

        public Criteria andCycleTimeIsNotNull() {
            addCriterion("cycle_time is not null");
            return (Criteria) this;
        }

        public Criteria andCycleTimeEqualTo(Date value) {
            addCriterionForJDBCDate("cycle_time =", value, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("cycle_time <>", value, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("cycle_time >", value, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cycle_time >=", value, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeLessThan(Date value) {
            addCriterionForJDBCDate("cycle_time <", value, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cycle_time <=", value, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeIn(List<Date> values) {
            addCriterionForJDBCDate("cycle_time in", values, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("cycle_time not in", values, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cycle_time between", value1, value2, "cycleTime");
            return (Criteria) this;
        }

        public Criteria andCycleTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cycle_time not between", value1, value2, "cycleTime");
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

        public Criteria andBindOrderStatusIsNull() {
            addCriterion("bind_order_status is null");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusIsNotNull() {
            addCriterion("bind_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusEqualTo(String value) {
            addCriterion("bind_order_status =", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusNotEqualTo(String value) {
            addCriterion("bind_order_status <>", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusGreaterThan(String value) {
            addCriterion("bind_order_status >", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bind_order_status >=", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusLessThan(String value) {
            addCriterion("bind_order_status <", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("bind_order_status <=", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusLike(String value) {
            addCriterion("bind_order_status like", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusNotLike(String value) {
            addCriterion("bind_order_status not like", value, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusIn(List<String> values) {
            addCriterion("bind_order_status in", values, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusNotIn(List<String> values) {
            addCriterion("bind_order_status not in", values, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusBetween(String value1, String value2) {
            addCriterion("bind_order_status between", value1, value2, "bindOrderStatus");
            return (Criteria) this;
        }

        public Criteria andBindOrderStatusNotBetween(String value1, String value2) {
            addCriterion("bind_order_status not between", value1, value2, "bindOrderStatus");
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