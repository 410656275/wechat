package com.example;

import com.example.dao.repository.AccountRepository;
import com.example.entity.table.Account;
import com.example.redis.*;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatDemoApplicationTests {



	@Autowired
	private AccountRepository accountRepository;

	@Before
	public void before(){


	}


	@Test
	public void contextLoads() {
		Account account = accountRepository.findByAppid("wxafe97522967b9feb");
		System.out.println(account.isEnable());
	}

	@Test
	public void test1(){

	}


}
