package com.youniforever.login.dto;

import org.apache.ibatis.type.Alias;

@Alias("LoginSessionDto")
public class LoginSessionDto {
	private String userId;
	private String userName;
	private Integer userLevel;
	private Integer userAge;
	private Integer userDivision;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Integer getUserDivision() {
		return userDivision;
	}

	public void setUserDivision(Integer userDivision) {
		this.userDivision = userDivision;
	}

}
