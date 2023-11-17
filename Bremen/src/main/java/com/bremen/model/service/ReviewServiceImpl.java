package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bremen.model.dao.ReviewDao;
import com.bremen.model.dto.Review;

public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao dao;
	
	@Override
	public List<Review> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insertReview(Review review) {
		return dao.inservReview(review);
	}

	@Override
	public void deleteReview(int id) {
		dao.deleteReview(id);
	}

	@Override
	public void updateReview(Review review) {
		dao.updateReview(review);;
	}

}
