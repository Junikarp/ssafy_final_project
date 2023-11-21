package com.bremen.controller;

import java.util.List;

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

import com.bremen.model.dto.Group;
import com.bremen.model.dto.Trade;
import com.bremen.model.service.TradeService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/tradeapi")
@CrossOrigin("*")
public class TradeRestController {

	@Autowired
	TradeService tradeService;

	// 예외 처리
	public ResponseEntity<?> exceptionHandler(Exception e) {
		String errMsg = "sorry : " + e.getMessage();
		return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 게시판 리스트
	@GetMapping("/trade/{category}")
	public ResponseEntity<?> getList(@PathVariable String category) {
		try {
			List<Trade> list = tradeService.selectAll(category);
			if (list == null || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 상세조회
	@GetMapping("/trade/detail/{id}")
	public ResponseEntity<?> getPost(@PathVariable int id) {
		try {
			Trade trade = tradeService.selectOne(id);
			
			if (trade == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(trade, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 생성	
	@PostMapping("/trade")
	public ResponseEntity<?> createPost(@RequestBody Trade trade) {
		try {
			int result = tradeService.insertTrade(trade);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 삭제
	@DeleteMapping("/trade/{id}")
	public ResponseEntity<?> deletePost(@PathVariable int id) {
		try {
			tradeService.deleteTrade(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 게시물 수정
	@PutMapping("/trade")
	public ResponseEntity<?> updatePost(@RequestBody Trade trade) {
		try {
			tradeService.updateTrade(trade);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	@ApiIgnore
	@ApiOperation(value = "조회수 증가")
	@PutMapping("/trade/{id}")
	public ResponseEntity<?> viewCnt(@PathVariable int id) {
		try {
			tradeService.updateViewCnt(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}
}
