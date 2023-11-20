package com.bremen.model.service;

import java.util.List;

import com.bremen.model.dto.Group;

public interface GroupService {
	// 전체 목록
	List<Group> selectAll(String category);

	// 상세 조회
	Group selectOne(int id);

	// 게시글 등록
	int insertGroup(Group group);

	// 게시글 삭제
	void deleteGroup(int id);

	// 게시글 수정
	void updateGroup(Group group);

	// 조회수 증가
	void updateViewCnt(int id);

}
