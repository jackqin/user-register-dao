package com.colorcc.user.register.mapper;

import java.util.Map;

import com.colorcc.common.mapper.Mapper;
import com.colorcc.user.register.model.UserGroup;

public interface UserGroupMapper extends Mapper<UserGroup> {
	
	public UserGroup findUserGroupByName(String groupName);
	
	public void deleteUserGroups(Map<String, Integer> idMap);
	
}
