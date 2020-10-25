package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardGubunVo;

public class BoardGubunDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardGubunDaoTest.class);
	
	@Test
	public void getBoardGubunListTest() {
		/***Given***/
		BoardGubunDaoI boardGubunDao = new BoardGubunDao();
			
		/***When***/
		List<BoardGubunVo> boardGubunList = boardGubunDao.getBoardGubunList();

		/***Then***/
		assertEquals(3, boardGubunList.size());
	}

}
