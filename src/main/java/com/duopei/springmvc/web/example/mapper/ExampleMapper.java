package com.duopei.springmvc.web.example.mapper;

import com.duopei.springmvc.model.example.Example;

import java.util.List;

public interface ExampleMapper {

    List<Example> selectAllExamples(Example record);


    List<Example> selectAllExamplesSPage(Example record);


    Integer selectAllExamplesSPageCount(Example record);

    Integer deleteExampleById(String expId);

    void insertExample(Example example);

    Example selectExampleById(String expId);
}