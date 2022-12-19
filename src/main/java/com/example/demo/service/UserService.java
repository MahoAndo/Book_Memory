package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;

/**
 *  User Information Service
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * getting User id
	 * @param userName
	 * @param password
	 * @retrun user no
	 */
	public int getUserNo(String userName, String password) {
		return userMapper.getUserNo(userName, password);
	}
	
	/**
	 * insert user info
	 * @param User
	 */
	public void insertUser(User user) {
		//set user no
		Integer maxNo = getMaxNo() + 1;
		user.setUserNo(maxNo);
			
		//create user id
		user.setUserId(UUID.randomUUID().toString());
		
		//insert
		userMapper.insertUser(user);
	}
	
	/**
	 * get max user no
	 * @return max user no
	 */
	public Integer getMaxNo() {
		return userMapper.getMaxUserNo();
	}
}