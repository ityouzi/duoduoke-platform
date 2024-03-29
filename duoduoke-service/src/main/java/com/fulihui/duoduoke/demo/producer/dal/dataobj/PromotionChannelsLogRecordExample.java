package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionChannelsLogRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PromotionChannelsLogRecordExample() {
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

        public Criteria andPromotionChannelsIdIsNull() {
            addCriterion("promotion_channels_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdIsNotNull() {
            addCriterion("promotion_channels_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdEqualTo(Integer value) {
            addCriterion("promotion_channels_id =", value, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdNotEqualTo(Integer value) {
            addCriterion("promotion_channels_id <>", value, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdGreaterThan(Integer value) {
            addCriterion("promotion_channels_id >", value, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_channels_id >=", value, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdLessThan(Integer value) {
            addCriterion("promotion_channels_id <", value, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_channels_id <=", value, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdIn(List<Integer> values) {
            addCriterion("promotion_channels_id in", values, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdNotIn(List<Integer> values) {
            addCriterion("promotion_channels_id not in", values, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdBetween(Integer value1, Integer value2) {
            addCriterion("promotion_channels_id between", value1, value2, "promotionChannelsId");
            return (Criteria) this;
        }

        public Criteria andPromotionChannelsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_channels_id not between", value1, value2, "promotionChannelsId");
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

        public Criteria andChannelsProportionBeforeIsNull() {
            addCriterion("channels_proportion_before is null");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeIsNotNull() {
            addCriterion("channels_proportion_before is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeEqualTo(Double value) {
            addCriterion("channels_proportion_before =", value, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeNotEqualTo(Double value) {
            addCriterion("channels_proportion_before <>", value, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeGreaterThan(Double value) {
            addCriterion("channels_proportion_before >", value, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeGreaterThanOrEqualTo(Double value) {
            addCriterion("channels_proportion_before >=", value, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeLessThan(Double value) {
            addCriterion("channels_proportion_before <", value, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeLessThanOrEqualTo(Double value) {
            addCriterion("channels_proportion_before <=", value, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeIn(List<Double> values) {
            addCriterion("channels_proportion_before in", values, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeNotIn(List<Double> values) {
            addCriterion("channels_proportion_before not in", values, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeBetween(Double value1, Double value2) {
            addCriterion("channels_proportion_before between", value1, value2, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBeforeNotBetween(Double value1, Double value2) {
            addCriterion("channels_proportion_before not between", value1, value2, "channelsProportionBefore");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterIsNull() {
            addCriterion("channels_proportion_after is null");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterIsNotNull() {
            addCriterion("channels_proportion_after is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterEqualTo(Double value) {
            addCriterion("channels_proportion_after =", value, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterNotEqualTo(Double value) {
            addCriterion("channels_proportion_after <>", value, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterGreaterThan(Double value) {
            addCriterion("channels_proportion_after >", value, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterGreaterThanOrEqualTo(Double value) {
            addCriterion("channels_proportion_after >=", value, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterLessThan(Double value) {
            addCriterion("channels_proportion_after <", value, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterLessThanOrEqualTo(Double value) {
            addCriterion("channels_proportion_after <=", value, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterIn(List<Double> values) {
            addCriterion("channels_proportion_after in", values, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterNotIn(List<Double> values) {
            addCriterion("channels_proportion_after not in", values, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterBetween(Double value1, Double value2) {
            addCriterion("channels_proportion_after between", value1, value2, "channelsProportionAfter");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionAfterNotBetween(Double value1, Double value2) {
            addCriterion("channels_proportion_after not between", value1, value2, "channelsProportionAfter");
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