package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardGubunService;
import kr.or.ddit.board.service.BoardGubunServiceI;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	private MemberServiceI memberService;
	private BoardGubunServiceI boardGubunService;
	
	@Override
	public void init() throws ServletException {
		
		// service 객체 생성
		memberService = new MemberService();
		boardGubunService = new BoardGubunService();
	}
	
	
	/**
	 *  login 화면을 클라이언트에게 응답으로 생성
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("loginServlet doGet");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	
	}

	/**
	 *  login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		logger.debug("userId : {}, password : {} ", userId, password);

		MemberVo memberVo = memberService.getMember(userId);
		
		/*
		 * 일치할 경우
		 * → main페이지로 이동
		 * 
		 * 일치하지 않을 경우
		 * → login페이지로 이동
		 */
		
		// 디비에 등록된 회원이 없거나, 비밀번호가 틀린경우 (로그인 페이지)
		if(memberVo == null || !memberVo.getPass().equals(password)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		// 비밀번호가 일치하는 경우(메인 페이지로 이동)
		else if (memberVo.getPass().equals(password)) {
			request.getSession().setAttribute("S_MEMBER", memberVo);
			request.getSession().setAttribute("boardGubunList", boardGubunService.getBoardGubunList());
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		
	}

}
