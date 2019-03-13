package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CornerMarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CornerMarkExample() {
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

        public Criteria andMarkNameIsNull() {
            addCriterion("mark_name is null");
            return (Criteria) this;
        }

        public Criteria andMarkNameIsNotNull() {
            addCriterion("mark_name is not null");
            return (Criteria) this;
        }

        public Criteria andMarkNameEqualTo(String value) {
            addCriterion("mark_name =", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameNotEqualTo(String value) {
            addCriterion("mark_name <>", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameGreaterThan(String value) {
            addCriterion("mark_name >", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameGreaterThanOrEqualTo(String value) {
            addCriterion("mark_name >=", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameLessThan(String value) {
            addCriterion("mark_name <", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameLessThanOrEqualTo(String value) {
            addCriterion("mark_name <=", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameLike(String value) {
            addCriterion("mark_name like", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameNotLike(String value) {
            addCriterion("mark_name not like", value, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameIn(List<String> values) {
            addCriterion("mark_name in", values, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameNotIn(List<String> values) {
            addCriterion("mark_name not in", values, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameBetween(String value1, String value2) {
            addCriterion("mark_name between", value1, value2, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkNameNotBetween(String value1, String value2) {
            addCriterion("mark_name not between", value1, value2, "markName");
            return (Criteria) this;
        }

        public Criteria andMarkUrlIsNull() {
            addCriterion("mark_url is null");
            return (Criteria) this;
        }

        public Criteria andMarkUrlIsNotNull() {
            addCriterion("mark_url is not null");
            return (Criteria) this;
        }

        public Criteria andMarkUrlEqualTo(String value) {
            addCriterion("mark_url =", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlNotEqualTo(String value) {
            addCriterion("mark_url <>", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlGreaterThan(String value) {
            addCriterion("mark_url >", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mark_url >=", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlLessThan(String value) {
            addCriterion("mark_url <", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlLessThanOrEqualTo(String value) {
            addCriterion("mark_url <=", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlLike(String value) {
            addCriterion("mark_url like", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlNotLike(String value) {
            addCriterion("mark_url not like", value, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlIn(List<String> values) {
            addCriterion("mark_url in", values, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlNotIn(List<String> values) {
            addCriterion("mark_url not in", values, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlBetween(String value1, String value2) {
            addCriterion("mark_url between", value1, value2, "markUrl");
            return (Criteria) this;
        }

        public Criteria andMarkUrlNotBetween(String value1, String value2) {
            addCriterion("mark_url not between", value1, value2, "markUrl");
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