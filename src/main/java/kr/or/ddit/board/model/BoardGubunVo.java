package kr.or.ddit.board.model;

public class BoardGubunVo {

	private int gubun_sq;
	private String gubun_nm;
	private String gubun_yn;
	
	public BoardGubunVo() {
	}

	public BoardGubunVo(String gubun_nm, String gubun_yn) {
		this.gubun_nm = gubun_nm;
		this.gubun_yn = gubun_yn;
	}

	public BoardGubunVo(int gubun_sq, String gubun_nm, String gubun_yn) {
		this.gubun_sq = gubun_sq;
		this.gubun_nm = gubun_nm;
		this.gubun_yn = gubun_yn;
	}

	public int getGubun_sq() {
		return gubun_sq;
	}

	public void setGubun_sq(int gubun_sq) {
		this.gubun_sq = gubun_sq;
	}

	public String getGubun_nm() {
		return gubun_nm;
	}

	public void setGubun_nm(String gubun_nm) {
		this.gubun_nm = gubun_nm;
	}

	public String getGubun_yn() {
		return gubun_yn;
	}

	public void setGubun_yn(String gubun_yn) {
		this.gubun_yn = gubun_yn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gubun_nm == null) ? 0 : gubun_nm.hashCode());
		result = prime * result + gubun_sq;
		result = prime * result + ((gubun_yn == null) ? 0 : gubun_yn.hashCode());
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
		BoardGubunVo other = (BoardGubunVo) obj;
		if (gubun_nm == null) {
			if (other.gubun_nm != null)
				return false;
		} else if (!gubun_nm.equals(other.gubun_nm))
			return false;
		if (gubun_sq != other.gubun_sq)
			return false;
		if (gubun_yn == null) {
			if (other.gubun_yn != null)
				return false;
		} else if (!gubun_yn.equals(other.gubun_yn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardGubunVo [gubun_sq=" + gubun_sq + ", gubun_nm=" + gubun_nm + ", gubun_yn=" + gubun_yn + "]";
	}

}
