package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderInfoExample() {
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

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlIsNull() {
            addCriterion("goods_thumbnail_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlIsNotNull() {
            addCriterion("goods_thumbnail_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlEqualTo(String value) {
            addCriterion("goods_thumbnail_url =", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotEqualTo(String value) {
            addCriterion("goods_thumbnail_url <>", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlGreaterThan(String value) {
            addCriterion("goods_thumbnail_url >", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_thumbnail_url >=", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlLessThan(String value) {
            addCriterion("goods_thumbnail_url <", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_thumbnail_url <=", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlLike(String value) {
            addCriterion("goods_thumbnail_url like", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotLike(String value) {
            addCriterion("goods_thumbnail_url not like", value, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlIn(List<String> values) {
            addCriterion("goods_thumbnail_url in", values, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotIn(List<String> values) {
            addCriterion("goods_thumbnail_url not in", values, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlBetween(String value1, String value2) {
            addCriterion("goods_thumbnail_url between", value1, value2, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsThumbnailUrlNotBetween(String value1, String value2) {
            addCriterion("goods_thumbnail_url not between", value1, value2, "goodsThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityIsNull() {
            addCriterion("goods_quantity is null");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityIsNotNull() {
            addCriterion("goods_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityEqualTo(Integer value) {
            addCriterion("goods_quantity =", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityNotEqualTo(Integer value) {
            addCriterion("goods_quantity <>", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityGreaterThan(Integer value) {
            addCriterion("goods_quantity >", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_quantity >=", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityLessThan(Integer value) {
            addCriterion("goods_quantity <", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("goods_quantity <=", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityIn(List<Integer> values) {
            addCriterion("goods_quantity in", values, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityNotIn(List<Integer> values) {
            addCriterion("goods_quantity not in", values, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityBetween(Integer value1, Integer value2) {
            addCriterion("goods_quantity between", value1, value2, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_quantity not between", value1, value2, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Integer value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Integer value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Integer value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Integer value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Integer> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Integer> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(Integer value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(Integer value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(Integer value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(Integer value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<Integer> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<Integer> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeIsNull() {
            addCriterion("order_settle_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeIsNotNull() {
            addCriterion("order_settle_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeEqualTo(Date value) {
            addCriterion("order_settle_time =", value, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeNotEqualTo(Date value) {
            addCriterion("order_settle_time <>", value, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeGreaterThan(Date value) {
            addCriterion("order_settle_time >", value, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_settle_time >=", value, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeLessThan(Date value) {
            addCriterion("order_settle_time <", value, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_settle_time <=", value, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeIn(List<Date> values) {
            addCriterion("order_settle_time in", values, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeNotIn(List<Date> values) {
            addCriterion("order_settle_time not in", values, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeBetween(Date value1, Date value2) {
            addCriterion("order_settle_time between", value1, value2, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettleTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_settle_time not between", value1, value2, "orderSettleTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeIsNull() {
            addCriterion("order_verify_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeIsNotNull() {
            addCriterion("order_verify_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeEqualTo(Date value) {
            addCriterion("order_verify_time =", value, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeNotEqualTo(Date value) {
            addCriterion("order_verify_time <>", value, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeGreaterThan(Date value) {
            addCriterion("order_verify_time >", value, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_verify_time >=", value, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeLessThan(Date value) {
            addCriterion("order_verify_time <", value, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_verify_time <=", value, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeIn(List<Date> values) {
            addCriterion("order_verify_time in", values, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeNotIn(List<Date> values) {
            addCriterion("order_verify_time not in", values, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeBetween(Date value1, Date value2) {
            addCriterion("order_verify_time between", value1, value2, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderVerifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_verify_time not between", value1, value2, "orderVerifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeIsNull() {
            addCriterion("order_receive_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeIsNotNull() {
            addCriterion("order_receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeEqualTo(Date value) {
            addCriterion("order_receive_time =", value, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeNotEqualTo(Date value) {
            addCriterion("order_receive_time <>", value, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeGreaterThan(Date value) {
            addCriterion("order_receive_time >", value, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_receive_time >=", value, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeLessThan(Date value) {
            addCriterion("order_receive_time <", value, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_receive_time <=", value, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeIn(List<Date> values) {
            addCriterion("order_receive_time in", values, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeNotIn(List<Date> values) {
            addCriterion("order_receive_time not in", values, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("order_receive_time between", value1, value2, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_receive_time not between", value1, value2, "orderReceiveTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIsNull() {
            addCriterion("order_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIsNotNull() {
            addCriterion("order_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeEqualTo(Date value) {
            addCriterion("order_pay_time =", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotEqualTo(Date value) {
            addCriterion("order_pay_time <>", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeGreaterThan(Date value) {
            addCriterion("order_pay_time >", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_pay_time >=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeLessThan(Date value) {
            addCriterion("order_pay_time <", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_pay_time <=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIn(List<Date> values) {
            addCriterion("order_pay_time in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotIn(List<Date> values) {
            addCriterion("order_pay_time not in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeBetween(Date value1, Date value2) {
            addCriterion("order_pay_time between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_pay_time not between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtIsNull() {
            addCriterion("order_pay_time_ext is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtIsNotNull() {
            addCriterion("order_pay_time_ext is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtEqualTo(Date value) {
            addCriterionForJDBCDate("order_pay_time_ext =", value, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_pay_time_ext <>", value, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtGreaterThan(Date value) {
            addCriterionForJDBCDate("order_pay_time_ext >", value, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_pay_time_ext >=", value, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtLessThan(Date value) {
            addCriterionForJDBCDate("order_pay_time_ext <", value, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_pay_time_ext <=", value, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtIn(List<Date> values) {
            addCriterionForJDBCDate("order_pay_time_ext in", values, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_pay_time_ext not in", values, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_pay_time_ext between", value1, value2, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeExtNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_pay_time_ext not between", value1, value2, "orderPayTimeExt");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIsNull() {
            addCriterion("promotion_rate is null");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIsNotNull() {
            addCriterion("promotion_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionRateEqualTo(Integer value) {
            addCriterion("promotion_rate =", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotEqualTo(Integer value) {
            addCriterion("promotion_rate <>", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateGreaterThan(Integer value) {
            addCriterion("promotion_rate >", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_rate >=", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLessThan(Integer value) {
            addCriterion("promotion_rate <", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_rate <=", value, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateIn(List<Integer> values) {
            addCriterion("promotion_rate in", values, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotIn(List<Integer> values) {
            addCriterion("promotion_rate not in", values, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateBetween(Integer value1, Integer value2) {
            addCriterion("promotion_rate between", value1, value2, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionRateNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_rate not between", value1, value2, "promotionRate");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNull() {
            addCriterion("promotion_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNotNull() {
            addCriterion("promotion_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountEqualTo(Integer value) {
            addCriterion("promotion_amount =", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotEqualTo(Integer value) {
            addCriterion("promotion_amount <>", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThan(Integer value) {
            addCriterion("promotion_amount >", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_amount >=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThan(Integer value) {
            addCriterion("promotion_amount <", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_amount <=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIn(List<Integer> values) {
            addCriterion("promotion_amount in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotIn(List<Integer> values) {
            addCriterion("promotion_amount not in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountBetween(Integer value1, Integer value2) {
            addCriterion("promotion_amount between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_amount not between", value1, value2, "promotionAmount");
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

        public Criteria andCustomParametersIsNull() {
            addCriterion("custom_parameters is null");
            return (Criteria) this;
        }

        public Criteria andCustomParametersIsNotNull() {
            addCriterion("custom_parameters is not null");
            return (Criteria) this;
        }

        public Criteria andCustomParametersEqualTo(String value) {
            addCriterion("custom_parameters =", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersNotEqualTo(String value) {
            addCriterion("custom_parameters <>", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersGreaterThan(String value) {
            addCriterion("custom_parameters >", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersGreaterThanOrEqualTo(String value) {
            addCriterion("custom_parameters >=", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersLessThan(String value) {
            addCriterion("custom_parameters <", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersLessThanOrEqualTo(String value) {
            addCriterion("custom_parameters <=", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersLike(String value) {
            addCriterion("custom_parameters like", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersNotLike(String value) {
            addCriterion("custom_parameters not like", value, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersIn(List<String> values) {
            addCriterion("custom_parameters in", values, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersNotIn(List<String> values) {
            addCriterion("custom_parameters not in", values, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersBetween(String value1, String value2) {
            addCriterion("custom_parameters between", value1, value2, "customParameters");
            return (Criteria) this;
        }

        public Criteria andCustomParametersNotBetween(String value1, String value2) {
            addCriterion("custom_parameters not between", value1, value2, "customParameters");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescIsNull() {
            addCriterion("order_status_desc is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescIsNotNull() {
            addCriterion("order_status_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescEqualTo(String value) {
            addCriterion("order_status_desc =", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotEqualTo(String value) {
            addCriterion("order_status_desc <>", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescGreaterThan(String value) {
            addCriterion("order_status_desc >", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescGreaterThanOrEqualTo(String value) {
            addCriterion("order_status_desc >=", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescLessThan(String value) {
            addCriterion("order_status_desc <", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescLessThanOrEqualTo(String value) {
            addCriterion("order_status_desc <=", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescLike(String value) {
            addCriterion("order_status_desc like", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotLike(String value) {
            addCriterion("order_status_desc not like", value, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescIn(List<String> values) {
            addCriterion("order_status_desc in", values, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotIn(List<String> values) {
            addCriterion("order_status_desc not in", values, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescBetween(String value1, String value2) {
            addCriterion("order_status_desc between", value1, value2, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusDescNotBetween(String value1, String value2) {
            addCriterion("order_status_desc not between", value1, value2, "orderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusIsNull() {
            addCriterion("user_order_status is null");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusIsNotNull() {
            addCriterion("user_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusEqualTo(String value) {
            addCriterion("user_order_status =", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusNotEqualTo(String value) {
            addCriterion("user_order_status <>", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusGreaterThan(String value) {
            addCriterion("user_order_status >", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("user_order_status >=", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusLessThan(String value) {
            addCriterion("user_order_status <", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("user_order_status <=", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusLike(String value) {
            addCriterion("user_order_status like", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusNotLike(String value) {
            addCriterion("user_order_status not like", value, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusIn(List<String> values) {
            addCriterion("user_order_status in", values, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusNotIn(List<String> values) {
            addCriterion("user_order_status not in", values, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusBetween(String value1, String value2) {
            addCriterion("user_order_status between", value1, value2, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusNotBetween(String value1, String value2) {
            addCriterion("user_order_status not between", value1, value2, "userOrderStatus");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescIsNull() {
            addCriterion("user_order_status_desc is null");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescIsNotNull() {
            addCriterion("user_order_status_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescEqualTo(String value) {
            addCriterion("user_order_status_desc =", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescNotEqualTo(String value) {
            addCriterion("user_order_status_desc <>", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescGreaterThan(String value) {
            addCriterion("user_order_status_desc >", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescGreaterThanOrEqualTo(String value) {
            addCriterion("user_order_status_desc >=", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescLessThan(String value) {
            addCriterion("user_order_status_desc <", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescLessThanOrEqualTo(String value) {
            addCriterion("user_order_status_desc <=", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescLike(String value) {
            addCriterion("user_order_status_desc like", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescNotLike(String value) {
            addCriterion("user_order_status_desc not like", value, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescIn(List<String> values) {
            addCriterion("user_order_status_desc in", values, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescNotIn(List<String> values) {
            addCriterion("user_order_status_desc not in", values, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescBetween(String value1, String value2) {
            addCriterion("user_order_status_desc between", value1, value2, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andUserOrderStatusDescNotBetween(String value1, String value2) {
            addCriterion("user_order_status_desc not between", value1, value2, "userOrderStatusDesc");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIsNull() {
            addCriterion("verify_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIsNotNull() {
            addCriterion("verify_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeEqualTo(Date value) {
            addCriterion("verify_time =", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotEqualTo(Date value) {
            addCriterion("verify_time <>", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeGreaterThan(Date value) {
            addCriterion("verify_time >", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_time >=", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLessThan(Date value) {
            addCriterion("verify_time <", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_time <=", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIn(List<Date> values) {
            addCriterion("verify_time in", values, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotIn(List<Date> values) {
            addCriterion("verify_time not in", values, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeBetween(Date value1, Date value2) {
            addCriterion("verify_time between", value1, value2, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_time not between", value1, value2, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeIsNull() {
            addCriterion("order_group_success_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeIsNotNull() {
            addCriterion("order_group_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeEqualTo(Date value) {
            addCriterion("order_group_success_time =", value, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeNotEqualTo(Date value) {
            addCriterion("order_group_success_time <>", value, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeGreaterThan(Date value) {
            addCriterion("order_group_success_time >", value, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_group_success_time >=", value, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeLessThan(Date value) {
            addCriterion("order_group_success_time <", value, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_group_success_time <=", value, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeIn(List<Date> values) {
            addCriterion("order_group_success_time in", values, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeNotIn(List<Date> values) {
            addCriterion("order_group_success_time not in", values, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeBetween(Date value1, Date value2) {
            addCriterion("order_group_success_time between", value1, value2, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_group_success_time not between", value1, value2, "orderGroupSuccessTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtIsNull() {
            addCriterion("order_modify_at is null");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtIsNotNull() {
            addCriterion("order_modify_at is not null");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtEqualTo(Date value) {
            addCriterion("order_modify_at =", value, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtNotEqualTo(Date value) {
            addCriterion("order_modify_at <>", value, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtGreaterThan(Date value) {
            addCriterion("order_modify_at >", value, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtGreaterThanOrEqualTo(Date value) {
            addCriterion("order_modify_at >=", value, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtLessThan(Date value) {
            addCriterion("order_modify_at <", value, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtLessThanOrEqualTo(Date value) {
            addCriterion("order_modify_at <=", value, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtIn(List<Date> values) {
            addCriterion("order_modify_at in", values, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtNotIn(List<Date> values) {
            addCriterion("order_modify_at not in", values, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtBetween(Date value1, Date value2) {
            addCriterion("order_modify_at between", value1, value2, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtNotBetween(Date value1, Date value2) {
            addCriterion("order_modify_at not between", value1, value2, "orderModifyAt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtIsNull() {
            addCriterion("order_modify_at_ext is null");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtIsNotNull() {
            addCriterion("order_modify_at_ext is not null");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtEqualTo(Date value) {
            addCriterionForJDBCDate("order_modify_at_ext =", value, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_modify_at_ext <>", value, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtGreaterThan(Date value) {
            addCriterionForJDBCDate("order_modify_at_ext >", value, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_modify_at_ext >=", value, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtLessThan(Date value) {
            addCriterionForJDBCDate("order_modify_at_ext <", value, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_modify_at_ext <=", value, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtIn(List<Date> values) {
            addCriterionForJDBCDate("order_modify_at_ext in", values, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_modify_at_ext not in", values, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_modify_at_ext between", value1, value2, "orderModifyAtExt");
            return (Criteria) this;
        }

        public Criteria andOrderModifyAtExtNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_modify_at_ext not between", value1, value2, "orderModifyAtExt");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdIsNull() {
            addCriterion("auth_duo_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdIsNotNull() {
            addCriterion("auth_duo_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdEqualTo(String value) {
            addCriterion("auth_duo_id =", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdNotEqualTo(String value) {
            addCriterion("auth_duo_id <>", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdGreaterThan(String value) {
            addCriterion("auth_duo_id >", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdGreaterThanOrEqualTo(String value) {
            addCriterion("auth_duo_id >=", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdLessThan(String value) {
            addCriterion("auth_duo_id <", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdLessThanOrEqualTo(String value) {
            addCriterion("auth_duo_id <=", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdLike(String value) {
            addCriterion("auth_duo_id like", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdNotLike(String value) {
            addCriterion("auth_duo_id not like", value, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdIn(List<String> values) {
            addCriterion("auth_duo_id in", values, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdNotIn(List<String> values) {
            addCriterion("auth_duo_id not in", values, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdBetween(String value1, String value2) {
            addCriterion("auth_duo_id between", value1, value2, "authDuoId");
            return (Criteria) this;
        }

        public Criteria andAuthDuoIdNotBetween(String value1, String value2) {
            addCriterion("auth_duo_id not between", value1, value2, "authDuoId");
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

        public Criteria andOrderCommissionSnapshotIsNull() {
            addCriterion("order_commission_snapshot is null");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotIsNotNull() {
            addCriterion("order_commission_snapshot is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotEqualTo(Integer value) {
            addCriterion("order_commission_snapshot =", value, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotNotEqualTo(Integer value) {
            addCriterion("order_commission_snapshot <>", value, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotGreaterThan(Integer value) {
            addCriterion("order_commission_snapshot >", value, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_commission_snapshot >=", value, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotLessThan(Integer value) {
            addCriterion("order_commission_snapshot <", value, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotLessThanOrEqualTo(Integer value) {
            addCriterion("order_commission_snapshot <=", value, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotIn(List<Integer> values) {
            addCriterion("order_commission_snapshot in", values, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotNotIn(List<Integer> values) {
            addCriterion("order_commission_snapshot not in", values, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotBetween(Integer value1, Integer value2) {
            addCriterion("order_commission_snapshot between", value1, value2, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderCommissionSnapshotNotBetween(Integer value1, Integer value2) {
            addCriterion("order_commission_snapshot not between", value1, value2, "orderCommissionSnapshot");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeIsNull() {
            addCriterion("order_user_referee is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeIsNotNull() {
            addCriterion("order_user_referee is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeEqualTo(String value) {
            addCriterion("order_user_referee =", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeNotEqualTo(String value) {
            addCriterion("order_user_referee <>", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeGreaterThan(String value) {
            addCriterion("order_user_referee >", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_referee >=", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeLessThan(String value) {
            addCriterion("order_user_referee <", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeLessThanOrEqualTo(String value) {
            addCriterion("order_user_referee <=", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeLike(String value) {
            addCriterion("order_user_referee like", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeNotLike(String value) {
            addCriterion("order_user_referee not like", value, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeIn(List<String> values) {
            addCriterion("order_user_referee in", values, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeNotIn(List<String> values) {
            addCriterion("order_user_referee not in", values, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeBetween(String value1, String value2) {
            addCriterion("order_user_referee between", value1, value2, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andOrderUserRefereeNotBetween(String value1, String value2) {
            addCriterion("order_user_referee not between", value1, value2, "orderUserReferee");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyIsNull() {
            addCriterion("help_money is null");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyIsNotNull() {
            addCriterion("help_money is not null");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyEqualTo(Integer value) {
            addCriterion("help_money =", value, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyNotEqualTo(Integer value) {
            addCriterion("help_money <>", value, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyGreaterThan(Integer value) {
            addCriterion("help_money >", value, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("help_money >=", value, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyLessThan(Integer value) {
            addCriterion("help_money <", value, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("help_money <=", value, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyIn(List<Integer> values) {
            addCriterion("help_money in", values, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyNotIn(List<Integer> values) {
            addCriterion("help_money not in", values, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyBetween(Integer value1, Integer value2) {
            addCriterion("help_money between", value1, value2, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("help_money not between", value1, value2, "helpMoney");
            return (Criteria) this;
        }

        public Criteria andHelpStatusIsNull() {
            addCriterion("help_status is null");
            return (Criteria) this;
        }

        public Criteria andHelpStatusIsNotNull() {
            addCriterion("help_status is not null");
            return (Criteria) this;
        }

        public Criteria andHelpStatusEqualTo(String value) {
            addCriterion("help_status =", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusNotEqualTo(String value) {
            addCriterion("help_status <>", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusGreaterThan(String value) {
            addCriterion("help_status >", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("help_status >=", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusLessThan(String value) {
            addCriterion("help_status <", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusLessThanOrEqualTo(String value) {
            addCriterion("help_status <=", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusLike(String value) {
            addCriterion("help_status like", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusNotLike(String value) {
            addCriterion("help_status not like", value, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusIn(List<String> values) {
            addCriterion("help_status in", values, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusNotIn(List<String> values) {
            addCriterion("help_status not in", values, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusBetween(String value1, String value2) {
            addCriterion("help_status between", value1, value2, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpStatusNotBetween(String value1, String value2) {
            addCriterion("help_status not between", value1, value2, "helpStatus");
            return (Criteria) this;
        }

        public Criteria andHelpPercentIsNull() {
            addCriterion("help_percent is null");
            return (Criteria) this;
        }

        public Criteria andHelpPercentIsNotNull() {
            addCriterion("help_percent is not null");
            return (Criteria) this;
        }

        public Criteria andHelpPercentEqualTo(Double value) {
            addCriterion("help_percent =", value, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentNotEqualTo(Double value) {
            addCriterion("help_percent <>", value, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentGreaterThan(Double value) {
            addCriterion("help_percent >", value, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentGreaterThanOrEqualTo(Double value) {
            addCriterion("help_percent >=", value, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentLessThan(Double value) {
            addCriterion("help_percent <", value, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentLessThanOrEqualTo(Double value) {
            addCriterion("help_percent <=", value, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentIn(List<Double> values) {
            addCriterion("help_percent in", values, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentNotIn(List<Double> values) {
            addCriterion("help_percent not in", values, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentBetween(Double value1, Double value2) {
            addCriterion("help_percent between", value1, value2, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andHelpPercentNotBetween(Double value1, Double value2) {
            addCriterion("help_percent not between", value1, value2, "helpPercent");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andDoublePercentIsNull() {
            addCriterion("double_percent is null");
            return (Criteria) this;
        }

        public Criteria andDoublePercentIsNotNull() {
            addCriterion("double_percent is not null");
            return (Criteria) this;
        }

        public Criteria andDoublePercentEqualTo(Double value) {
            addCriterion("double_percent =", value, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentNotEqualTo(Double value) {
            addCriterion("double_percent <>", value, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentGreaterThan(Double value) {
            addCriterion("double_percent >", value, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentGreaterThanOrEqualTo(Double value) {
            addCriterion("double_percent >=", value, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentLessThan(Double value) {
            addCriterion("double_percent <", value, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentLessThanOrEqualTo(Double value) {
            addCriterion("double_percent <=", value, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentIn(List<Double> values) {
            addCriterion("double_percent in", values, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentNotIn(List<Double> values) {
            addCriterion("double_percent not in", values, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentBetween(Double value1, Double value2) {
            addCriterion("double_percent between", value1, value2, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andDoublePercentNotBetween(Double value1, Double value2) {
            addCriterion("double_percent not between", value1, value2, "doublePercent");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountIsNull() {
            addCriterion("exemption_amount is null");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountIsNotNull() {
            addCriterion("exemption_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountEqualTo(Integer value) {
            addCriterion("exemption_amount =", value, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountNotEqualTo(Integer value) {
            addCriterion("exemption_amount <>", value, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountGreaterThan(Integer value) {
            addCriterion("exemption_amount >", value, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("exemption_amount >=", value, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountLessThan(Integer value) {
            addCriterion("exemption_amount <", value, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountLessThanOrEqualTo(Integer value) {
            addCriterion("exemption_amount <=", value, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountIn(List<Integer> values) {
            addCriterion("exemption_amount in", values, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountNotIn(List<Integer> values) {
            addCriterion("exemption_amount not in", values, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountBetween(Integer value1, Integer value2) {
            addCriterion("exemption_amount between", value1, value2, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andExemptionAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("exemption_amount not between", value1, value2, "exemptionAmount");
            return (Criteria) this;
        }

        public Criteria andPromoTypeIsNull() {
            addCriterion("promo_type is null");
            return (Criteria) this;
        }

        public Criteria andPromoTypeIsNotNull() {
            addCriterion("promo_type is not null");
            return (Criteria) this;
        }

        public Criteria andPromoTypeEqualTo(String value) {
            addCriterion("promo_type =", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeNotEqualTo(String value) {
            addCriterion("promo_type <>", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeGreaterThan(String value) {
            addCriterion("promo_type >", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("promo_type >=", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeLessThan(String value) {
            addCriterion("promo_type <", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeLessThanOrEqualTo(String value) {
            addCriterion("promo_type <=", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeLike(String value) {
            addCriterion("promo_type like", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeNotLike(String value) {
            addCriterion("promo_type not like", value, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeIn(List<String> values) {
            addCriterion("promo_type in", values, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeNotIn(List<String> values) {
            addCriterion("promo_type not in", values, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeBetween(String value1, String value2) {
            addCriterion("promo_type between", value1, value2, "promoType");
            return (Criteria) this;
        }

        public Criteria andPromoTypeNotBetween(String value1, String value2) {
            addCriterion("promo_type not between", value1, value2, "promoType");
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