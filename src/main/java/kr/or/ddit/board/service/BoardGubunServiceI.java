package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardGubunVo;

public interface BoardGubunServiceI {
	
	List<BoardGubunVo> getBoardGubunList();

	int insertBoardGubun(BoardGubunVo boardGubunVo);
	
	int updateBoardGubun(BoardGubunVo boardGubunVo);
	
	int deleteBoardGubun(String gubun_nm);
	
}
