package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardGubunVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardGubunDao implements BoardGubunDaoI {

	@Override
	public List<BoardGubunVo> getBoardGubunList() {

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<BoardGubunVo> boardGubunList = sqlSession.selectList("board.getBoardGubunList");
		
		sqlSession.close();
		
		return boardGubunList;
	}

	@Override
	public int insertBoardGubun(BoardGubunVo boardGubunVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("board.insertBoardGubun", boardGubunVo);
		} catch (Exception e) { }

		if (insertCnt == 1) sqlSession.commit();
		else sqlSession.rollback();

		sqlSession.close();

		return insertCnt;
	}
	
	@Override
	public int updateBoardGubun(BoardGubunVo boardGubunVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.update("board.updateBoardGubun", boardGubunVo);
		} catch (Exception e) { }
		
		if (insertCnt == 1) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteBoardGubun(String gubun_nm) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.delete("board.deleteBoardGubunForTest", gubun_nm);
		} catch (Exception e) { }
		
		if (deleteCnt == 1) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return deleteCnt;
	}
	

}
