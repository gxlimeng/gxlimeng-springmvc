package com.duopei.springmvc.web.admin.service;

import com.duopei.springmvc.model.menu.Menu;
import com.duopei.springmvc.model.user.User;
import com.duopei.springmvc.web.admin.mapper.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    public MenuMapper menuMapper;

    public List<Menu> selectMenuByUser(User user) {
        return menuMapper.selectMenuByUser(user);
    }


    public List<Menu> selectMenu(User user) {
        return menuMapper.selectMenu(user);
    }
}
