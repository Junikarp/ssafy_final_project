package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bremen.model.dao.BoardDao;
import com.bremen.model.dto.Board;

@Service
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

	@Transactional
	@Override
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}

	@Transactional
	@Override
	public void deleteBoard(int id) {
		dao.deleteBoard(id);
	}

	@Transactional
	@Override
	public void updateBoard(Board board) {
		dao.updateBoard(board);
	}

	@Transactional
	@Override
	public void updateViewCnt(int id) {
		dao.updateViewCnt(id);
	}
	
	
}
