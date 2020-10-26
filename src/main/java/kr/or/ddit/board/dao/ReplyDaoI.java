package kr.or.ddit.board.dao;

import kr.or.ddit.board.model.ReplyVo;

public interface ReplyDaoI {
	
	int insertReply(ReplyVo replyVo);
	
	int deleteReply(int reply_sq);
}
