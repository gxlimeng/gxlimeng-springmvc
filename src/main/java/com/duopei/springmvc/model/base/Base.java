package com.duopei.springmvc.model.base;

import com.duopei.springmvc.model.RequestPageUtil;

import java.sql.Date;

/**
 * Created by Administrator on 2017/1/24.
 */
public class Base extends RequestPageUtil {

    private String insertId;

    private Date insertDate;

    private String modifyId;

    private Date modifyDate;

    private Long lastVersion;

    private String colStatus = "NEW"; // 当前行状态

    public String getColStatus() {
        return colStatus;
    }

    @Override
    public String toString() {
        return "Base{" +
                "insertId='" + insertId + '\'' +
                ", insertDate=" + insertDate +
                ", modifyId='" + modifyId + '\'' +
                ", modifyDate=" + modifyDate +
                ", lastVersion=" + lastVersion +
                ", colStatus='" + colStatus + '\'' +
                '}';
    }

    public void setColStatus(String colStatus) {
        this.colStatus = colStatus;
    }

    public String getInsertId() {
        return insertId;
    }

    public void setInsertId(String insertId) {
        this.insertId = insertId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(Long lastVersion) {
        this.lastVersion = lastVersion;
    }

}
