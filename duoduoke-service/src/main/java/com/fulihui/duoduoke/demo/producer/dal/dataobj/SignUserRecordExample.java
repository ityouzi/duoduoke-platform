package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SignUserRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SignUserRecordExample() {
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

        public Criteria andSignTimeIsNull() {
            addCriterion("sign_time is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNotNull() {
            addCriterion("sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeEqualTo(Date value) {
            addCriterion("sign_time =", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotEqualTo(Date value) {
            addCriterion("sign_time <>", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThan(Date value) {
            addCriterion("sign_time >", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_time >=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThan(Date value) {
            addCriterion("sign_time <", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_time <=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIn(List<Date> values) {
            addCriterion("sign_time in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotIn(List<Date> values) {
            addCriterion("sign_time not in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeBetween(Date value1, Date value2) {
            addCriterion("sign_time between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_time not between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtIsNull() {
            addCriterion("sign_time_ext is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtIsNotNull() {
            addCriterion("sign_time_ext is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtEqualTo(Date value) {
            addCriterionForJDBCDate("sign_time_ext =", value, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtNotEqualTo(Date value) {
            addCriterionForJDBCDate("sign_time_ext <>", value, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtGreaterThan(Date value) {
            addCriterionForJDBCDate("sign_time_ext >", value, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sign_time_ext >=", value, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtLessThan(Date value) {
            addCriterionForJDBCDate("sign_time_ext <", value, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sign_time_ext <=", value, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtIn(List<Date> values) {
            addCriterionForJDBCDate("sign_time_ext in", values, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtNotIn(List<Date> values) {
            addCriterionForJDBCDate("sign_time_ext not in", values, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sign_time_ext between", value1, value2, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTimeExtNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sign_time_ext not between", value1, value2, "signTimeExt");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNull() {
            addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(String value) {
            addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(String value) {
            addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(String value) {
            addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(String value) {
            addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(String value) {
            addCriterion("sign_type <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLike(String value) {
            addCriterion("sign_type like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotLike(String value) {
            addCriterion("sign_type not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<String> values) {
            addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<String> values) {
            addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(String value1, String value2) {
            addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(String value1, String value2) {
            addCriterion("sign_type not between", value1, value2, "signType");
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

        public Criteria andSignStatusIsNull() {
            addCriterion("sign_status is null");
            return (Criteria) this;
        }

        public Criteria andSignStatusIsNotNull() {
            addCriterion("sign_status is not null");
            return (Criteria) this;
        }

        public Criteria andSignStatusEqualTo(String value) {
            addCriterion("sign_status =", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotEqualTo(String value) {
            addCriterion("sign_status <>", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusGreaterThan(String value) {
            addCriterion("sign_status >", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sign_status >=", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLessThan(String value) {
            addCriterion("sign_status <", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLessThanOrEqualTo(String value) {
            addCriterion("sign_status <=", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLike(String value) {
            addCriterion("sign_status like", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotLike(String value) {
            addCriterion("sign_status not like", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusIn(List<String> values) {
            addCriterion("sign_status in", values, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotIn(List<String> values) {
            addCriterion("sign_status not in", values, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusBetween(String value1, String value2) {
            addCriterion("sign_status between", value1, value2, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotBetween(String value1, String value2) {
            addCriterion("sign_status not between", value1, value2, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdIsNull() {
            addCriterion("sign_help_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdIsNotNull() {
            addCriterion("sign_help_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdEqualTo(String value) {
            addCriterion("sign_help_user_id =", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdNotEqualTo(String value) {
            addCriterion("sign_help_user_id <>", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdGreaterThan(String value) {
            addCriterion("sign_help_user_id >", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sign_help_user_id >=", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdLessThan(String value) {
            addCriterion("sign_help_user_id <", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdLessThanOrEqualTo(String value) {
            addCriterion("sign_help_user_id <=", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdLike(String value) {
            addCriterion("sign_help_user_id like", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdNotLike(String value) {
            addCriterion("sign_help_user_id not like", value, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdIn(List<String> values) {
            addCriterion("sign_help_user_id in", values, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdNotIn(List<String> values) {
            addCriterion("sign_help_user_id not in", values, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdBetween(String value1, String value2) {
            addCriterion("sign_help_user_id between", value1, value2, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignHelpUserIdNotBetween(String value1, String value2) {
            addCriterion("sign_help_user_id not between", value1, value2, "signHelpUserId");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountIsNull() {
            addCriterion("sign_flop_count is null");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountIsNotNull() {
            addCriterion("sign_flop_count is not null");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountEqualTo(Integer value) {
            addCriterion("sign_flop_count =", value, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountNotEqualTo(Integer value) {
            addCriterion("sign_flop_count <>", value, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountGreaterThan(Integer value) {
            addCriterion("sign_flop_count >", value, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_flop_count >=", value, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountLessThan(Integer value) {
            addCriterion("sign_flop_count <", value, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountLessThanOrEqualTo(Integer value) {
            addCriterion("sign_flop_count <=", value, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountIn(List<Integer> values) {
            addCriterion("sign_flop_count in", values, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountNotIn(List<Integer> values) {
            addCriterion("sign_flop_count not in", values, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountBetween(Integer value1, Integer value2) {
            addCriterion("sign_flop_count between", value1, value2, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignFlopCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_flop_count not between", value1, value2, "signFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountIsNull() {
            addCriterion("share_flop_count is null");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountIsNotNull() {
            addCriterion("share_flop_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountEqualTo(Integer value) {
            addCriterion("share_flop_count =", value, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountNotEqualTo(Integer value) {
            addCriterion("share_flop_count <>", value, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountGreaterThan(Integer value) {
            addCriterion("share_flop_count >", value, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_flop_count >=", value, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountLessThan(Integer value) {
            addCriterion("share_flop_count <", value, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountLessThanOrEqualTo(Integer value) {
            addCriterion("share_flop_count <=", value, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountIn(List<Integer> values) {
            addCriterion("share_flop_count in", values, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountNotIn(List<Integer> values) {
            addCriterion("share_flop_count not in", values, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountBetween(Integer value1, Integer value2) {
            addCriterion("share_flop_count between", value1, value2, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andShareFlopCountNotBetween(Integer value1, Integer value2) {
            addCriterion("share_flop_count not between", value1, value2, "shareFlopCount");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeIsNull() {
            addCriterion("sign_in_prize is null");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeIsNotNull() {
            addCriterion("sign_in_prize is not null");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeEqualTo(String value) {
            addCriterion("sign_in_prize =", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeNotEqualTo(String value) {
            addCriterion("sign_in_prize <>", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeGreaterThan(String value) {
            addCriterion("sign_in_prize >", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_prize >=", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeLessThan(String value) {
            addCriterion("sign_in_prize <", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeLessThanOrEqualTo(String value) {
            addCriterion("sign_in_prize <=", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeLike(String value) {
            addCriterion("sign_in_prize like", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeNotLike(String value) {
            addCriterion("sign_in_prize not like", value, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeIn(List<String> values) {
            addCriterion("sign_in_prize in", values, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeNotIn(List<String> values) {
            addCriterion("sign_in_prize not in", values, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeBetween(String value1, String value2) {
            addCriterion("sign_in_prize between", value1, value2, "signInPrize");
            return (Criteria) this;
        }

        public Criteria andSignInPrizeNotBetween(String value1, String value2) {
            addCriterion("sign_in_prize not between", value1, value2, "signInPrize");
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