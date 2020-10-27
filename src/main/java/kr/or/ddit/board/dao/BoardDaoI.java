package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.common.model.PageVo;


public interface BoardDaoI {
	
	List<BoardVo> getBoardList(int gubun_sq);
	
	List<BoardVo> getBoardPageList(SqlSession sqlSession, PageVo pageVo);

	int getBoardTotalCnt(SqlSession sqlSession, int gubun_sq);

	BoardVo getBoard(SqlSession sqlSession, int board_sq);

	List<AtchFileVo> getAtchFileList(SqlSession sqlSession, int board_sq);

	List<ReplyVo> getReplyList(SqlSession sqlSession, int board_sq);
	
	int deleteBoard(int board_sq);
	
	
	int deleteBoardForTest(String board_title);

	int insertBoard(SqlSession sqlSession, BoardVo boardVo);

	int insertAtchFile(SqlSession sqlSession, AtchFileVo atchfileVo);

	int insertBoardChild(SqlSession sqlSession, BoardVo boardVo);

	AtchFileVo getAtchFile(int atch_sq);

	int deleteAtchFile(int atch_sq);

	int updateBoard(SqlSession sqlSession, BoardVo boardVo);
}
