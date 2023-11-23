package com.bremen.model.dao;

import java.util.List;

import com.bremen.model.dto.Board;

public interface BoardDao {
	// 전체 목록
	List<Board> selectAll(String category);
	
	// 상세 조회
	Board selectOne(int id);
	
	// 게시글 등록
	int insertBoard(Board board);
	
	// 게시글 삭제 
	void deleteBoard(int id);
	
	// 게시글 수정 
	void updateBoard(Board board);
	
	// 조회수 증가 
	void updateViewCnt(int id);
	
	// 좋아요 증가
	void updateLike(int id);
	
	// 싫어요 증가
	void updateHate(int id);
}
