package com.duopei.springmvc.web.admin.service;

import com.duopei.springmvc.model.User;
import com.duopei.springmvc.web.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
