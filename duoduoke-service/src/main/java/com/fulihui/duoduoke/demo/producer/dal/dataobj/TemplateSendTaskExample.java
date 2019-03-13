package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemplateSendTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TemplateSendTaskExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsIsNull() {
            addCriterion("user_behaviors is null");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsIsNotNull() {
            addCriterion("user_behaviors is not null");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsEqualTo(String value) {
            addCriterion("user_behaviors =", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsNotEqualTo(String value) {
            addCriterion("user_behaviors <>", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsGreaterThan(String value) {
            addCriterion("user_behaviors >", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsGreaterThanOrEqualTo(String value) {
            addCriterion("user_behaviors >=", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsLessThan(String value) {
            addCriterion("user_behaviors <", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsLessThanOrEqualTo(String value) {
            addCriterion("user_behaviors <=", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsLike(String value) {
            addCriterion("user_behaviors like", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsNotLike(String value) {
            addCriterion("user_behaviors not like", value, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsIn(List<String> values) {
            addCriterion("user_behaviors in", values, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsNotIn(List<String> values) {
            addCriterion("user_behaviors not in", values, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsBetween(String value1, String value2) {
            addCriterion("user_behaviors between", value1, value2, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserBehaviorsNotBetween(String value1, String value2) {
            addCriterion("user_behaviors not between", value1, value2, "userBehaviors");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesIsNull() {
            addCriterion("trigger_times is null");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesIsNotNull() {
            addCriterion("trigger_times is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesEqualTo(String value) {
            addCriterion("trigger_times =", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesNotEqualTo(String value) {
            addCriterion("trigger_times <>", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesGreaterThan(String value) {
            addCriterion("trigger_times >", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_times >=", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesLessThan(String value) {
            addCriterion("trigger_times <", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesLessThanOrEqualTo(String value) {
            addCriterion("trigger_times <=", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesLike(String value) {
            addCriterion("trigger_times like", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesNotLike(String value) {
            addCriterion("trigger_times not like", value, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesIn(List<String> values) {
            addCriterion("trigger_times in", values, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesNotIn(List<String> values) {
            addCriterion("trigger_times not in", values, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesBetween(String value1, String value2) {
            addCriterion("trigger_times between", value1, value2, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTriggerTimesNotBetween(String value1, String value2) {
            addCriterion("trigger_times not between", value1, value2, "triggerTimes");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplatePageIsNull() {
            addCriterion("template_page is null");
            return (Criteria) this;
        }

        public Criteria andTemplatePageIsNotNull() {
            addCriterion("template_page is not null");
            return (Criteria) this;
        }

        public Criteria andTemplatePageEqualTo(String value) {
            addCriterion("template_page =", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageNotEqualTo(String value) {
            addCriterion("template_page <>", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageGreaterThan(String value) {
            addCriterion("template_page >", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageGreaterThanOrEqualTo(String value) {
            addCriterion("template_page >=", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageLessThan(String value) {
            addCriterion("template_page <", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageLessThanOrEqualTo(String value) {
            addCriterion("template_page <=", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageLike(String value) {
            addCriterion("template_page like", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageNotLike(String value) {
            addCriterion("template_page not like", value, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageIn(List<String> values) {
            addCriterion("template_page in", values, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageNotIn(List<String> values) {
            addCriterion("template_page not in", values, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageBetween(String value1, String value2) {
            addCriterion("template_page between", value1, value2, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplatePageNotBetween(String value1, String value2) {
            addCriterion("template_page not between", value1, value2, "templatePage");
            return (Criteria) this;
        }

        public Criteria andTemplateDateIsNull() {
            addCriterion("template_date is null");
            return (Criteria) this;
        }

        public Criteria andTemplateDateIsNotNull() {
            addCriterion("template_date is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateDateEqualTo(String value) {
            addCriterion("template_date =", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateNotEqualTo(String value) {
            addCriterion("template_date <>", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateGreaterThan(String value) {
            addCriterion("template_date >", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateGreaterThanOrEqualTo(String value) {
            addCriterion("template_date >=", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateLessThan(String value) {
            addCriterion("template_date <", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateLessThanOrEqualTo(String value) {
            addCriterion("template_date <=", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateLike(String value) {
            addCriterion("template_date like", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateNotLike(String value) {
            addCriterion("template_date not like", value, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateIn(List<String> values) {
            addCriterion("template_date in", values, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateNotIn(List<String> values) {
            addCriterion("template_date not in", values, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateBetween(String value1, String value2) {
            addCriterion("template_date between", value1, value2, "templateDate");
            return (Criteria) this;
        }

        public Criteria andTemplateDateNotBetween(String value1, String value2) {
            addCriterion("template_date not between", value1, value2, "templateDate");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordIsNull() {
            addCriterion("emphasis_keyword is null");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordIsNotNull() {
            addCriterion("emphasis_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordEqualTo(String value) {
            addCriterion("emphasis_keyword =", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordNotEqualTo(String value) {
            addCriterion("emphasis_keyword <>", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordGreaterThan(String value) {
            addCriterion("emphasis_keyword >", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("emphasis_keyword >=", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordLessThan(String value) {
            addCriterion("emphasis_keyword <", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordLessThanOrEqualTo(String value) {
            addCriterion("emphasis_keyword <=", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordLike(String value) {
            addCriterion("emphasis_keyword like", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordNotLike(String value) {
            addCriterion("emphasis_keyword not like", value, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordIn(List<String> values) {
            addCriterion("emphasis_keyword in", values, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordNotIn(List<String> values) {
            addCriterion("emphasis_keyword not in", values, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordBetween(String value1, String value2) {
            addCriterion("emphasis_keyword between", value1, value2, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andEmphasisKeywordNotBetween(String value1, String value2) {
            addCriterion("emphasis_keyword not between", value1, value2, "emphasisKeyword");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andDateSendCountIsNull() {
            addCriterion("date_send_count is null");
            return (Criteria) this;
        }

        public Criteria andDateSendCountIsNotNull() {
            addCriterion("date_send_count is not null");
            return (Criteria) this;
        }

        public Criteria andDateSendCountEqualTo(Integer value) {
            addCriterion("date_send_count =", value, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountNotEqualTo(Integer value) {
            addCriterion("date_send_count <>", value, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountGreaterThan(Integer value) {
            addCriterion("date_send_count >", value, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("date_send_count >=", value, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountLessThan(Integer value) {
            addCriterion("date_send_count <", value, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountLessThanOrEqualTo(Integer value) {
            addCriterion("date_send_count <=", value, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountIn(List<Integer> values) {
            addCriterion("date_send_count in", values, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountNotIn(List<Integer> values) {
            addCriterion("date_send_count not in", values, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountBetween(Integer value1, Integer value2) {
            addCriterion("date_send_count between", value1, value2, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andDateSendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("date_send_count not between", value1, value2, "dateSendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountIsNull() {
            addCriterion("send_count is null");
            return (Criteria) this;
        }

        public Criteria andSendCountIsNotNull() {
            addCriterion("send_count is not null");
            return (Criteria) this;
        }

        public Criteria andSendCountEqualTo(Integer value) {
            addCriterion("send_count =", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountNotEqualTo(Integer value) {
            addCriterion("send_count <>", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountGreaterThan(Integer value) {
            addCriterion("send_count >", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_count >=", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountLessThan(Integer value) {
            addCriterion("send_count <", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountLessThanOrEqualTo(Integer value) {
            addCriterion("send_count <=", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountIn(List<Integer> values) {
            addCriterion("send_count in", values, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountNotIn(List<Integer> values) {
            addCriterion("send_count not in", values, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountBetween(Integer value1, Integer value2) {
            addCriterion("send_count between", value1, value2, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("send_count not between", value1, value2, "sendCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountIsNull() {
            addCriterion("open_count is null");
            return (Criteria) this;
        }

        public Criteria andOpenCountIsNotNull() {
            addCriterion("open_count is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCountEqualTo(Integer value) {
            addCriterion("open_count =", value, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountNotEqualTo(Integer value) {
            addCriterion("open_count <>", value, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountGreaterThan(Integer value) {
            addCriterion("open_count >", value, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_count >=", value, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountLessThan(Integer value) {
            addCriterion("open_count <", value, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountLessThanOrEqualTo(Integer value) {
            addCriterion("open_count <=", value, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountIn(List<Integer> values) {
            addCriterion("open_count in", values, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountNotIn(List<Integer> values) {
            addCriterion("open_count not in", values, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountBetween(Integer value1, Integer value2) {
            addCriterion("open_count between", value1, value2, "openCount");
            return (Criteria) this;
        }

        public Criteria andOpenCountNotBetween(Integer value1, Integer value2) {
            addCriterion("open_count not between", value1, value2, "openCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountIsNull() {
            addCriterion("success_count is null");
            return (Criteria) this;
        }

        public Criteria andSuccessCountIsNotNull() {
            addCriterion("success_count is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessCountEqualTo(Integer value) {
            addCriterion("success_count =", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotEqualTo(Integer value) {
            addCriterion("success_count <>", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountGreaterThan(Integer value) {
            addCriterion("success_count >", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("success_count >=", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountLessThan(Integer value) {
            addCriterion("success_count <", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("success_count <=", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountIn(List<Integer> values) {
            addCriterion("success_count in", values, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotIn(List<Integer> values) {
            addCriterion("success_count not in", values, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountBetween(Integer value1, Integer value2) {
            addCriterion("success_count between", value1, value2, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("success_count not between", value1, value2, "successCount");
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