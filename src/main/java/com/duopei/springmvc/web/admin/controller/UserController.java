package com.duopei.springmvc.web.admin.controller;

import com.duopei.springmvc.comm.Const;
import com.duopei.springmvc.domain.result.ExceptionMsg;
import com.duopei.springmvc.domain.result.ResponseData;
import com.duopei.springmvc.model.user.User;
import com.duopei.springmvc.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/11/23.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/xxx", method = RequestMethod.POST)
    public ResponseData login1(User user, HttpSession session) throws Exception {
        User loginUser = userService.selectUserByLogin(user);
        return new ResponseData(ExceptionMsg.SUCCESS, "layout");
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(User userCond, HttpSession session) throws Exception {
        String preUrl = "/";
        if(null == session.getAttribute(Const.LOGIN_SESSION_KEY)){
            User loginUser = null;
            try {
                loginUser = userService.selectUserByLogin(userCond);
            }catch (Exception e){
                return new ResponseData(ExceptionMsg.LoginNameOrPassWordError);
            }
            // TODO: 2016/12/6 MD5加密密码比对
            if (null == loginUser || !loginUser.getUserPwd().equals(userCond.getUserPwd())) {
                //return new ResponseData(ExceptionMsg.LoginNameOrPassWordError);
            }
            session.setAttribute(Const.LOGIN_SESSION_KEY, loginUser);
            if(null != session.getAttribute(Const.LAST_REFERER)){
                preUrl = String.valueOf(session.getAttribute(Const.LAST_REFERER));
                if(preUrl.indexOf("/collect?") < 0){
                    preUrl = "/";
                }
            }
        }
        return new ResponseData(ExceptionMsg.SUCCESS, preUrl);
    }

    @RequestMapping(value = "userlist" ,method = RequestMethod.GET)
    public String userList() {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        return "admin/user/user-list";
    }
}
