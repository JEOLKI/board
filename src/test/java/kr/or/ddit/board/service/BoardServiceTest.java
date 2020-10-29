package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;

public class BoardServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	BoardServiceI boardService;
	BoardVo boardVo;

	@Before
	public void setup() {
		boardService = new BoardService();
		boardVo = new BoardVo();
	}

	@After
	public void reset() {

	}

	@Test
	public void getBoardListTest() {

		/*** Given ***/
		int gubun_sq = 1;

		/*** When ***/
		List<BoardVo> boardList = boardService.getBoardList(gubun_sq);

		/*** Then ***/
		assertEquals(10, boardList.size());
	}

	@Test
	public void getBoardPageListTest() {

		/*** Given ***/
		PageVo pageVo = new PageVo(1, 1, 5);

		/*** When ***/
		Map<String, Object> map = boardService.getBoardPageList(pageVo);

		/*** Then ***/
		assertEquals(5, ((List<BoardVo>) map.get("boardList")).size());
	}

	@Test
	public void getBoardTest() {

		/*** Given ***/
		int board_sq = 1;

		/*** When ***/
		Map<String, Object> map = boardService.getBoard(board_sq);

		/*** Then ***/
		assertEquals(board_sq, ((BoardVo) map.get("boardVo")).getBoard_sq());

	}
	
	@Test
	public void deleteBoardTest() {
		
		/***Given***/
		int board_sq = 8;
		
		/***When***/
		int deleteCnt= boardService.deleteBoard(board_sq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	
	
}
