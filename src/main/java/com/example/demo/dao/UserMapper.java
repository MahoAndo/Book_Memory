package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

/**
 * UserMapper
 * @author maho ando
 * @date Oct 15 2022
 */
@Mapper
public interface UserMapper{
	
	/**
	 * get userId
	 * @param userName
	 * @param password
	 * @return userNo
	 */
	public int getUserNo(String userName, String password);
	
	/**
	 * insert user
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * update user
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * delete user
	 * @param userNo
	 */
	public void deleteUser(Integer userNo);
	
	/**
	 * get max userNo
	 * @return user
	 */
	public int getMaxUserNo();
}