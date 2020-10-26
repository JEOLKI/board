package kr.or.ddit.board.service;

import kr.or.ddit.board.model.ReplyVo;

public interface ReplyServiceI {

	int insertReply(ReplyVo replyVo);

	int deleteReply(int reply_sq);

}
