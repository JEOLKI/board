package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI {

	@Override
	public List<BoardVo> getBoardList(int gubun_sq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.getBoardList", gubun_sq);
		sqlSession.close();
		return boardList;
	}

	@Override
	public List<BoardVo> getBoardPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("board.getBoardPageList", pageVo);
	}

	@Override
	public int getBoardTotalCnt(SqlSession sqlSession, int gubun_sq) {
		return sqlSession.selectOne("board.getBoardTotalCnt", gubun_sq);
	}

	@Override
	public BoardVo getBoard(SqlSession sqlSession, int board_sq) {
		return sqlSession.selectOne("board.getBoard", board_sq);
	}

	@Override
	public List<AtchFileVo> getAtchFileList(SqlSession sqlSession, int board_sq) {
		return sqlSession.selectList("board.getAtchFileList", board_sq);
	}

	@Override
	public List<ReplyVo> getReplyList(SqlSession sqlSession, int board_sq) {
		return sqlSession.selectList("board.getReplyList", board_sq);
	}

	@Override
	public int deleteBoard(int board_sq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.update("board.deleteBoard", board_sq);
		} catch (Exception e) { }
		
		if (deleteCnt == 1) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return deleteCnt;
	}

	@Override
	public int updateBoard(BoardVo board) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
		try {
			updateCnt = sqlSession.update("board.updateBoard", board);
		} catch (Exception e) { }
		
		if (updateCnt == 1) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return updateCnt;
	}

	@Override
	public int deleteBoardForTest(String board_title) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.delete("board.deleteBoardForTest", board_title);
		} catch (Exception e) { }
		
		if (deleteCnt == 1) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return deleteCnt;
	}

}
