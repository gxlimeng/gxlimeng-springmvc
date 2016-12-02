package com.duopei.springmvc.web.admin.mapper;

import com.duopei.springmvc.model.testtransction.Item;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestItemMapper {

    @Select("SELECT t.item_code itemCode,t.item_name itemName FROM gtrust.titem t WHERE t.item_code = #{itemCode}")
    public Item selectByItemCode(String itemCode);

    @Select("SELECT t.item_code itemCode,t.item_name itemName" +
            " FROM gtrust.titem t " +
            " left outer join titemprice p on t.item_code = p.item_code   ")
    public List<Item> selectAllItemByPage();
}