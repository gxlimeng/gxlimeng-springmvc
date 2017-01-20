package com.duopei.springmvc.web.example.service;

import com.duopei.springmvc.config.advice.MyThrowException;
import com.duopei.springmvc.model.example.Example;
import com.duopei.springmvc.web.example.mapper.ExampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class ExampleService {

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

    @Transactional
    public Integer deleteExampleById(String expId) throws Exception{
        Integer delCount = exampleMapper.deleteExampleById(expId);
        if(delCount != 1){
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new MyThrowException("删除数据出错,返回多条数据");
        }
        return delCount;
    }

    public void insertExample(Example example) {
        exampleMapper.insertExample(example);
    }
}
