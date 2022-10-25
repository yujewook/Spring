package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

import java.util.*;

public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;
   
}