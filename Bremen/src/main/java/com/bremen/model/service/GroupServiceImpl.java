package com.bremen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bremen.model.dao.GroupDao;
import com.bremen.model.dto.Group;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDao dao;

	@Override
	public List<Group> selectAll(String category) {
		return dao.selectAll(category);
	}

	@Override
	public Group selectOne(int id) {
		return dao.selectOne(id);
	}

	@Transactional
	@Override
	public int insertGroup(Group group) {
		return dao.insertGroup(group);
	}

	@Transactional
	@Override
	public void deleteGroup(int id) {
		dao.deleteGroup(id);
	}

	@Transactional
	@Override
	public void updateGroup(Group group) {
		dao.updateGroup(group);
	}

	@Transactional
	@Override
	public void updateViewCnt(int id) {
		dao.updateViewCnt(id);
	}

}
