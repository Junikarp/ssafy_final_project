package com.bremen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bremen.model.dto.Board;
import com.bremen.model.dto.Review;
import com.bremen.model.service.BoardService;
import com.bremen.model.service.ReviewService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BoardRestController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	ReviewService reviewService;

	// 예외 처리
	public ResponseEntity<?> exceptionHandler(Exception e) {
		String errMsg = "sorry : " + e.getMessage();
		return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 게시판 리스트
	@GetMapping("/board/{category}")
	public ResponseEntity<?> getList(@PathVariable String category) {
		try {
			List<Board> list = boardService.selectAll(category);
			if (list == null || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				for(Board board : list) {
					List<Review> reviews = reviewService.selectAll(board.getBoardId());
					board.setReviewList(reviews);
				}
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 상세조회
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getPost(@PathVariable int id) {
		try {
			Board board = boardService.selectOne(id);
			List<Review> reviews = reviewService.selectAll(id);

			board.setReviewList(reviews);
			
			if (board == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(board, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 생성	
	@PostMapping("/board")
	public ResponseEntity<?> createPost(@RequestBody Board board) {
		try {
			int result = boardService.insertBoard(board);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<?> deletePost(@PathVariable int id) {
		try {
			boardService.deleteBoard(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 수정
	@PutMapping("/board")
	public ResponseEntity<?> updatePost(@RequestBody Board board) {
		try {
			boardService.updateBoard(board);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	@ApiIgnore
	@ApiOperation(value = "조회수 증가")
	@PutMapping("/board/{id}")
	public ResponseEntity<?> viewCnt(@PathVariable int id) {
		try {
			boardService.updateViewCnt(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}
	
	@PostMapping("/review")
	public ResponseEntity<?> insertReview(@RequestBody Review review) {
		try {
			int result = reviewService.insertReview(review);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<?> deleteReview(@RequestBody @PathVariable int id) {
		try {
			reviewService.deleteReview(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}
	
	@PutMapping("/review")
	public ResponseEntity<?> updateReview(@RequestBody Review review) {
		try {
			reviewService.updateReview(review);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

}
