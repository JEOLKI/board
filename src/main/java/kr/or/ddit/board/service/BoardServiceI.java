package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;

public interface BoardServiceI {
	
	List<BoardVo> getBoardList(int gubun_sq);

	Map<String, Object> getBoardPageList(PageVo pageVo);

	Map<String, Object> getBoard(int board_sq);

	int deleteBoard(int board_sq);
}
