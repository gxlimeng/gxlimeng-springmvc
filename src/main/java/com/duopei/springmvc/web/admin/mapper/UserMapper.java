package com.duopei.springmvc.web.admin.mapper;

import com.duopei.springmvc.model.user.User;

import java.util.List;

public interface UserMapper {

    //@Select("SELECT id id,LOGIN_NAME loginName,USER_NAME userName,USER_PWD userPwd FROM sys_user WHERE id = #{id}")
    User selectUserByLogin(User user);

    List<User> selectAllUsers();
}