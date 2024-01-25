package com.miniproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.miniproject.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	UserDTO getUserByUserId(String userId);

	int insertUser(UserDTO newUser);

	int updateUser(UserDTO user);

	int deleteUser(int userNo);

	int getUserNoByUserId(String userId);
	
}
