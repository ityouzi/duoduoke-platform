package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionChannelsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PromotionChannelsExample() {
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

        public Criteria andChannelsNameIsNull() {
            addCriterion("channels_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelsNameIsNotNull() {
            addCriterion("channels_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsNameEqualTo(String value) {
            addCriterion("channels_name =", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameNotEqualTo(String value) {
            addCriterion("channels_name <>", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameGreaterThan(String value) {
            addCriterion("channels_name >", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameGreaterThanOrEqualTo(String value) {
            addCriterion("channels_name >=", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameLessThan(String value) {
            addCriterion("channels_name <", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameLessThanOrEqualTo(String value) {
            addCriterion("channels_name <=", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameLike(String value) {
            addCriterion("channels_name like", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameNotLike(String value) {
            addCriterion("channels_name not like", value, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameIn(List<String> values) {
            addCriterion("channels_name in", values, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameNotIn(List<String> values) {
            addCriterion("channels_name not in", values, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameBetween(String value1, String value2) {
            addCriterion("channels_name between", value1, value2, "channelsName");
            return (Criteria) this;
        }

        public Criteria andChannelsNameNotBetween(String value1, String value2) {
            addCriterion("channels_name not between", value1, value2, "channelsName");
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

        public Criteria andChannelsDescIsNull() {
            addCriterion("channels_desc is null");
            return (Criteria) this;
        }

        public Criteria andChannelsDescIsNotNull() {
            addCriterion("channels_desc is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsDescEqualTo(String value) {
            addCriterion("channels_desc =", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescNotEqualTo(String value) {
            addCriterion("channels_desc <>", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescGreaterThan(String value) {
            addCriterion("channels_desc >", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescGreaterThanOrEqualTo(String value) {
            addCriterion("channels_desc >=", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescLessThan(String value) {
            addCriterion("channels_desc <", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescLessThanOrEqualTo(String value) {
            addCriterion("channels_desc <=", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescLike(String value) {
            addCriterion("channels_desc like", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescNotLike(String value) {
            addCriterion("channels_desc not like", value, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescIn(List<String> values) {
            addCriterion("channels_desc in", values, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescNotIn(List<String> values) {
            addCriterion("channels_desc not in", values, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescBetween(String value1, String value2) {
            addCriterion("channels_desc between", value1, value2, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsDescNotBetween(String value1, String value2) {
            addCriterion("channels_desc not between", value1, value2, "channelsDesc");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionIsNull() {
            addCriterion("channels_proportion is null");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionIsNotNull() {
            addCriterion("channels_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionEqualTo(Integer value) {
            addCriterion("channels_proportion =", value, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionNotEqualTo(Integer value) {
            addCriterion("channels_proportion <>", value, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionGreaterThan(Integer value) {
            addCriterion("channels_proportion >", value, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionGreaterThanOrEqualTo(Integer value) {
            addCriterion("channels_proportion >=", value, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionLessThan(Integer value) {
            addCriterion("channels_proportion <", value, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionLessThanOrEqualTo(Integer value) {
            addCriterion("channels_proportion <=", value, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionIn(List<Integer> values) {
            addCriterion("channels_proportion in", values, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionNotIn(List<Integer> values) {
            addCriterion("channels_proportion not in", values, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionBetween(Integer value1, Integer value2) {
            addCriterion("channels_proportion between", value1, value2, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andChannelsProportionNotBetween(Integer value1, Integer value2) {
            addCriterion("channels_proportion not between", value1, value2, "channelsProportion");
            return (Criteria) this;
        }

        public Criteria andProportionLinkIsNull() {
            addCriterion("proportion_link is null");
            return (Criteria) this;
        }

        public Criteria andProportionLinkIsNotNull() {
            addCriterion("proportion_link is not null");
            return (Criteria) this;
        }

        public Criteria andProportionLinkEqualTo(String value) {
            addCriterion("proportion_link =", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkNotEqualTo(String value) {
            addCriterion("proportion_link <>", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkGreaterThan(String value) {
            addCriterion("proportion_link >", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkGreaterThanOrEqualTo(String value) {
            addCriterion("proportion_link >=", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkLessThan(String value) {
            addCriterion("proportion_link <", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkLessThanOrEqualTo(String value) {
            addCriterion("proportion_link <=", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkLike(String value) {
            addCriterion("proportion_link like", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkNotLike(String value) {
            addCriterion("proportion_link not like", value, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkIn(List<String> values) {
            addCriterion("proportion_link in", values, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkNotIn(List<String> values) {
            addCriterion("proportion_link not in", values, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkBetween(String value1, String value2) {
            addCriterion("proportion_link between", value1, value2, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andProportionLinkNotBetween(String value1, String value2) {
            addCriterion("proportion_link not between", value1, value2, "proportionLink");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeIsNull() {
            addCriterion("channels_income is null");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeIsNotNull() {
            addCriterion("channels_income is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeEqualTo(Integer value) {
            addCriterion("channels_income =", value, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeNotEqualTo(Integer value) {
            addCriterion("channels_income <>", value, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeGreaterThan(Integer value) {
            addCriterion("channels_income >", value, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("channels_income >=", value, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeLessThan(Integer value) {
            addCriterion("channels_income <", value, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("channels_income <=", value, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeIn(List<Integer> values) {
            addCriterion("channels_income in", values, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeNotIn(List<Integer> values) {
            addCriterion("channels_income not in", values, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeBetween(Integer value1, Integer value2) {
            addCriterion("channels_income between", value1, value2, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andChannelsIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("channels_income not between", value1, value2, "channelsIncome");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNull() {
            addCriterion("account_balance is null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNotNull() {
            addCriterion("account_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceEqualTo(Integer value) {
            addCriterion("account_balance =", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotEqualTo(Integer value) {
            addCriterion("account_balance <>", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThan(Integer value) {
            addCriterion("account_balance >", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_balance >=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThan(Integer value) {
            addCriterion("account_balance <", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("account_balance <=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIn(List<Integer> values) {
            addCriterion("account_balance in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotIn(List<Integer> values) {
            addCriterion("account_balance not in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceBetween(Integer value1, Integer value2) {
            addCriterion("account_balance between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("account_balance not between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusIsNull() {
            addCriterion("channels_status is null");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusIsNotNull() {
            addCriterion("channels_status is not null");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusEqualTo(String value) {
            addCriterion("channels_status =", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusNotEqualTo(String value) {
            addCriterion("channels_status <>", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusGreaterThan(String value) {
            addCriterion("channels_status >", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("channels_status >=", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusLessThan(String value) {
            addCriterion("channels_status <", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusLessThanOrEqualTo(String value) {
            addCriterion("channels_status <=", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusLike(String value) {
            addCriterion("channels_status like", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusNotLike(String value) {
            addCriterion("channels_status not like", value, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusIn(List<String> values) {
            addCriterion("channels_status in", values, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusNotIn(List<String> values) {
            addCriterion("channels_status not in", values, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusBetween(String value1, String value2) {
            addCriterion("channels_status between", value1, value2, "channelsStatus");
            return (Criteria) this;
        }

        public Criteria andChannelsStatusNotBetween(String value1, String value2) {
            addCriterion("channels_status not between", value1, value2, "channelsStatus");
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