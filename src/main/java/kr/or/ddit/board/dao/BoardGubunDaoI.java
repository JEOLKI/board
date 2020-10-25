package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardGubunVo;

public interface BoardGubunDaoI {
	
	List<BoardGubunVo> getBoardGubunList();
	
	int insertBoardGubun(BoardGubunVo boardGubunVo);
	
	int updateBoardGubun(BoardGubunVo boardGubunVo);
	
	int deleteBoardGubun(String gubun_nm);
}
