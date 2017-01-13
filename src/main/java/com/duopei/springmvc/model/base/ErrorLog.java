package com.duopei.springmvc.model.base;

import java.sql.Date;

/**
 * Created by Administrator on 2017/1/13.
 */
public class ErrorLog {

    private Long errId;
    private String errName;
    private String errType;
    private String errorClass;
    private String errException;
    private String errMsg;
    private Date errDate;

    @Override
    public String toString() {
        return "ErrorLog{" +
                "errId=" + errId +
                ", errName='" + errName + '\'' +
                ", errType='" + errType + '\'' +
                ", errorClass='" + errorClass + '\'' +
                ", errException='" + errException + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", errDate=" + errDate +
                '}';
    }

    public Long getErrId() {
        return errId;
    }

    public void setErrId(Long errId) {
        this.errId = errId;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(String errorClass) {
        this.errorClass = errorClass;
    }

    public String getErrException() {
        return errException;
    }

    public void setErrException(String errException) {
        this.errException = errException;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Date getErrDate() {
        return errDate;
    }

    public void setErrDate(Date errDate) {
        this.errDate = errDate;
    }
}
