package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardService implements BoardServiceI {

	private BoardDaoI boardDao;

	public BoardService() {
		boardDao = new BoardDao();
	
	}

	@Override
	public List<BoardVo> getBoardList(int gubun_sq) {
		return boardDao.getBoardList(gubun_sq);
	}

	@Override
	public Map<String, Object> getBoardPageList(PageVo pageVo) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardVo> boardList = boardDao.getBoardPageList(sqlSession, pageVo);
		
		for(BoardVo board :boardList) {
			if(board.getBoard_title().contains(("→"))){
				board.setBoard_title(board.getBoard_title().replaceAll("1", "&nbsp;"));
			}
		}
		
		map.put("boardList", boardDao.getBoardPageList(sqlSession, pageVo));
		
		// 15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 =2.14.. 올림을 하여 3개의 페이지가 필요
		int totalCnt = boardDao.getBoardTotalCnt(sqlSession, pageVo.getGubun_sq());
		int pageSize = pageVo.getPageSize();
		int pages = (int) Math.ceil( (double)totalCnt/pageSize);
		map.put("pages", pages);
		
		sqlSession.close();
		
		return map;
		
	}

	@Override
	public Map<String, Object> getBoard(int board_sq) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardVo", boardDao.getBoard(sqlSession, board_sq));
		map.put("atchFileList", boardDao.getAtchFileList(sqlSession,board_sq));
		map.put("replyList", boardDao.getReplyList(sqlSession, board_sq));
		
		sqlSession.close();
		
		return map;
	}

	@Override
	public int deleteBoard(int board_sq) {
		return boardDao.deleteBoard(board_sq);
	}

	@Override
	public int insertBoard(Map<String, Object> map) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int boardCurSq = 0;
		BoardVo boardVo = (BoardVo) map.get("boardVo");
		if ( boardVo.getBoard_p_sq() == 0) {
			boardCurSq = boardDao.insertBoard(sqlSession,(BoardVo)map.get("boardVo"));
		} else {
			boardCurSq = boardDao.insertBoardChild(sqlSession,(BoardVo)map.get("boardVo"));
		}
		
		List<AtchFileVo> atchFileList = (List<AtchFileVo>) map.get("atchFileList");
		
		if(atchFileList == null) return boardCurSq;
		
		
		int insertCnt = 0;
		for(AtchFileVo atchfileVo : atchFileList) {
			atchfileVo.setBoard_sq(boardCurSq);
			insertCnt += boardDao.insertAtchFile(sqlSession, atchfileVo);
		}
		
		if( insertCnt == atchFileList.size() ) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return boardCurSq;
	}

	@Override
	public AtchFileVo getAtchFile(int atch_sq) {
		return boardDao.getAtchFile(atch_sq);
	}

	@Override
	public int deleteAtchFile(int atch_sq) {
		return boardDao.deleteAtchFile(atch_sq);
	}

	@Override
	public int updateBoard(Map<String, Object> map) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		BoardVo boardVo = (BoardVo) map.get("boardVo");
		
		int updateCnt = boardDao.updateBoard(sqlSession,boardVo);
		
		String[] deleteAtchSq = (String[]) map.get("deleteAtchSq");
		
		if(deleteAtchSq != null) {
			
			for(String atch_sq : deleteAtchSq) {
				boardDao.deleteAtchFile(Integer.parseInt(atch_sq));
			}
		}
		
		List<AtchFileVo> atchFileList = (List<AtchFileVo>) map.get("atchFileList");
		
		int insertCnt = 0;
		for(AtchFileVo atchfileVo : atchFileList) {
			atchfileVo.setBoard_sq(boardVo.getBoard_sq());
			insertCnt += boardDao.insertAtchFile(sqlSession, atchfileVo);
		}
		
		if( updateCnt == 1 || insertCnt == atchFileList.size() ) sqlSession.commit();
		else sqlSession.rollback();
		
		sqlSession.close();
		
		return boardVo.getBoard_sq();
	}

}
