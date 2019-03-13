package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AppConfigExample() {
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

        public Criteria andConfigValIsNull() {
            addCriterion("config_val is null");
            return (Criteria) this;
        }

        public Criteria andConfigValIsNotNull() {
            addCriterion("config_val is not null");
            return (Criteria) this;
        }

        public Criteria andConfigValEqualTo(String value) {
            addCriterion("config_val =", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValNotEqualTo(String value) {
            addCriterion("config_val <>", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValGreaterThan(String value) {
            addCriterion("config_val >", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValGreaterThanOrEqualTo(String value) {
            addCriterion("config_val >=", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValLessThan(String value) {
            addCriterion("config_val <", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValLessThanOrEqualTo(String value) {
            addCriterion("config_val <=", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValLike(String value) {
            addCriterion("config_val like", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValNotLike(String value) {
            addCriterion("config_val not like", value, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValIn(List<String> values) {
            addCriterion("config_val in", values, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValNotIn(List<String> values) {
            addCriterion("config_val not in", values, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValBetween(String value1, String value2) {
            addCriterion("config_val between", value1, value2, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigValNotBetween(String value1, String value2) {
            addCriterion("config_val not between", value1, value2, "configVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValIsNull() {
            addCriterion("config_extend_val is null");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValIsNotNull() {
            addCriterion("config_extend_val is not null");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValEqualTo(String value) {
            addCriterion("config_extend_val =", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValNotEqualTo(String value) {
            addCriterion("config_extend_val <>", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValGreaterThan(String value) {
            addCriterion("config_extend_val >", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValGreaterThanOrEqualTo(String value) {
            addCriterion("config_extend_val >=", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValLessThan(String value) {
            addCriterion("config_extend_val <", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValLessThanOrEqualTo(String value) {
            addCriterion("config_extend_val <=", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValLike(String value) {
            addCriterion("config_extend_val like", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValNotLike(String value) {
            addCriterion("config_extend_val not like", value, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValIn(List<String> values) {
            addCriterion("config_extend_val in", values, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValNotIn(List<String> values) {
            addCriterion("config_extend_val not in", values, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValBetween(String value1, String value2) {
            addCriterion("config_extend_val between", value1, value2, "configExtendVal");
            return (Criteria) this;
        }

        public Criteria andConfigExtendValNotBetween(String value1, String value2) {
            addCriterion("config_extend_val not between", value1, value2, "configExtendVal");
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