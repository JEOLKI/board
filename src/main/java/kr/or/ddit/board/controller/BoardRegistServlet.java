package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.fileUpload.FileUploadUtil;


@WebServlet("/boardRegist")
@MultipartConfig
public class BoardRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardRegistServlet.class);
    
	private BoardServiceI boardService;
	
	private int gubun_sq;
	private String userid;
	private BoardVo boardVo;
	private int group_no;
	private int board_p_sq;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		gubun_sq = Integer.parseInt(request.getParameter("gubun_sq"));
		userid = request.getParameter("userid");
		group_no = request.getParameter("group_no") == null? 0 : Integer.parseInt(request.getParameter("group_no")); 
		board_p_sq = request.getParameter("board_sq") == null? 0 : Integer.parseInt(request.getParameter("board_sq")); 
		
		request.getRequestDispatcher("/board/boardRegister.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String board_title = request.getParameter("board_title");
		String editordata = request.getParameter("editordata");
		
		logger.debug("editordata : {}", editordata);
		
		if(group_no == 0) {
			boardVo = new BoardVo(board_title, editordata, userid, gubun_sq);
		}else {
			boardVo = new BoardVo(board_title, editordata, userid, board_p_sq, gubun_sq, group_no);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardVo", boardVo);
		
		List<Part> fileList = new ArrayList<Part>();
		fileList.add(request.getPart("file1"));
		fileList.add(request.getPart("file2"));
		fileList.add(request.getPart("file3"));
		fileList.add(request.getPart("file4"));
		fileList.add(request.getPart("file5"));
		
		AtchFileVo atchFileVo;
		List<AtchFileVo> atchFileList = new ArrayList<AtchFileVo>();
		
		for (Part file : fileList) {
			
			if(file != null) {
				if(file.getSize() > 0) {
					String fileName = FileUploadUtil.getFilename(file.getHeader("Content-Disposition"));
					String filePath = "D:\\attachment\\" + UUID.randomUUID().toString() +"."+ FileUploadUtil.getExtension(fileName);
					atchFileVo = new AtchFileVo( filePath , fileName);
					atchFileList.add(atchFileVo);
					file.write(filePath);
				}
			}
		}
		
		logger.debug("atchFileList : {}", atchFileList);
		
		map.put("atchFileList", atchFileList);
		
		int boardCurSq = boardService.insertBoard(map);
		
		response.sendRedirect("/board?board_sq="+boardCurSq);
		 
	}

}
