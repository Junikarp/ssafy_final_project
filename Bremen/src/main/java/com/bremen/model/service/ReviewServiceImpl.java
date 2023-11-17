package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bremen.model.dao.ReviewDao;
import com.bremen.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao dao;
	
	@Override
	public List<Review> selectAll() {
		return dao.selectAll();
	}

	@Transactional
	@Override
	public int insertReview(Review review) {
		return dao.inservReview(review);
	}

	@Transactional
	@Override
	public void deleteReview(int id) {
		dao.deleteReview(id);
	}

	@Transactional
	@Override
	public void updateReview(Review review) {
		dao.updateReview(review);;
	}

}
