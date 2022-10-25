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
 

}