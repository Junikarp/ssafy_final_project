package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bremen.model.dao.BoardDao;
import com.bremen.model.dto.Board;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;

	@Override
	public List<Board> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Board selectOne(int id) {
		return dao.selectOne(id);
	}

	@Override
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}

	@Override
	public void deleteBoard(int id) {
		dao.deleteBoard(id);
	}

	@Override
	public void updateBoard(Board board) {
		dao.updateBoard(board);
	}

	@Override
	public void updateViewCnt(int id) {
		dao.updateViewCnt(id);
	}
	
	
}
