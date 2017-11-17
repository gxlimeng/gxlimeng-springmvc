package com.duopei.springmvc.web.base.mapper;

import com.duopei.springmvc.model.base.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeMapper {

    List<Code> selectByCodeLgroup(String codeLgroup);

}