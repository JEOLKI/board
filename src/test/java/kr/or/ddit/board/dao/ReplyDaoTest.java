package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.db.MybatisUtil;

public class ReplyDaoTest {
	
	ReplyDaoI replyDao;
	ReplyVo replyVo;
	
	SqlSession sqlSession;
	
	@Before
	public void setup() {
		replyDao = new ReplyDao();
		replyVo = new ReplyVo();
		sqlSession = MybatisUtil.getSqlSession();
	}
	
	@After
	public void reset() {
		sqlSession.close();
	}
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		replyVo = new ReplyVo("reply_content", 1, "brown");
		
		/***When***/
		int insertCnt = replyDao.insertReply(replyVo);

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void deleteReplyTest() {
		
		/***Given***/
		

		/***When***/
		int updateCnt = replyDao.deleteReply(1);

		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
}
