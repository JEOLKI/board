package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(BoardServlet.class);
	
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 받기
		int board_sq = Integer.parseInt(request.getParameter("board_sq"));
		
		Map<String, Object> map = boardService.getBoard(board_sq);
		
		request.setAttribute("boardVo", map.get("boardVo"));
		request.setAttribute("atchFileList", map.get("atchFileList"));
		request.setAttribute("replyList", map.get("replyList"));
		
		logger.debug("board : {}" , map.get("board") );
		logger.debug("atchFileList : {}" , map.get("atchFileList") );
		logger.debug("replyList : {}" , map.get("replyList") );
		
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
		
	}


}
