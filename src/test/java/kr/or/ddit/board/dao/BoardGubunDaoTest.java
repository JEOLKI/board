package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardGubunVo;
import kr.or.ddit.board.service.BoardGubunService;

public class BoardGubunDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardGubunDaoTest.class);
	
	BoardGubunDaoI boardGubunDao;
	BoardGubunVo boardGubunVo;
	
	@Before
	public void setup() {
		boardGubunDao = new BoardGubunDao();
		boardGubunVo = new BoardGubunVo("test", "n");
		boardGubunDao.deleteBoardGubun("test");
	}
	
	@After
	public void reset() {
		boardGubunVo = new BoardGubunVo(1,"자유게시판", "y");
		boardGubunDao.updateBoardGubun(boardGubunVo);
	}
	
	
	@Test
	public void getBoardGubunListTest() {
		/***Given***/
			
		/***When***/
		List<BoardGubunVo> boardGubunList = boardGubunDao.getBoardGubunList();

		/***Then***/
		assertEquals(3, boardGubunList.size());
	}

	@Test
	public void insertBoardGubunTest() {
		/***Given***/
		
		/***When***/
		int insertCnt = boardGubunDao.insertBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateBoardGubunTest() {
		/***Given***/
		boardGubunVo = new BoardGubunVo(1, "updateTest", "n");
		
		/***When***/
		int insertCnt = boardGubunDao.updateBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	

}
