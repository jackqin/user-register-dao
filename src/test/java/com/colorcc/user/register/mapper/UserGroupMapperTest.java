package com.colorcc.user.register.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.colorcc.user.register.model.UserGroup;

public class UserGroupMapperTest extends TestAbstract {

	private static final Logger logger = LoggerFactory.getLogger(UserGroupMapperTest.class);

	private String groupName;

	@Before
	public void init() {
		super.init();
		groupName = "校友";
	}

	@Test
	public void testCase() {
		logger.debug("Test start ...");
		UserGroupMapper userMapper = (UserGroupMapper) context.getBean("userGroupMapper");
		
		// clean the table
		Map<String, Integer> idMap = new HashMap<String, Integer>();
		idMap.put("startId", null);
		idMap.put("endId", null);
		userMapper.deleteUserGroups(idMap);
		

		// insert one
		UserGroup newUserGroup = new UserGroup();
		newUserGroup.setGroupName(groupName);
		newUserGroup.setDescription("");
		userMapper.insertOne(newUserGroup);
		
		// select by name
		Assert.notNull(userMapper.findUserGroupByName(groupName));
		
		newUserGroup.setGroupName("同学");
		
		// update it
		userMapper.updateOne(newUserGroup);
		Assert.isNull(userMapper.findUserGroupByName(groupName));
		UserGroup ug = userMapper.findUserGroupByName("同学");
		Assert.notNull(ug);
		
		// select one
		Assert.notNull(userMapper.selectOne(ug.getId()));
		
		// delete it
		userMapper.deleteOne(ug.getId());
		Assert.isNull(userMapper.findUserGroupByName("同学"));
		
		logger.debug("Test end!");
	}

}
