package com.duopei.springmvc.web.base.service;

import com.duopei.springmvc.model.base.ErrorLog;
import com.duopei.springmvc.web.base.mapper.ErrorLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/1/13.
 */
@Service
public class ErrorLogService {

    private static final Logger logger = LoggerFactory.getLogger(ErrorLogService.class);

    @Autowired
    private ErrorLogMapper errorLogMapper;

    @Transactional
    public void insertErrorLogService(ErrorLog err){
        errorLogMapper.insertErrorLogService(err);
    }

}
