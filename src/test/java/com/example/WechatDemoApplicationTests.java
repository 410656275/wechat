package com.example;

import com.example.dao.repository.AccountRepository;
import com.example.dao.repository.AliUserRepository;
import com.example.dao.repository.UserRepository;
import com.example.entity.table.Account;
import com.example.entity.table.AliUser;
import com.example.entity.table.UserInfo;
import com.example.redis.StringRedisDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatDemoApplicationTests {



	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StringRedisDao stringRedisDao;

	@Autowired private AliUserRepository aliUserRepository;

	@Autowired private UserRepository userRepository;

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

//		Account account = accountRepository.findByAppid("wxafe97522967b9feb");
//		System.out.println(account.toString());
//		UserInfo userInfo = new UserInfo();
//		userInfo.setName("jack");
//		userInfo.setImg("img");
//		userInfo = userRepository.save(userInfo);
//		System.out.println(userInfo.toString());

//		AliUser aliUser = new AliUser();
//		aliUser.setAliname("lucy");
//		aliUser.setAliimg("ali");
//		aliUser = aliUserRepository.save(aliUser);
//		System.out.println(aliUser.toString());

		System.out.println(aliUserRepository.findOne(1).toGson());

	}


}
