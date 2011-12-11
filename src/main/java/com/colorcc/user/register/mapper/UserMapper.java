package com.colorcc.user.register.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.colorcc.common.mapper.Mapper;
import com.colorcc.user.register.model.User;

public interface UserMapper extends Mapper<User> {
	
	public User findUserByEmail(String email);
	
	public void deleteUsers(Map<String, Long> map);
	
	public int countUser();
	
	/**
	 * Got page user's data
	 * @param startRow page start row
	 * @param fetchRows row counts per page
	 * @return
	 */
	public List<User> getUsers(@Param("startRow") Long startRow, @Param("fetchRows") int fetchRows);
	
}
