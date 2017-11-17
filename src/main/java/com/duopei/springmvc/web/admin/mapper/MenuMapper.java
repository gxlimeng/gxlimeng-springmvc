package com.duopei.springmvc.web.admin.mapper;

import com.duopei.springmvc.model.menu.Menu;
import com.duopei.springmvc.model.user.User;

import java.util.List;

public interface MenuMapper {

    List<Menu> selectMenuByUser(User user);

    List<Menu> selectMenu(User user);

}