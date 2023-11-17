package com.bremen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bremen.model.dto.Review;
import com.bremen.model.service.ReviewService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ReviewRestController {

	@Autowired
	ReviewService reviewService;

	// 예외 처리
	public ResponseEntity<?> exceptionHandler(Exception e) {
		String errMsg = "sorry : " + e.getMessage();
		return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/review/{postId}")
	public ResponseEntity<?> insertReview(@PathVariable int postId, @RequestBody Review review) {
		try {
			int result = reviewService.insertReview(review);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}


	public void deleteReview(int id) {
	}

//	public void updateReview(@RequestBody Review review) {
//		try {
//			reviewService.updateReview(review);
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandler(e);
//		}
//	}

}
