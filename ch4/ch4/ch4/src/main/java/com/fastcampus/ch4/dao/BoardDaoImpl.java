package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;
import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.dao.BoardMapper.";

    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)

	@Override
	public BoardDto select(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer bno, String writer) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int increaseViewCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDto> selectPage(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	



}