package com.duopei.springmvc.web.admin.mapper;

import com.duopei.springmvc.model.testtransction.ItemPrice;
import org.apache.ibatis.annotations.Select;

public interface TestItemPriceMapper {

    @Select("SELECT t.item_code itemCode,t.unit_code unitCode,t.sale_price salePrice,t.sale_cost saleCost,t.buy_price buyPrice,t.buy_cost buyCost " +
            " FROM gtrust.titemprice t " +
            " where t.item_code =#{itemCode} " +
            " and t.unit_code = '001' ")
    public ItemPrice selectByItem(String itemCode);
}