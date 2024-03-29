package com.bremen.model.dto;

public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private int userPoint;
	private String userFriend;
	private int userGroup;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public String getUserFriend() {
		return userFriend;
	}

	public void setUserFriend(String userFriend) {
		this.userFriend = userFriend;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userNickname=" + userNickname + ", userPoint=" + userPoint + ", userFriend=" + userFriend + "]";
	}

	public int getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(int userGroup) {
		this.userGroup = userGroup;
	}
}
