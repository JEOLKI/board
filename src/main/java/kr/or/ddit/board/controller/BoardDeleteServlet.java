package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(BoardListServlet.class);
	
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 파라미터 받기
		int board_sq = Integer.parseInt(request.getParameter("board_sq"));
		int gubun_sq = Integer.parseInt(request.getParameter("gubun_sq"));
		String gubun_nm = request.getParameter("gubun_nm");
		
		int deleteCnt = boardService.deleteBoard(board_sq);
	
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( deleteCnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/boardList?gubun_sq=" + gubun_sq + "&gubun_nm=" + gubun_nm);
		} 
		// 1건이 아닐때 : 비정상
		else {
			
		}
	
	}


}
