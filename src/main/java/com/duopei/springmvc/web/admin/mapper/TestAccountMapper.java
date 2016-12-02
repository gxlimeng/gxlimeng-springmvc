package com.duopei.springmvc.web.admin.mapper;

import com.duopei.springmvc.model.testtransction.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TestAccountMapper {

    @Select("SELECT t.CUST_NO custNo,t.AMT amt FROM gtrust.taccount t WHERE t.CUST_NO = #{custNo}")
    public Account selectByCustNo(String custNo);

    @Update(" update taccount t " +
            "   set t.amt = t.amt - #{salePrice} " +
            " where t.cust_no = #{custNo} ")
    public void updateAccountAmt(@Param("custNo") String custNo, @Param("salePrice")Double salePrice);
}