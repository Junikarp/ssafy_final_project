package com.bremen.model.dao;

import java.util.List;

import com.bremen.model.dto.User;

public interface UserDao {
	
	// 유저 목록
	List<User> selectAll();
	
	// 유저 등록
	int insertUser(User user);
	
	// 유저 조회
	User selectOne(String id);
	
	// 친구 목록 조회
	List<User> friendsAll(String id);
	
	
}
