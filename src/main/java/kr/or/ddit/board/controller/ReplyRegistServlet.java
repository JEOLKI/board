package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.service.ReplyService;
import kr.or.ddit.board.service.ReplyServiceI;

@WebServlet("/replyRegist")
public class ReplyRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyRegistServlet.class);
	
	private ReplyServiceI replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 받기
		int board_sq = Integer.parseInt(request.getParameter("board_sq"));
		String userid = request.getParameter("userid");
		String reply_content = request.getParameter("reply_content");
		
		logger.debug("reply_content : {}", reply_content);
		
		ReplyVo replyVo = new ReplyVo(reply_content, board_sq, userid);
		
		int insertCnt = replyService.insertReply(replyVo);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( insertCnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/board?board_sq=" + board_sq);
		} 
		// 1건이 아닐때 : 비정상
		else {
			
		}
	
	}

}
