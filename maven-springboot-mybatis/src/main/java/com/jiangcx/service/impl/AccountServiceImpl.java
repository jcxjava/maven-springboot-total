package com.jiangcx.service.impl;

import com.jiangcx.dao.AccountDao;
import com.jiangcx.entity.Account;
import com.jiangcx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangcx on 2019/5/21
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public List<Account> queryAll() {
        List<Account> list = accountDao.queryAllAccount();
        return list;
    }

    @Override
    public Account queryAccountById(Integer id) {
        Account account = this.accountDao.queryAccountById(id);
        return account;
    }

    @Override
    public Boolean add(Integer id,Integer money) {
        int count = accountDao.addMoney(id, money);
        return count == 1;
    }

    @Override
    public Boolean reduce(Integer id,Integer money) {
        int count = accountDao.reduceMoney(id, money);
        return count == 1;
    }

    @Override
    @Transactional // 开启事务
    public void transfer(Integer id1, Integer money, Integer id2) {
        add(id1, money);
        int i = 100/0;
        reduce(id2, money);
    }

}
