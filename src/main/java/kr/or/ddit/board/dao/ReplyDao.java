package kr.or.ddit.board.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.db.MybatisUtil;

public class ReplyDao implements ReplyDaoI {

	@Override
	public int insertReply(ReplyVo replyVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("board.insertReply", replyVo);
		} catch (Exception e) { }

		if (insertCnt == 1) sqlSession.commit();
		else sqlSession.rollback();

		sqlSession.close();

		return insertCnt;
	}

	@Override
	public int deleteReply(int reply_sq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.insert("board.deleteReply", reply_sq);
		} catch (Exception e) { }

		if (deleteCnt == 1) sqlSession.commit();
		else sqlSession.rollback();

		sqlSession.close();

		return deleteCnt;
	}
	
}
