package com.duopei.springmvc.model;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public class ResponsePageUtil<T> {
    private Integer draw;

    public Integer getsEcho() {
        return sEcho;
    }

    public void setsEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }

    private Integer sEcho;
    private Integer recordsTotal; //即没有过滤的记录数（数据库里总共记录数） 总条数
    private Integer recordsFiltered; //过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数） 总条数-过滤
    private List<T> data;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
