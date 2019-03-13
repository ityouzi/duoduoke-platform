package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public StoreExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreUrlIsNull() {
            addCriterion("store_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreUrlIsNotNull() {
            addCriterion("store_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUrlEqualTo(String value) {
            addCriterion("store_url =", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotEqualTo(String value) {
            addCriterion("store_url <>", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlGreaterThan(String value) {
            addCriterion("store_url >", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_url >=", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlLessThan(String value) {
            addCriterion("store_url <", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlLessThanOrEqualTo(String value) {
            addCriterion("store_url <=", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlLike(String value) {
            addCriterion("store_url like", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotLike(String value) {
            addCriterion("store_url not like", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlIn(List<String> values) {
            addCriterion("store_url in", values, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotIn(List<String> values) {
            addCriterion("store_url not in", values, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlBetween(String value1, String value2) {
            addCriterion("store_url between", value1, value2, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotBetween(String value1, String value2) {
            addCriterion("store_url not between", value1, value2, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andRecommendationIsNull() {
            addCriterion("recommendation is null");
            return (Criteria) this;
        }

        public Criteria andRecommendationIsNotNull() {
            addCriterion("recommendation is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendationEqualTo(String value) {
            addCriterion("recommendation =", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationNotEqualTo(String value) {
            addCriterion("recommendation <>", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationGreaterThan(String value) {
            addCriterion("recommendation >", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationGreaterThanOrEqualTo(String value) {
            addCriterion("recommendation >=", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationLessThan(String value) {
            addCriterion("recommendation <", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationLessThanOrEqualTo(String value) {
            addCriterion("recommendation <=", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationLike(String value) {
            addCriterion("recommendation like", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationNotLike(String value) {
            addCriterion("recommendation not like", value, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationIn(List<String> values) {
            addCriterion("recommendation in", values, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationNotIn(List<String> values) {
            addCriterion("recommendation not in", values, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationBetween(String value1, String value2) {
            addCriterion("recommendation between", value1, value2, "recommendation");
            return (Criteria) this;
        }

        public Criteria andRecommendationNotBetween(String value1, String value2) {
            addCriterion("recommendation not between", value1, value2, "recommendation");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPresentationIsNull() {
            addCriterion("presentation is null");
            return (Criteria) this;
        }

        public Criteria andPresentationIsNotNull() {
            addCriterion("presentation is not null");
            return (Criteria) this;
        }

        public Criteria andPresentationEqualTo(String value) {
            addCriterion("presentation =", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotEqualTo(String value) {
            addCriterion("presentation <>", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationGreaterThan(String value) {
            addCriterion("presentation >", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationGreaterThanOrEqualTo(String value) {
            addCriterion("presentation >=", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationLessThan(String value) {
            addCriterion("presentation <", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationLessThanOrEqualTo(String value) {
            addCriterion("presentation <=", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationLike(String value) {
            addCriterion("presentation like", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotLike(String value) {
            addCriterion("presentation not like", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationIn(List<String> values) {
            addCriterion("presentation in", values, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotIn(List<String> values) {
            addCriterion("presentation not in", values, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationBetween(String value1, String value2) {
            addCriterion("presentation between", value1, value2, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotBetween(String value1, String value2) {
            addCriterion("presentation not between", value1, value2, "presentation");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceIsNull() {
            addCriterion("is_preference is null");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceIsNotNull() {
            addCriterion("is_preference is not null");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceEqualTo(String value) {
            addCriterion("is_preference =", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceNotEqualTo(String value) {
            addCriterion("is_preference <>", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceGreaterThan(String value) {
            addCriterion("is_preference >", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceGreaterThanOrEqualTo(String value) {
            addCriterion("is_preference >=", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceLessThan(String value) {
            addCriterion("is_preference <", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceLessThanOrEqualTo(String value) {
            addCriterion("is_preference <=", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceLike(String value) {
            addCriterion("is_preference like", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceNotLike(String value) {
            addCriterion("is_preference not like", value, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceIn(List<String> values) {
            addCriterion("is_preference in", values, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceNotIn(List<String> values) {
            addCriterion("is_preference not in", values, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceBetween(String value1, String value2) {
            addCriterion("is_preference between", value1, value2, "isPreference");
            return (Criteria) this;
        }

        public Criteria andIsPreferenceNotBetween(String value1, String value2) {
            addCriterion("is_preference not between", value1, value2, "isPreference");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberIsNull() {
            addCriterion("preference_number is null");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberIsNotNull() {
            addCriterion("preference_number is not null");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberEqualTo(Integer value) {
            addCriterion("preference_number =", value, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberNotEqualTo(Integer value) {
            addCriterion("preference_number <>", value, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberGreaterThan(Integer value) {
            addCriterion("preference_number >", value, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("preference_number >=", value, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberLessThan(Integer value) {
            addCriterion("preference_number <", value, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("preference_number <=", value, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberIn(List<Integer> values) {
            addCriterion("preference_number in", values, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberNotIn(List<Integer> values) {
            addCriterion("preference_number not in", values, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberBetween(Integer value1, Integer value2) {
            addCriterion("preference_number between", value1, value2, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("preference_number not between", value1, value2, "preferenceNumber");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlIsNull() {
            addCriterion("preference_url is null");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlIsNotNull() {
            addCriterion("preference_url is not null");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlEqualTo(String value) {
            addCriterion("preference_url =", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlNotEqualTo(String value) {
            addCriterion("preference_url <>", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlGreaterThan(String value) {
            addCriterion("preference_url >", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("preference_url >=", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlLessThan(String value) {
            addCriterion("preference_url <", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlLessThanOrEqualTo(String value) {
            addCriterion("preference_url <=", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlLike(String value) {
            addCriterion("preference_url like", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlNotLike(String value) {
            addCriterion("preference_url not like", value, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlIn(List<String> values) {
            addCriterion("preference_url in", values, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlNotIn(List<String> values) {
            addCriterion("preference_url not in", values, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlBetween(String value1, String value2) {
            addCriterion("preference_url between", value1, value2, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPreferenceUrlNotBetween(String value1, String value2) {
            addCriterion("preference_url not between", value1, value2, "preferenceUrl");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andShareTitileIsNull() {
            addCriterion("share_titile is null");
            return (Criteria) this;
        }

        public Criteria andShareTitileIsNotNull() {
            addCriterion("share_titile is not null");
            return (Criteria) this;
        }

        public Criteria andShareTitileEqualTo(String value) {
            addCriterion("share_titile =", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileNotEqualTo(String value) {
            addCriterion("share_titile <>", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileGreaterThan(String value) {
            addCriterion("share_titile >", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileGreaterThanOrEqualTo(String value) {
            addCriterion("share_titile >=", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileLessThan(String value) {
            addCriterion("share_titile <", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileLessThanOrEqualTo(String value) {
            addCriterion("share_titile <=", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileLike(String value) {
            addCriterion("share_titile like", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileNotLike(String value) {
            addCriterion("share_titile not like", value, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileIn(List<String> values) {
            addCriterion("share_titile in", values, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileNotIn(List<String> values) {
            addCriterion("share_titile not in", values, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileBetween(String value1, String value2) {
            addCriterion("share_titile between", value1, value2, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareTitileNotBetween(String value1, String value2) {
            addCriterion("share_titile not between", value1, value2, "shareTitile");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNull() {
            addCriterion("share_url is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("share_url is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("share_url =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("share_url <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("share_url >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_url >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("share_url <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("share_url <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("share_url like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("share_url not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("share_url in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("share_url not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("share_url between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("share_url not between", value1, value2, "shareUrl");
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