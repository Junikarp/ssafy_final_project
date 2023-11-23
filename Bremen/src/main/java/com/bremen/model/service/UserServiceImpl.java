package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bremen.model.dao.UserDao;
import com.bremen.model.dto.GroupUser;
import com.bremen.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public List<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insertUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public User selectOne(String id) {
		return dao.selectOne(id);
	}

	@Override
	public List<User> friendsAll(String id) {
		return dao.friendsAll(id);
	}

	@Override
	public List<User> selectUsersByGroupId(int groupId) {
		return dao.selectUsersByGroupId(groupId);
	}

	@Override
	public int insertGroupUser(GroupUser groupUser) {
		return dao.insertGroupUser(groupUser);
	}
	
	
}
