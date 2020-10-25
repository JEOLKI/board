package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.BoardGubunVo;

public class BoardGubunServiceTest {
	
	BoardGubunServiceI boardGubunService;
	BoardGubunVo boardGubunVo;
	
	@Before
	public void setup() {
		boardGubunService = new BoardGubunService();
		boardGubunVo = new BoardGubunVo("test", "n");
		boardGubunService.deleteBoardGubun("test");
	}
	
	@After
	public void reset() {
		boardGubunVo = new BoardGubunVo(1,"자유게시판", "y");
		boardGubunService.updateBoardGubun(boardGubunVo);
	}
	
	@Test
	public void getBoardGubunListTest() {
		/***Given***/
			
		/***When***/
		List<BoardGubunVo> boardGubunList = boardGubunService.getBoardGubunList();

		/***Then***/
		assertEquals(3, boardGubunList.size());
	}

	@Test
	public void insertBoardGubunTest() {
		/***Given***/
		
		/***When***/
		int insertCnt = boardGubunService.insertBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateBoardGubunTest() {
		/***Given***/
		boardGubunVo = new BoardGubunVo(1, "updateTest", "n");
		
		/***When***/
		int insertCnt = boardGubunService.updateBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
}
