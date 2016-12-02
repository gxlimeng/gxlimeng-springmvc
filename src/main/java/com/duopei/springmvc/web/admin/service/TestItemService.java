package com.duopei.springmvc.web.admin.service;

import com.duopei.springmvc.model.testtransction.Account;
import com.duopei.springmvc.model.testtransction.Item;
import com.duopei.springmvc.model.testtransction.ItemPrice;
import com.duopei.springmvc.model.testtransction.Stock;
import com.duopei.springmvc.web.admin.mapper.TestAccountMapper;
import com.duopei.springmvc.web.admin.mapper.TestItemMapper;
import com.duopei.springmvc.web.admin.mapper.TestItemPriceMapper;
import com.duopei.springmvc.web.admin.mapper.TestItemStockMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class TestItemService {

    private static final Logger logger = LoggerFactory.getLogger(TestItemService.class);

    @Autowired
    public TestItemMapper testItemMapper;

    @Autowired
    public TestItemPriceMapper testItemPriceMapper;

    @Autowired
    public TestItemStockMapper testItemStockMapper;

    @Autowired
    public TestAccountMapper testAccountMapper;


    /**
     * 场景：
     *  用户 A 余额 100  购买商品 B 价格120  库存10
     *  用户 A 余额 200  购买商品 B 价格120  库存10
     *
     *  用户 A 余额 200  购买商品 B 价格120  库存10
     *  用户 A 余额 200  购买商品 B 价格120  库存10
     *
     *
     * @param itemCode
     * @return
     * @throws JsonProcessingException
     */
    @Transactional
    public void order(String custNo,String itemCode,Integer qty) {
        Account account = testAccountMapper.selectByCustNo(custNo);
        if(null == account){
            logger.info(" no user " + custNo);
        }
        Item item = testItemMapper.selectByItemCode(itemCode);
        if(null == item){
            logger.info(" no item " + itemCode);
        }
        ItemPrice itemPrice = testItemPriceMapper.selectByItem(itemCode);
        if(null == itemPrice){
            logger.info(" no itemPrice " + itemCode);
        }
        Stock stock = testItemStockMapper.selectByItem(itemCode);
        if(null == stock){
            logger.info(" no stock " + itemCode);
        }
        if(account.getAmt() < itemPrice.getSalePrice()){
            logger.info(" no money "+ custNo);
        }
        testItemStockMapper.updateStockQty(itemCode,qty);
        int i = 20/0;
        testAccountMapper.updateAccountAmt(custNo,itemPrice.getSalePrice());

    }

    public void selectAllItemByPage(){
        PageHelper.startPage(1,10);
        List<Item> itemList = testItemMapper.selectAllItemByPage();
        logger.info("size=" + itemList.size());
        for (Item item : itemList){
            logger.info(item.getItemCode());
        }
        PageHelper.startPage(3,10);
        itemList = testItemMapper.selectAllItemByPage();
        logger.info("size=" + itemList.size());
        for (Item item : itemList){
            logger.info(item.getItemCode());
        }
    }

}
