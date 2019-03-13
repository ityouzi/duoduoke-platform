package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedPackageFieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RedPackageFieldExample() {
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andValidTimeIsNull() {
            addCriterion("valid_time is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("valid_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(Integer value) {
            addCriterion("valid_time =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(Integer value) {
            addCriterion("valid_time <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(Integer value) {
            addCriterion("valid_time >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid_time >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(Integer value) {
            addCriterion("valid_time <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(Integer value) {
            addCriterion("valid_time <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<Integer> values) {
            addCriterion("valid_time in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<Integer> values) {
            addCriterion("valid_time not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(Integer value1, Integer value2) {
            addCriterion("valid_time between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("valid_time not between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andOrderPidIsNull() {
            addCriterion("order_pid is null");
            return (Criteria) this;
        }

        public Criteria andOrderPidIsNotNull() {
            addCriterion("order_pid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPidEqualTo(String value) {
            addCriterion("order_pid =", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotEqualTo(String value) {
            addCriterion("order_pid <>", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidGreaterThan(String value) {
            addCriterion("order_pid >", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidGreaterThanOrEqualTo(String value) {
            addCriterion("order_pid >=", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidLessThan(String value) {
            addCriterion("order_pid <", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidLessThanOrEqualTo(String value) {
            addCriterion("order_pid <=", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidLike(String value) {
            addCriterion("order_pid like", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotLike(String value) {
            addCriterion("order_pid not like", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidIn(List<String> values) {
            addCriterion("order_pid in", values, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotIn(List<String> values) {
            addCriterion("order_pid not in", values, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidBetween(String value1, String value2) {
            addCriterion("order_pid between", value1, value2, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotBetween(String value1, String value2) {
            addCriterion("order_pid not between", value1, value2, "orderPid");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketIsNull() {
            addCriterion("base_red_packet is null");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketIsNotNull() {
            addCriterion("base_red_packet is not null");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketEqualTo(Integer value) {
            addCriterion("base_red_packet =", value, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketNotEqualTo(Integer value) {
            addCriterion("base_red_packet <>", value, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketGreaterThan(Integer value) {
            addCriterion("base_red_packet >", value, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_red_packet >=", value, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketLessThan(Integer value) {
            addCriterion("base_red_packet <", value, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketLessThanOrEqualTo(Integer value) {
            addCriterion("base_red_packet <=", value, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketIn(List<Integer> values) {
            addCriterion("base_red_packet in", values, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketNotIn(List<Integer> values) {
            addCriterion("base_red_packet not in", values, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketBetween(Integer value1, Integer value2) {
            addCriterion("base_red_packet between", value1, value2, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andBaseRedPacketNotBetween(Integer value1, Integer value2) {
            addCriterion("base_red_packet not between", value1, value2, "baseRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketIsNull() {
            addCriterion("assistance_red_packet is null");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketIsNotNull() {
            addCriterion("assistance_red_packet is not null");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketEqualTo(Integer value) {
            addCriterion("assistance_red_packet =", value, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketNotEqualTo(Integer value) {
            addCriterion("assistance_red_packet <>", value, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketGreaterThan(Integer value) {
            addCriterion("assistance_red_packet >", value, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketGreaterThanOrEqualTo(Integer value) {
            addCriterion("assistance_red_packet >=", value, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketLessThan(Integer value) {
            addCriterion("assistance_red_packet <", value, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketLessThanOrEqualTo(Integer value) {
            addCriterion("assistance_red_packet <=", value, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketIn(List<Integer> values) {
            addCriterion("assistance_red_packet in", values, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketNotIn(List<Integer> values) {
            addCriterion("assistance_red_packet not in", values, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketBetween(Integer value1, Integer value2) {
            addCriterion("assistance_red_packet between", value1, value2, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andAssistanceRedPacketNotBetween(Integer value1, Integer value2) {
            addCriterion("assistance_red_packet not between", value1, value2, "assistanceRedPacket");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNull() {
            addCriterion("share_title is null");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNotNull() {
            addCriterion("share_title is not null");
            return (Criteria) this;
        }

        public Criteria andShareTitleEqualTo(String value) {
            addCriterion("share_title =", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotEqualTo(String value) {
            addCriterion("share_title <>", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThan(String value) {
            addCriterion("share_title >", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("share_title >=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThan(String value) {
            addCriterion("share_title <", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThanOrEqualTo(String value) {
            addCriterion("share_title <=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLike(String value) {
            addCriterion("share_title like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotLike(String value) {
            addCriterion("share_title not like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleIn(List<String> values) {
            addCriterion("share_title in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotIn(List<String> values) {
            addCriterion("share_title not in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleBetween(String value1, String value2) {
            addCriterion("share_title between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotBetween(String value1, String value2) {
            addCriterion("share_title not between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNull() {
            addCriterion("share_img is null");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNotNull() {
            addCriterion("share_img is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgEqualTo(String value) {
            addCriterion("share_img =", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotEqualTo(String value) {
            addCriterion("share_img <>", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThan(String value) {
            addCriterion("share_img >", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThanOrEqualTo(String value) {
            addCriterion("share_img >=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThan(String value) {
            addCriterion("share_img <", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThanOrEqualTo(String value) {
            addCriterion("share_img <=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLike(String value) {
            addCriterion("share_img like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotLike(String value) {
            addCriterion("share_img not like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgIn(List<String> values) {
            addCriterion("share_img in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotIn(List<String> values) {
            addCriterion("share_img not in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgBetween(String value1, String value2) {
            addCriterion("share_img between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotBetween(String value1, String value2) {
            addCriterion("share_img not between", value1, value2, "shareImg");
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