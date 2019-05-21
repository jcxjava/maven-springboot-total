package com.jiangcx.service;


import com.jiangcx.entity.Account;

import java.util.List;
import java.util.Map;

/**
 * Created by jiangcx on 2019/5/14
 */
public interface AccountService {

    List<Account> queryAll();

    Account queryAccountById(Integer id);

    Boolean add(Integer id,Integer money);

    Boolean reduce(Integer id,Integer money);

    void transfer(Integer id1, Integer money, Integer id2);

}
