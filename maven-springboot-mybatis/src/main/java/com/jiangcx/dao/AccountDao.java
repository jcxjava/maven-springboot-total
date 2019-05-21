package com.jiangcx.dao;


import com.jiangcx.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by jiangcx on 2019/5/14
 */
public interface AccountDao {

    List<Account> queryAllAccount();

    Account queryAccountById(Integer id);

    void insert(Account account);

    int addMoney(@Param("id") Integer id,@Param("money") Integer money);

    int reduceMoney(@Param("id") Integer id,@Param("money") Integer money);


}
