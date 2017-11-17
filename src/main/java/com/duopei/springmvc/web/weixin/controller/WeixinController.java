package com.duopei.springmvc.web.weixin.controller;

/**
 * Created by Administrator on 2017/4/20.
 */

import com.duopei.springmvc.web.weixin.service.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wx")
public class WeixinController {

    /**
     * 验证签名入口（微信后台服务配置链接）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/signatrue", method = RequestMethod.GET)
    public String checkSignature(HttpServletRequest request) {
        if(SignService.checkSignature(request)){
            return request.getParameter("echostr");
        }
        return "ERROR";
    }


    /**
     * 创建菜单接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createMenu", method = RequestMethod.GET)
    public String createMenu(HttpServletRequest request) {
        //TODO 查询库的菜单数据，调用接口 同步至后台
        return "SUCCESS";
    }

    /**
     * 获取用户列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(HttpServletRequest request) {
        //TODO 获取用户数据同步至库
        return "SUCCESS";
    }

    /**
     * 获取分组
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getGroups", method = RequestMethod.GET)
    public String getGroups(HttpServletRequest request) {
        //TODO 获取标签库数据至库
        return "SUCCESS";
    }
}
