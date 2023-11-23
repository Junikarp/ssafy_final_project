package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bremen.model.dao.TradeDao;
import com.bremen.model.dto.Trade;

@Service
public class TradeServiceImpl implements TradeService{

	@Autowired
	TradeDao dao;
	
	@Override
	public List<Trade> selectAll(String category) {
		return dao.selectAll(category);
	}

	@Override
	public Trade selectOne(int id) {
		return dao.selectOne(id);
	}

	@Override
	public int insertTrade(Trade trade) {
		return dao.insertTrade(trade);
	}

	@Override
	public void deleteTrade(int id) {
		dao.deleteTrade(id);
	}

	@Override
	public void updateTrade(Trade trade) {
		dao.updateTrade(trade);
	}

	@Override
	public void updateViewCnt(int id) {
		dao.updateViewCnt(id);
	}

	@Override
	public List<Trade> search(String place) {
		return dao.search(place);
	}
}
