package com.colorcc.user.register.mapper;

import java.util.Map;

import com.colorcc.common.mapper.Mapper;
import com.colorcc.user.register.model.User;

public interface UserMapper extends Mapper<User> {
	
	public User findUserByEmail(String email);
	
	public void deleteUsers(Map<String, Long> map);
	
	public int countUser();
	
}
