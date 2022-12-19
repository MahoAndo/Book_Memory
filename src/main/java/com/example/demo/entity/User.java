package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 * @author maho ando
 * @date Oct 15 2022
 */
@Data
@Getter
@Setter
public class User{
	
	/** userNo */ 		private int userNo;
	/** userId */ 		private String userId;
	/** username */ 	private String userName;
	/** password */ 	private String password;
	
	public User() {

	}
	
	public User(
			int userNo,
			String userId,
			String userName,
			String password
			) 
		{
			this.userNo = userNo;
			this.userId = userId;
			this.userName = userName;
			this.password = password;
		}

}