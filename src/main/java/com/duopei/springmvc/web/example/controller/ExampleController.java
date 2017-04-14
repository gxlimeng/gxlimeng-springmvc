package com.duopei.springmvc.web.example.controller;


import com.duopei.springmvc.domain.result.ExceptionMsg;
import com.duopei.springmvc.domain.result.ResponseData;
import com.duopei.springmvc.model.ResponsePageUtil;
import com.duopei.springmvc.model.example.Example;
import com.duopei.springmvc.web.base.service.CodeService;
import com.duopei.springmvc.web.example.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
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

    @Autowired
    public CodeService codeService;



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

    @RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
    public String add(Model model){
        Example example = new Example();
        example.setExpName("测试");
        example.setExpSex("2");
        List<String> intes = new ArrayList<String>();
        intes.add("1");
        intes.add("2");
        example.setInterests(intes);
        example.setExpDate(new Date(System.currentTimeMillis()));
        model.addAttribute("example",example);
        model.addAttribute("jobTypes", codeService.selectByCodeLgroup("A002"));
        return "example/example-add";
    }

    @RequestMapping(value = "/edit", produces = "text/html;charset=UTF-8")
    public String edit(@RequestParam String expId, Model model){
        Example example = exampleService.selectExampleById(expId);
        if(null == example){

        }
        List<String> intes = new ArrayList<String>();
        intes.add("1");
        intes.add("2");
        example.setColStatus("MODIFY");
        example.setInterests(intes);
        example.setExpDate(example.getInsertDate());
        model.addAttribute("example",example);
        model.addAttribute("jobTypes", codeService.selectByCodeLgroup("A002"));
        return "example/example-add";
    }

    @ResponseBody
    @RequestMapping(value = "/new", produces = "text/plain;charset=UTF-8")
    public ResponseData storeExample(Model model, Example example, HttpServletRequest request){
        System.out.println("new example " + example.toString()+" === "+ request.getCharacterEncoding());
        if(example.getColStatus().equals("NEW")) {
            exampleService.insertExample(example);
        }else{
            logger.info("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+example.toString());
        }
        return new ResponseData(ExceptionMsg.SUCCESS);
    }



}
