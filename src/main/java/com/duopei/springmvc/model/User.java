package com.duopei.springmvc.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.LOGIN_NAME
     *
     * @mbggenerated
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.USER_NAME
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.USER_PWD
     *
     * @mbggenerated
     */
    private String userPwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.USER_TEL
     *
     * @mbggenerated
     */
    private String userTel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.USER_EMAIL
     *
     * @mbggenerated
     */
    private String userEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.USER_STATUS
     *
     * @mbggenerated
     */
    private Integer userStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.USER_TYPE
     *
     * @mbggenerated
     */
    private String userType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.PARENT_ID
     *
     * @mbggenerated
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.COMMONS
     *
     * @mbggenerated
     */
    private String commons;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.LAST_LOGIN_TIME
     *
     * @mbggenerated
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.LAST_UPDATE_PWD_DATE
     *
     * @mbggenerated
     */
    private Date lastUpdatePwdDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.INSERT_ID
     *
     * @mbggenerated
     */
    private Integer insertId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.INSERT_DATE
     *
     * @mbggenerated
     */
    private Date insertDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.MODIFY_ID
     *
     * @mbggenerated
     */
    private Integer modifyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.MODIFY_DATE
     *
     * @mbggenerated
     */
    private Date modifyDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.ID
     *
     * @return the value of sys_user.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.ID
     *
     * @param id the value for sys_user.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.LOGIN_NAME
     *
     * @return the value of sys_user.LOGIN_NAME
     *
     * @mbggenerated
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.LOGIN_NAME
     *
     * @param loginName the value for sys_user.LOGIN_NAME
     *
     * @mbggenerated
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.USER_NAME
     *
     * @return the value of sys_user.USER_NAME
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.USER_NAME
     *
     * @param userName the value for sys_user.USER_NAME
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.USER_PWD
     *
     * @return the value of sys_user.USER_PWD
     *
     * @mbggenerated
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.USER_PWD
     *
     * @param userPwd the value for sys_user.USER_PWD
     *
     * @mbggenerated
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.USER_TEL
     *
     * @return the value of sys_user.USER_TEL
     *
     * @mbggenerated
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.USER_TEL
     *
     * @param userTel the value for sys_user.USER_TEL
     *
     * @mbggenerated
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.USER_EMAIL
     *
     * @return the value of sys_user.USER_EMAIL
     *
     * @mbggenerated
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.USER_EMAIL
     *
     * @param userEmail the value for sys_user.USER_EMAIL
     *
     * @mbggenerated
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.USER_STATUS
     *
     * @return the value of sys_user.USER_STATUS
     *
     * @mbggenerated
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.USER_STATUS
     *
     * @param userStatus the value for sys_user.USER_STATUS
     *
     * @mbggenerated
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.USER_TYPE
     *
     * @return the value of sys_user.USER_TYPE
     *
     * @mbggenerated
     */
    public String getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.USER_TYPE
     *
     * @param userType the value for sys_user.USER_TYPE
     *
     * @mbggenerated
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.PARENT_ID
     *
     * @return the value of sys_user.PARENT_ID
     *
     * @mbggenerated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.PARENT_ID
     *
     * @param parentId the value for sys_user.PARENT_ID
     *
     * @mbggenerated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.COMMONS
     *
     * @return the value of sys_user.COMMONS
     *
     * @mbggenerated
     */
    public String getCommons() {
        return commons;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.COMMONS
     *
     * @param commons the value for sys_user.COMMONS
     *
     * @mbggenerated
     */
    public void setCommons(String commons) {
        this.commons = commons == null ? null : commons.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.LAST_LOGIN_TIME
     *
     * @return the value of sys_user.LAST_LOGIN_TIME
     *
     * @mbggenerated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.LAST_LOGIN_TIME
     *
     * @param lastLoginTime the value for sys_user.LAST_LOGIN_TIME
     *
     * @mbggenerated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.LAST_UPDATE_PWD_DATE
     *
     * @return the value of sys_user.LAST_UPDATE_PWD_DATE
     *
     * @mbggenerated
     */
    public Date getLastUpdatePwdDate() {
        return lastUpdatePwdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.LAST_UPDATE_PWD_DATE
     *
     * @param lastUpdatePwdDate the value for sys_user.LAST_UPDATE_PWD_DATE
     *
     * @mbggenerated
     */
    public void setLastUpdatePwdDate(Date lastUpdatePwdDate) {
        this.lastUpdatePwdDate = lastUpdatePwdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.INSERT_ID
     *
     * @return the value of sys_user.INSERT_ID
     *
     * @mbggenerated
     */
    public Integer getInsertId() {
        return insertId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.INSERT_ID
     *
     * @param insertId the value for sys_user.INSERT_ID
     *
     * @mbggenerated
     */
    public void setInsertId(Integer insertId) {
        this.insertId = insertId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.INSERT_DATE
     *
     * @return the value of sys_user.INSERT_DATE
     *
     * @mbggenerated
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.INSERT_DATE
     *
     * @param insertDate the value for sys_user.INSERT_DATE
     *
     * @mbggenerated
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.MODIFY_ID
     *
     * @return the value of sys_user.MODIFY_ID
     *
     * @mbggenerated
     */
    public Integer getModifyId() {
        return modifyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.MODIFY_ID
     *
     * @param modifyId the value for sys_user.MODIFY_ID
     *
     * @mbggenerated
     */
    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.MODIFY_DATE
     *
     * @return the value of sys_user.MODIFY_DATE
     *
     * @mbggenerated
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.MODIFY_DATE
     *
     * @param modifyDate the value for sys_user.MODIFY_DATE
     *
     * @mbggenerated
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}