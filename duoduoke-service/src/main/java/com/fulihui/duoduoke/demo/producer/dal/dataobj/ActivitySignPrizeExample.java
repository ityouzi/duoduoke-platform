package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitySignPrizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ActivitySignPrizeExample() {
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

        public Criteria andPrizeTypeIsNull() {
            addCriterion("prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(Integer value) {
            addCriterion("prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(Integer value) {
            addCriterion("prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(Integer value) {
            addCriterion("prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(Integer value) {
            addCriterion("prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<Integer> values) {
            addCriterion("prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<Integer> values) {
            addCriterion("prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(Integer value1, Integer value2) {
            addCriterion("prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(Integer value1, Integer value2) {
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