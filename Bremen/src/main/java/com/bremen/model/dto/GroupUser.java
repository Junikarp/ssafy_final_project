package com.bremen.model.dto;

public class GroupUser {
	private String groupUserUserId;
	private int groupUserGroupId;
	
	
	public GroupUser() {}
	
	
	public GroupUser(String groupUserUserId, int groupUserGroupId) {
		this.groupUserUserId = groupUserUserId;
		this.groupUserGroupId = groupUserGroupId;
	}


	public String getGroupUserUserId() {
		return groupUserUserId;
	}
	public void setGroupUserUserId(String groupUserUserId) {
		this.groupUserUserId = groupUserUserId;
	}
	public int getGroupUserGroupId() {
		return groupUserGroupId;
	}
	public void setGroupUserGroupId(int groupUserGroupId) {
		this.groupUserGroupId = groupUserGroupId;
	}
	
	
}
