package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionChannelsLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PromotionChannelsLinkExample() {
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

        public Criteria andChannelsCodeIsNull() {
            addCriterion("channels_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeIsNotNull() {
            addCriterion("channels_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeEqualTo(String value) {
            addCriterion("channels_code =", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeNotEqualTo(String value) {
            addCriterion("channels_code <>", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeGreaterThan(String value) {
            addCriterion("channels_code >", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channels_code >=", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeLessThan(String value) {
            addCriterion("channels_code <", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeLessThanOrEqualTo(String value) {
            addCriterion("channels_code <=", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeLike(String value) {
            addCriterion("channels_code like", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeNotLike(String value) {
            addCriterion("channels_code not like", value, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeIn(List<String> values) {
            addCriterion("channels_code in", values, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeNotIn(List<String> values) {
            addCriterion("channels_code not in", values, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeBetween(String value1, String value2) {
            addCriterion("channels_code between", value1, value2, "channelsCode");
            return (Criteria) this;
        }

        public Criteria andChannelsCodeNotBetween(String value1, String value2) {
            addCriterion("channels_code not between", value1, value2, "channelsCode");
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

        public Criteria andConfigInfoIsNull() {
            addCriterion("config_info is null");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIsNotNull() {
            addCriterion("config_info is not null");
            return (Criteria) this;
        }

        public Criteria andConfigInfoEqualTo(String value) {
            addCriterion("config_info =", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotEqualTo(String value) {
            addCriterion("config_info <>", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoGreaterThan(String value) {
            addCriterion("config_info >", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoGreaterThanOrEqualTo(String value) {
            addCriterion("config_info >=", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLessThan(String value) {
            addCriterion("config_info <", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLessThanOrEqualTo(String value) {
            addCriterion("config_info <=", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLike(String value) {
            addCriterion("config_info like", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotLike(String value) {
            addCriterion("config_info not like", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIn(List<String> values) {
            addCriterion("config_info in", values, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotIn(List<String> values) {
            addCriterion("config_info not in", values, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoBetween(String value1, String value2) {
            addCriterion("config_info between", value1, value2, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotBetween(String value1, String value2) {
            addCriterion("config_info not between", value1, value2, "configInfo");
            return (Criteria) this;
        }

        public Criteria andLinkTimeIsNull() {
            addCriterion("link_time is null");
            return (Criteria) this;
        }

        public Criteria andLinkTimeIsNotNull() {
            addCriterion("link_time is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTimeEqualTo(Date value) {
            addCriterion("link_time =", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeNotEqualTo(Date value) {
            addCriterion("link_time <>", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeGreaterThan(Date value) {
            addCriterion("link_time >", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("link_time >=", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeLessThan(Date value) {
            addCriterion("link_time <", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeLessThanOrEqualTo(Date value) {
            addCriterion("link_time <=", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeIn(List<Date> values) {
            addCriterion("link_time in", values, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeNotIn(List<Date> values) {
            addCriterion("link_time not in", values, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeBetween(Date value1, Date value2) {
            addCriterion("link_time between", value1, value2, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeNotBetween(Date value1, Date value2) {
            addCriterion("link_time not between", value1, value2, "linkTime");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(String value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(String value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(String value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(String value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(String value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLike(String value) {
            addCriterion("p_id like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotLike(String value) {
            addCriterion("p_id not like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<String> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<String> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(String value1, String value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(String value1, String value2) {
            addCriterion("p_id not between", value1, value2, "pId");
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