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

@WebServlet("/boardUpdate")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
	
	private BoardServiceI boardService;
	private BoardVo boardVo;
	private List<AtchFileVo> atchFileList;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_sq = Integer.parseInt(request.getParameter("board_sq"));
		Map<String, Object> map = boardService.getBoard(board_sq);
		boardVo = (BoardVo) map.get("boardVo");
		atchFileList = (List<AtchFileVo>) map.get("atchFileList");
		
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("atchFileList", atchFileList);
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String board_title = request.getParameter("board_title");
		String editordata = request.getParameter("editordata");
		
		logger.debug("editordata : {}", editordata);
		
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_content(editordata);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardVo", boardVo);
		
		String[] deleteAtchSq = request.getParameterValues("deletefile") == null? null : request.getParameterValues("deletefile");
		
		map.put("deleteAtchSq", deleteAtchSq);
		
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
		
		int boardCurSq = boardService.updateBoard(map);
		
		response.sendRedirect("/board?board_sq="+boardCurSq);
		
		
		
	}

}
