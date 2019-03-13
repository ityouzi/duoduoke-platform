package com.fulihui.redisdubbo.demo.api.request;


import com.fulihui.redisdubbo.demo.api.dto.StoreDTO;

public class AddStoreRequest extends StoreDTO {

    private String startTimeStr;

    private String endTimeStr;

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}
