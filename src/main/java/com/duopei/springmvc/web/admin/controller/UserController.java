package com.duopei.springmvc.web.admin.controller;

import com.duopei.springmvc.domain.result.ExceptionMsg;
import com.duopei.springmvc.domain.result.ResponseData;
import com.duopei.springmvc.model.User;
import com.duopei.springmvc.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/11/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/xxx", method = RequestMethod.POST)
    public ResponseData login1(User user, HttpSession session) {
        User loginUser = userService.selectByPrimaryKey(10000);
        return new ResponseData(ExceptionMsg.SUCCESS, "layout");

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(User user, HttpSession session) {
        User loginUser = userService.selectByPrimaryKey(10000);



        /*if (null == user) {
            return new ResponseData(ExceptionMsg.LoginNameNotExists);
        } else if (!loginUser.getUserPwd().equals(user.getUserPwd())) {
            return new ResponseData(ExceptionMsg.LoginNameOrPassWordError);
        }
        session.setAttribute(Const.LOGIN_SESSION_KEY, loginUser);
        String preUrl = "/";
        if(null != session.getAttribute(Const.LAST_REFERER)){
            preUrl = String.valueOf(session.getAttribute(Const.LAST_REFERER));
            if(preUrl.indexOf("/collect?") < 0){
                preUrl = "/";
            }
        }*/
        return new ResponseData(ExceptionMsg.SUCCESS, "layout");
    }
}
