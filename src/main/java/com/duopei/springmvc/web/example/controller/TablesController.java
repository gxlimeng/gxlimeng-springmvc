package com.duopei.springmvc.web.example.controller;


import com.duopei.springmvc.model.ResponsePageUtil;
import com.duopei.springmvc.model.example.Example;
import com.duopei.springmvc.web.example.service.TablesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Controller
@RequestMapping("example")
public class TablesController {

    private static final Logger logger = LoggerFactory.getLogger(TablesController.class);
    @Autowired
    private TablesService tablesService;

    @RequestMapping(value = "datatables",method = RequestMethod.GET)
    public String dataTable(){
        return "example/tables";
    }

    @ResponseBody
    @RequestMapping("/query")
    public ResponsePageUtil queryForClient(){
        ResponsePageUtil t = new ResponsePageUtil();
        List<Example> examples = tablesService.selectAllExamples(new Example());
        t.setData(examples);
        return t;
    }

    @ResponseBody
    @RequestMapping(value = "/queryS",method = RequestMethod.POST)
    public ResponsePageUtil queryForServer(@RequestBody Example example) throws IOException {
        logger.info("param3>>>>>>>>:" + example);
        ResponsePageUtil t = new ResponsePageUtil();
        List<Example> examples = tablesService.selectAllExamplesSPage(example);
        Integer pageSize = tablesService.selectAllExamplesSPageCount(example);
        t.setRecordsFiltered(pageSize);
        t.setRecordsTotal(pageSize);
        t.setData(examples);
        return t;
    }

}
