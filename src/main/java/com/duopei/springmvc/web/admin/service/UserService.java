package com.duopei.springmvc.web.admin.service;

import com.duopei.springmvc.model.User;
import com.duopei.springmvc.web.admin.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserMapper userMapper;

    public User selectByPrimaryKey(Integer id) throws JsonProcessingException {
        User user = userMapper.selectByPrimaryKey(id);
        ObjectMapper mapper= new ObjectMapper();
        logger.info(">>>>>>>>user>>>>>"+ mapper.writeValueAsString(user));
        return user;
    }

}
