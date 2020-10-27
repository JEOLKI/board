package kr.or.ddit.fileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVo;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtchFileVo atchFileVo;
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		atchFileVo = new AtchFileVo();
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int atch_sq = Integer.parseInt(request.getParameter("atch_sq"));
		
		atchFileVo = boardService.getAtchFile(atch_sq);
		
		//response content-type
		response.setHeader("Content-Disposition", "attachment; filename=\""+ atchFileVo.getAtch_filename() + "\"");
		response.setContentType("application/octet-stream");
		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		FileInputStream fis = new FileInputStream(atchFileVo.getAtch_filepath());
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}
	
		fis.close();
		sos.flush();
		sos.close();
	}


}
