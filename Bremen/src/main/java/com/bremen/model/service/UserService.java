package com.bremen.model.service;

import java.util.List;

import com.bremen.model.dto.GroupUser;
import com.bremen.model.dto.User;

public interface UserService {
	
	// 유저 리스트 가져오기 
	List<User> selectAll();
	
	// 회원가입 
	int insertUser(User user);
	
	// 유저조회 
	User selectOne(String id);
	
	// 친구목록 조회 
	List<User> friendsAll(String id);
	
	List<User> selectUsersByGroupId(int groupId);
	
	int insertGroupUser(GroupUser groupUser);
}
