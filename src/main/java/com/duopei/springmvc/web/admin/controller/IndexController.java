package com.duopei.springmvc.web.admin.controller;

import com.duopei.springmvc.comm.Const;
import com.duopei.springmvc.model.menu.Menu;
import com.duopei.springmvc.model.user.User;
import com.duopei.springmvc.web.admin.service.MenuService;
import com.duopei.springmvc.web.admin.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */
@Controller
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    public MenuService menuService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/")
    public String admin(Model model,HttpSession session) throws JsonProcessingException {
//        if(null == session.getAttribute(Const.LOGIN_SESSION_KEY)){
//            return "login";
//        }
//        User user = (User) session.getAttribute(Const.LOGIN_SESSION_KEY);
        /**临时**/
        User userCond = new User();
        userCond.setUserTel("13472776147");
        User user = userService.selectUserByLogin(userCond);
        session.setAttribute(Const.LOGIN_SESSION_KEY, user);
        /****/

        List<Menu> menulist = menuService.selectMenu(user);

        model.addAttribute("menus",menulist);
        return "index";
    }
}
