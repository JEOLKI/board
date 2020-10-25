package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardGubunDao;
import kr.or.ddit.board.dao.BoardGubunDaoI;
import kr.or.ddit.board.model.BoardGubunVo;

public class BoardGubunService implements BoardGubunServiceI{
	
	private BoardGubunDaoI boardGubunDao;
	
	public BoardGubunService() {
		boardGubunDao = new BoardGubunDao();
	
	}

	@Override
	public List<BoardGubunVo> getBoardGubunList() {
		return boardGubunDao.getBoardGubunList();
	}

	@Override
	public int insertBoardGubun(BoardGubunVo boardGubunVo) {
		return boardGubunDao.insertBoardGubun(boardGubunVo);
	}

}
