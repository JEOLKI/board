package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardGubunVo;
import kr.or.ddit.board.service.BoardGubunService;
import kr.or.ddit.board.service.BoardGubunServiceI;

@WebServlet("/boardGubunRegist")
public class BoardGubunRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardGubunRegistServlet.class);
	
	private BoardGubunServiceI boardGubunService;
	
	@Override
	public void init() throws ServletException {
		boardGubunService = new BoardGubunService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("boardGubunList", boardGubunService.getBoardGubunList());
		request.getRequestDispatcher("/board/boardGubunRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gubun_nm = request.getParameter("gubun_nm");
		String gubun_yn = request.getParameter("gubun_yn").equals("사용")? "y" : "n" ;
		
		BoardGubunVo boardGubunVo = new BoardGubunVo(gubun_nm, gubun_yn);
		
		int insertCnt = boardGubunService.insertBoardGubun(boardGubunVo);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( insertCnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/boardGubunRegist");
		} 
		// 1건이 아닐때 : 비정상
		else {
			doGet(request, response);
		}
	
	}

}
