package com.fulihui.redisdubbo.demo.api.request;


import java.io.Serializable;

public class GetDuoduoGoodsListRequest  implements Serializable{


    private String keyword;

    private String catId;

    private int page;

    private int pageSize;

    private int sortType;

    private int couponPrice;

    private Boolean hasCoupon;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Boolean getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(Boolean hasCoupon) {
        this.hasCoupon = hasCoupon;
    }

    public int getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(int couponPrice) {
        this.couponPrice = couponPrice;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
}
