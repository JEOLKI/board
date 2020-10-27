package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {

	private int rn;
	private int board_sq;
	private String board_title;
	private String board_content;
	private Date board_date;
	private String board_yn;
	private String userid;
	private int board_p_sq;
	private int gubun_sq;
	private int group_no;

	public BoardVo() {

	}
	
	public BoardVo(String board_title, String board_content, String userid, int gubun_sq) {
		super();
		this.board_title = board_title;
		this.board_content = board_content;
		this.userid = userid;
		this.gubun_sq = gubun_sq;
	}



	public BoardVo(String board_title, String board_content, String userid, int board_p_sq, int gubun_sq, int group_no) {
		this.board_title = board_title;
		this.board_content = board_content;
		this.userid = userid;
		this.board_p_sq = board_p_sq;
		this.gubun_sq = gubun_sq;
		this.group_no = group_no;
	}



	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public int getBoard_sq() {
		return board_sq;
	}

	public void setBoard_sq(int board_sq) {
		this.board_sq = board_sq;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getBoard_yn() {
		return board_yn;
	}

	public void setBoard_yn(String board_yn) {
		this.board_yn = board_yn;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getBoard_p_sq() {
		return board_p_sq;
	}

	public void setBoard_p_sq(int board_p_sq) {
		this.board_p_sq = board_p_sq;
	}

	public int getGubun_sq() {
		return gubun_sq;
	}

	public void setGubun_sq(int gubun_sq) {
		this.gubun_sq = gubun_sq;
	}

	public int getGroup_no() {
		return group_no;
	}

	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_content == null) ? 0 : board_content.hashCode());
		result = prime * result + ((board_date == null) ? 0 : board_date.hashCode());
		result = prime * result + board_p_sq;
		result = prime * result + board_sq;
		result = prime * result + ((board_title == null) ? 0 : board_title.hashCode());
		result = prime * result + ((board_yn == null) ? 0 : board_yn.hashCode());
		result = prime * result + group_no;
		result = prime * result + gubun_sq;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVo other = (BoardVo) obj;
		if (board_content == null) {
			if (other.board_content != null)
				return false;
		} else if (!board_content.equals(other.board_content))
			return false;
		if (board_date == null) {
			if (other.board_date != null)
				return false;
		} else if (!board_date.equals(other.board_date))
			return false;
		if (board_p_sq != other.board_p_sq)
			return false;
		if (board_sq != other.board_sq)
			return false;
		if (board_title == null) {
			if (other.board_title != null)
				return false;
		} else if (!board_title.equals(other.board_title))
			return false;
		if (board_yn == null) {
			if (other.board_yn != null)
				return false;
		} else if (!board_yn.equals(other.board_yn))
			return false;
		if (group_no != other.group_no)
			return false;
		if (gubun_sq != other.gubun_sq)
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardVo [board_sq=" + board_sq + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_date=" + board_date + ", board_yn=" + board_yn + ", userid=" + userid + ", board_p_sq="
				+ board_p_sq + ", gubun_sq=" + gubun_sq + ", group_no=" + group_no + "]";
	}

}
