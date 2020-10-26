package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.ReplyDao;
import kr.or.ddit.board.dao.ReplyDaoI;
import kr.or.ddit.board.model.ReplyVo;

public class ReplyService implements ReplyServiceI{

	private ReplyDaoI replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	
	@Override
	public int insertReply(ReplyVo replyVo) {
		return replyDao.insertReply(replyVo);
	}

	@Override
	public int deleteReply(int reply_sq) {
		return replyDao.deleteReply(reply_sq);
	}

}
