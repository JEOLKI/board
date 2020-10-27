package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
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
import kr.or.ddit.common.model.PageVo;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(BoardListServlet.class);
	
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		
		boardService = new BoardService();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// board_gubun
		int gubun_sq = Integer.parseInt(request.getParameter("gubun_sq"));
		
		logger.debug("gubun_sq : {}", gubun_sq);
		
		// page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
				
		// pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 10 : Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
				
		// pageVo : page, pageSize
		PageVo pageVo = new PageVo(gubun_sq, page, pageSize);
				
		//memberService.selectMemberPageList(page) => List<MemberVo> => Map<String,Object>
		Map<String, Object> map = boardService.getBoardPageList(pageVo);
		
		request.setAttribute("cpage", page);
		request.setAttribute("pages", map.get("pages"));
		request.setAttribute("boardList", map.get("boardList"));
		request.setAttribute("gubun_sq", gubun_sq);
		
		logger.debug("{}",map.get("boardList"));
		
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
		
	}


}
