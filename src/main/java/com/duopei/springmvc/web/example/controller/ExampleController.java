package com.duopei.springmvc.web.example.controller;


import com.duopei.springmvc.domain.result.ExceptionMsg;
import com.duopei.springmvc.domain.result.ResponseData;
import com.duopei.springmvc.model.ResponsePageUtil;
import com.duopei.springmvc.model.example.Example;
import com.duopei.springmvc.web.example.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Controller
@RequestMapping("example")
public class ExampleController {

    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    public ExampleService exampleService;

    @RequestMapping(value = "datatables",method = RequestMethod.GET)
    public String dataTable(){
        return "example/tables";
    }

    @ResponseBody
    @RequestMapping("/query")
    public ResponsePageUtil queryForClient(){
        ResponsePageUtil t = new ResponsePageUtil();
        List<Example> examples = exampleService.selectAllExamples(new Example());
        t.setData(examples);
        return t;
    }

    @ResponseBody
    @RequestMapping(value = "/queryS",method = RequestMethod.POST)
    public ResponsePageUtil queryForServer(@RequestBody Example example) throws Exception {
        logger.info("param3>>>>>>>>:" + example);
        ResponsePageUtil t = new ResponsePageUtil();
        Integer pageSize = exampleService.selectAllExamplesSPageCount(example);
        if(pageSize > 0 ) {
            List<Example> examples = exampleService.selectAllExamplesSPage(example);
            logger.info("result=>>" + examples);
            t.setRecordsFiltered(pageSize);
            t.setRecordsTotal(pageSize);
            t.setData(examples);
            return t;
        }
        return t;
    }

    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public ResponseData del(@RequestParam String expId) throws Exception{
        Integer delCount = exampleService.deleteExampleById(expId);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }

    @RequestMapping("/add")
    public String add(Model model){
        Example example = new Example();
        example.setExpName("测试");
        example.setExpSex("1");
        model.addAttribute("example",example);

        return "example/example-add";
    }


    @ResponseBody
    @RequestMapping("/new")
    public String storeExample(Model model,Example example){
        System.out.println("new example " + example.toString());
        return null;
    }

    public ResponsePageUtil<Example> getResponsePageData(){
        ResponsePageUtil t = new ResponsePageUtil();
        return t;
    }


}
