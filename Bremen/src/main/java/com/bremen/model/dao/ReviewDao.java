package com.bremen.model.dao;

import java.util.List;

import com.bremen.model.dto.Review;

public interface ReviewDao {

	// 전체목록
	List<Review> selectAll();

	// 댓글 등록
	int inservReview(Review review);

	// 댓글 삭제
	void deleteReview(int id);

	// 댓글 수정
	void updateReview(Review review);
}
