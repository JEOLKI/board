package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;


public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardGubunDaoTest.class);
	
	BoardDaoI boardDao;
	BoardVo boardVo;
	
	SqlSession sqlSession;
	
	@Before
	public void setup() {
		boardDao = new BoardDao();
		boardVo = new BoardVo();
		sqlSession = MybatisUtil.getSqlSession();
	}
	
	@After
	public void reset() {
		sqlSession.close();
		String board_title = "test";
		boardDao.deleteBoardForTest(board_title);
		boardVo.setBoard_yn("y");
		boardDao.updateBoard(boardVo);
	}
	
	@Test
	public void getBoardListTest() {
		
		/***Given***/
		int gubun_sq = 1;
		
		/***When***/
		List<BoardVo> boardList = boardDao.getBoardList(gubun_sq);

		/***Then***/
		assertEquals(10, boardList.size());
		
	}
	
	@Test
	public void getBoardPageListTest() {
		
		/***Given***/
		PageVo pageVo = new PageVo(1, 1, 5);
		
		/***When***/
		List<BoardVo> boardList = boardDao.getBoardPageList(sqlSession, pageVo);
		
		/***Then***/
		assertEquals(5, boardList.size());
		
	}
	
	@Test
	public void getBoardTotalCntTest() {
		
		/***Given***/
		int gubun_sq = 1;
		
		/***When***/
		int totalCnt= boardDao.getBoardTotalCnt(sqlSession, gubun_sq);
		
		/***Then***/
		assertEquals(5, totalCnt);
		
	}

	@Test
	public void getBoardTest() {
		
		/***Given***/
		int board_sq = 1;
		
		/***When***/
		BoardVo boardVo= boardDao.getBoard(sqlSession, board_sq);
		
		/***Then***/
		assertEquals(board_sq, boardVo.getBoard_sq());
		
	}
	
	@Test
	public void getAtchFileListTest() {
		
		/***Given***/
		int board_sq = 5;
		
		/***When***/
		List<AtchFileVo> atchFileList= boardDao.getAtchFileList(sqlSession, board_sq);
		
		/***Then***/
		assertEquals(2, atchFileList.size());
		
	}
	
	@Test
	public void getReplyListTest() {
		
		/***Given***/
		int board_sq = 5;
		
		/***When***/
		List<ReplyVo> replyList= boardDao.getReplyList(sqlSession, board_sq);
		
		/***Then***/
		assertEquals(5, replyList.size());
		
	}
	
	@Test
	public void deleteBoardTest() {
		
		/***Given***/
		int board_sq = 8;
		
		/***When***/
		int deleteCnt= boardDao.deleteBoard(board_sq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	
}
