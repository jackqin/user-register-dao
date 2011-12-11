package com.colorcc.user.register.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.register.constant.UserStatus;
import com.colorcc.user.register.model.User;

public class UserMapperTest extends TestAbstract {

	private static final Logger logger = LoggerFactory
			.getLogger(UserMapperTest.class);

	private String emailName;

	@Before
	public void init() {
		super.init();
		emailName = "jackqin@colorcc.com";
	}

	@Test
	public void testCase() {
		logger.debug("Test start ...");
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");

		logger.debug("Delete all ...");
		Map<String, Long> userIdMap = new HashMap<String, Long>();
		userIdMap.put("startUserId", null);
		userIdMap.put("endUserId", null);
		userMapper.deleteUsers(userIdMap);

		// find User by email
		User regUser = userMapper.findUserByEmail(emailName);
		if (regUser != null) {
			emailName = "new" + emailName;
		}

		Assert.assertEquals(0, userMapper.countUser());

		// insert a new user
		User user = new User();
		user.setEmail(emailName);
		user.setPasswd("111");
		user.setSalt("111");
		user.setCreateTime(new Date());
		user.setStatus(UserStatus.ONLINE.getValue());
		userMapper.insertOne(user);
		
		List<User> users = userMapper.getUsers(0L, 5);
		Assert.assertNotNull(users);
		Assert.assertTrue(users.size() > 0);
		
		// select a user by email
		User newUser = userMapper.findUserByEmail(emailName);
		Assert.assertNotNull(newUser);
		Assert.assertEquals(1, userMapper.countUser());

		// update the selected user's email and status
		long userId = newUser.getId();
		newUser.setEmail(userId + emailName);
		newUser.setStatus(UserStatus.OFFLINE.getValue());
		userMapper.updateOne(newUser);
		

		// select the user by id
		Assert.assertEquals(userMapper.selectOne(userId).getEmail(), newUser.getEmail());

		// delete the user by id
		userMapper.deleteOne(userId);
		Assert.assertEquals(0, userMapper.countUser());

		logger.debug("Test end!");
	}

}
