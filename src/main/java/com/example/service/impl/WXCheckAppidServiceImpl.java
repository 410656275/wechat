package com.example.service.impl;

import com.example.dao.repository.AccountRepository;
import com.example.entity.table.Account;
import com.example.service.WXCheckAppidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by cc on 17-4-13.
 */
@Service
public class WXCheckAppidServiceImpl implements WXCheckAppidService {

    @Autowired AccountRepository accountRepository;

    @Override
    public Account check(String appid) {

        return accountRepository.findByAppid(appid);


    }
}
