package com.duopei.springmvc.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/23.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String admin(Model model){
        /*long size= collectRepository.countByUserIdAndIsDelete(getUserId(),IsDelete.NO);
        Config config = configRepository.findByUserId(getUserId());
        Favorites favorites = favoritesRepository.findOne(Long.parseLong(config.getDefaultFavorties()));
        List<String> followList = followRepository.findByUserId(getUserId());
        model.addAttribute("config",config);
        model.addAttribute("favorites",favorites);
        model.addAttribute("size",size);
        model.addAttribute("followList",followList);
        model.addAttribute("user",getUser());
        model.addAttribute("newAtMeCount",noticeRepository.countByUserIdAndTypeAndReaded(getUserId(), "at", "unread"));
        model.addAttribute("newCommentMeCount",noticeRepository.countByUserIdAndTypeAndReaded(getUserId(), "comment", "unread"));
        model.addAttribute("newPraiseMeCount",noticeRepository.countPraiseByUserIdAndReaded(getUserId(), "unread"));
        logger.info("collect size="+size+" userID="+getUserId());*/
        return "home";
    }
}
