package com.duopei.springmvc.web.example.service;

import com.duopei.springmvc.model.example.Example;
import com.duopei.springmvc.web.example.mapper.ExampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class TablesService {

    @Autowired
    private ExampleMapper exampleMapper;

    public List<Example> selectAllExamples(Example example){
        return exampleMapper.selectAllExamples(example);
    }

    public List<Example> selectAllExamplesSPage(Example example){
        return exampleMapper.selectAllExamplesSPage(example);
    }

    public Integer selectAllExamplesSPageCount(Example example){
        return exampleMapper.selectAllExamplesSPageCount(example);
    }
}
