package com.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.UserDTO;
import com.miniproject.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper mapper;
	
	public UserDTO getUserByUserId(String userId) {
		UserDTO user = mapper.getUserByUserId(userId);
		System.out.println(user);
		
		return user;
	}

	public boolean insertUser(UserDTO newUser) {
		boolean result = false;
		
		int res = mapper.insertUser(newUser);
		
		if(res != 0) {
			result = true;
		}
		
		return result;
	}

	public boolean updateUser(UserDTO user) {
		boolean result = false;
		
		int res = mapper.updateUser(user);
		
		if(res != 0) {
			result = true;
		}
		
		return result;
	}

	public boolean deleteUser(int userNo) {
		boolean result = false;
		
		int res = mapper.deleteUser(userNo);
		
		if(res != 0) {
			result = true;
		}
		
		return result;
	}

	public int getUserNoByUserId(String userId) {
		
		int userNo = mapper.getUserNoByUserId(userId);
		
		return userNo;
	}
	
}
