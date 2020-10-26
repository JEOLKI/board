package kr.or.ddit.common.model;

public class PageVo {

	private int gubun_sq;
	private int page;
	private int pageSize;

	public PageVo() {

	}
	
	public PageVo(int gubun_sq, int page, int pageSize) {
		this.gubun_sq = gubun_sq;
		this.page = page;
		this.pageSize = pageSize;
	}



	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getGubun_sq() {
		return gubun_sq;
	}

	public void setGubun_sq(int gubun_sq) {
		this.gubun_sq = gubun_sq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gubun_sq;
		result = prime * result + page;
		result = prime * result + pageSize;
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
		PageVo other = (PageVo) obj;
		if (gubun_sq != other.gubun_sq)
			return false;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PageVo [gubun_sq=" + gubun_sq + ", page=" + page + ", pageSize=" + pageSize + "]";
	}

}
