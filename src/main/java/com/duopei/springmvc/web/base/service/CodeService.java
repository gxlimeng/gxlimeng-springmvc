package com.duopei.springmvc.web.base.service;

import com.duopei.springmvc.model.base.Code;
import com.duopei.springmvc.web.base.mapper.CodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
@Service
public class CodeService {

    private static final Logger logger = LoggerFactory.getLogger(CodeService.class);

    @Autowired
    private CodeMapper codeMapper;

    public List<Code> selectByCodeLgroup(String codeLgroup){
        return codeMapper.selectByCodeLgroup(codeLgroup);
    }

}
