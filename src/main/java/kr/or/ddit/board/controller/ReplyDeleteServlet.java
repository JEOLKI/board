package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.ReplyService;
import kr.or.ddit.board.service.ReplyServiceI;

@WebServlet("/replyDelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReplyServiceI replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 받기
		int reply_sq = Integer.parseInt(request.getParameter("reply_sq"));
		int board_sq = Integer.parseInt(request.getParameter("board_sq"));
		
		int deleteCnt = replyService.deleteReply(reply_sq);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( deleteCnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/board?board_sq=" + board_sq);
		} 
		// 1건이 아닐때 : 비정상
		else {
			
		}
		
	}


}
