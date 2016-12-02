package com.duopei.springmvc.web.admin.controller;

import com.duopei.springmvc.web.admin.service.TestItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/11/28.
 */
@Controller
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TestItemService testItemService;


    @RequestMapping("/order")
    public void Transaction(){
        testItemService.order("1001","100001",2);
    }
}
