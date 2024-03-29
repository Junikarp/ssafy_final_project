package com.bremen.model.dao;

import java.util.List;

import com.bremen.model.dto.GroupUser;
import com.bremen.model.dto.User;

public interface UserDao {
	
	public List<User> selectAll();
	
	public int insertUser(User user);

	public User selectOne(String id);
	
	public List<User> friendsAll(String id);
	
	List<User> selectUsersByGroupId(int groupId);
	
	int insertGroupUser(GroupUser groupUser);
	
	void updateUser(User user);
}
