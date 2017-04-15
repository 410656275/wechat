package com.example.dao.repository;

import com.example.entity.table.Account;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * Created by cc on 17-4-5.
 */
public interface AccountRepository extends CrudRepository<Account,Integer>{

    Account findByAppid(String appid);

}
