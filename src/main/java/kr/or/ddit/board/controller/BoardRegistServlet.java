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
import kr.or.ddit.fileUpload.FileUploadUtil;


@WebServlet("/boardRegist")
public class BoardRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardRegistServlet.class);
    
	private BoardServiceI boardService;
	String gubun_sq;
	String board_sq;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		gubun_sq = request.getParameter("gubun_sq");
		board_sq = request.getParameter("board_sq");
		
		request.getRequestDispatcher("/board/boardRegister.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String file1 = request.getParameter("file1");
		String file2 = request.getParameter("file2");
		String file3 = request.getParameter("file3");
		String file4 = request.getParameter("file4");
		String file5 = request.getParameter("file5");
		
		logger.debug("board_title : {}", board_title);
		logger.debug("board_content : {}",board_content);
		logger.debug(file1);
		logger.debug(file2);
		logger.debug(file3);
		logger.debug(file4);
		logger.debug(file5);
		
		String filename = FileUploadUtil.getFilename(file1);
		
		logger.debug(filename);
		
		
		
		/*
		 * String board_title = request.getParameter("board_title"); String editordata =
		 * request.getParameter("editordata"); String[] a =
		 * request.getParameterValues(editordata);
		 * 
		 * 
		 * logger.debug("a : {}", a); logger.debug("content : {}", editordata);
		 * 
		 * Part file = request.getPart("files");
		 * 
		 * logger.debug("file : {}",file.getHeaderNames());
		 * logger.debug("file : {}",file.getHeaders("Content-Disposition"));
		 * 
		 * String realFilename =
		 * FileUploadUtil.getFilename(file.getHeader("Content-Disposition"));
		 * 
		 * logger.debug("{} ", realFilename);
		 * 
		 * 
		 * String filename = UUID.randomUUID().toString();
		 * 
		 * request.getRequestDispatcher("/board/boardRegister.jsp").forward(request,
		 * response);
		 */
	}

}
