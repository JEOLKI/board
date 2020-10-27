package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/atchFileDelete")
public class AtchFileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int atch_sq = Integer.parseInt(request.getParameter("atch_sq"));
		int board_sq = Integer.parseInt(request.getParameter("board_sq"));
		
		int DeleteCnt = boardService.deleteAtchFile(atch_sq);
		
		request.getRequestDispatcher(request.getContextPath() + "/boardUpate?board_sq=" + board_sq).forward(request, response);
	
	}

}
