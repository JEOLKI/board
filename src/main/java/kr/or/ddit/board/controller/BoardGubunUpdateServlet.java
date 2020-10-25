package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardGubunVo;
import kr.or.ddit.board.service.BoardGubunService;
import kr.or.ddit.board.service.BoardGubunServiceI;

@WebServlet("/boardGubunUpdate")
public class BoardGubunUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardGubunServiceI boardGubunService;
	
	@Override
	public void init() throws ServletException {
		boardGubunService = new BoardGubunService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gubun_sq = Integer.parseInt(request.getParameter("gubun_sq"));
		String gubun_nm = request.getParameter("gubun_nm");
		String gubun_yn = request.getParameter("gubun_yn").equals("사용")? "y" : "n" ;
		
		BoardGubunVo boardGubunVo = new BoardGubunVo(gubun_sq, gubun_nm, gubun_yn);
		
		int updateCnt = boardGubunService.updateBoardGubun(boardGubunVo);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( updateCnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/boardGubunRegist");
		} 
		// 1건이 아닐때 : 비정상
		else {
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		}
		
	}

}
