package kr.or.ddit.board.model;

import java.util.Date;

public class ReplyVo {

	private int reply_sq;
	private String reply_content;
	private Date reply_date;
	private String reply_yn;
	private int board_sq;
	private String userid;
	
	public ReplyVo() {
		
	}
	
	public ReplyVo(String reply_content, int board_sq, String userid) {
		this.reply_content = reply_content;
		this.board_sq = board_sq;
		this.userid = userid;
	}



	public int getReply_sq() {
		return reply_sq;
	}

	public void setReply_sq(int reply_sq) {
		this.reply_sq = reply_sq;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply_yn() {
		return reply_yn;
	}

	public void setReply_yn(String reply_yn) {
		this.reply_yn = reply_yn;
	}

	public int getBoard_sq() {
		return board_sq;
	}

	public void setBoard_sq(int board_sq) {
		this.board_sq = board_sq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_sq;
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + ((reply_date == null) ? 0 : reply_date.hashCode());
		result = prime * result + reply_sq;
		result = prime * result + ((reply_yn == null) ? 0 : reply_yn.hashCode());
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
		ReplyVo other = (ReplyVo) obj;
		if (board_sq != other.board_sq)
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_date == null) {
			if (other.reply_date != null)
				return false;
		} else if (!reply_date.equals(other.reply_date))
			return false;
		if (reply_sq != other.reply_sq)
			return false;
		if (reply_yn == null) {
			if (other.reply_yn != null)
				return false;
		} else if (!reply_yn.equals(other.reply_yn))
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
		return "ReplyVo [reply_sq=" + reply_sq + ", reply_content=" + reply_content + ", reply_date=" + reply_date
				+ ", reply_yn=" + reply_yn + ", board_sq=" + board_sq + ", userid=" + userid + "]";
	}

}
