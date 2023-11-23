package com.bremen.model.dao;

import java.util.List;

import com.bremen.model.dto.Trade;
import com.ssafy.ws.model.dto.Movie;

public interface TradeDao {
		// 전체 목록
		List<Trade> selectAll(String category);
		
		// 상세 조회
		Trade selectOne(int id);
		
		// 게시글 등록
		int insertTrade(Trade trade);
		
		// 게시글 삭제 
		void deleteTrade(int id);
		
		// 게시글 수정 
		void updateTrade(Trade trade);
		
		// 조회수 증가 
		void updateViewCnt(int id);
		
		// 지역 검색
		List<Trade> search(String place);
}
