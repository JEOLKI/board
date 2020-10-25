package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.BoardGubunVo;

public class BoardGubunServiceTest {
	
	BoardGubunServiceI boardGubunService;
	
	@Before
	public void setup() {
		boardGubunService = new BoardGubunService();
	}
	

	@Test
	public void getBoardGubunListTest() {
		/***Given***/
		boardGubunService = new BoardGubunService();
			
		/***When***/
		List<BoardGubunVo> boardGubunList = boardGubunService.getBoardGubunList();

		/***Then***/
		assertEquals(3, boardGubunList.size());
	}

	
}
