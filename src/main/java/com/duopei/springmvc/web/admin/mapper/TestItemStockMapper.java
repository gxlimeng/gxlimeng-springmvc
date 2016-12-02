package com.duopei.springmvc.web.admin.mapper;

import com.duopei.springmvc.model.testtransction.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TestItemStockMapper {

    @Select("SELECT t.item_code itemCode,t.wh_code whCode,t.unit_code unitCode,t.qty qty FROM gtrust.tstock t WHERE t.item_code = #{itemCode} and t.wh_code ='100' and t.unit_code = '001' and t.qty > 0 ")
    Stock selectByItem(String itemCode);


    @Update(" update tstock t " +
            "   set t.qty = t.qty - #{qty} " +
            " where t.item_code = #{itemCode} " +
            " and t.unit_code ='001'" +
            " and t.wh_code ='100' ")
    public void updateStockQty(@Param("itemCode")String itemCode, @Param("qty")Integer qty);
}