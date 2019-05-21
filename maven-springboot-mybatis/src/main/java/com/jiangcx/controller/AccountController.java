package com.jiangcx.controller;

import com.jiangcx.entity.Account;
import com.jiangcx.service.AccountService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangcx on 2019/5/21
 */
@RestController
public class AccountController {
    @Resource
    private AccountService service;

    @RequestMapping("/queryAll")
    public List getAllAccount(){
        List<Account> list = service.queryAll();
        return list;
    }

    @RequestMapping("/query/{id}")
    public Account getAccountById(@PathVariable Integer id){
        Account account = service.queryAccountById(id);
        return account;
    }
    @RequestMapping("/modify/{id1}/{money}/{id2}")
    public String modifyMoney(@PathVariable Integer id1,@PathVariable Integer money,@PathVariable Integer id2){
        service.transfer(id1, money, id2);
        return "modify success";
    }
}
