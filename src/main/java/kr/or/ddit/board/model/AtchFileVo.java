package kr.or.ddit.board.model;

public class AtchFileVo {

	private int atch_sq;
	private String atch_filepath;
	private String atch_filename;
	private int board_sq;

	public AtchFileVo() {

	}

	public AtchFileVo(String atch_filepath, String atch_filename) {
		super();
		this.atch_filepath = atch_filepath;
		this.atch_filename = atch_filename;
	}

	public int getAtch_sq() {
		return atch_sq;
	}

	public void setAtch_sq(int atch_sq) {
		this.atch_sq = atch_sq;
	}

	public String getAtch_filepath() {
		return atch_filepath;
	}

	public void setAtch_filepath(String atch_filepath) {
		this.atch_filepath = atch_filepath;
	}

	public String getAtch_filename() {
		return atch_filename;
	}

	public void setAtch_filename(String atch_filename) {
		this.atch_filename = atch_filename;
	}

	public int getBoard_sq() {
		return board_sq;
	}

	public void setBoard_sq(int board_sq) {
		this.board_sq = board_sq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atch_filename == null) ? 0 : atch_filename.hashCode());
		result = prime * result + ((atch_filepath == null) ? 0 : atch_filepath.hashCode());
		result = prime * result + atch_sq;
		result = prime * result + board_sq;
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
		AtchFileVo other = (AtchFileVo) obj;
		if (atch_filename == null) {
			if (other.atch_filename != null)
				return false;
		} else if (!atch_filename.equals(other.atch_filename))
			return false;
		if (atch_filepath == null) {
			if (other.atch_filepath != null)
				return false;
		} else if (!atch_filepath.equals(other.atch_filepath))
			return false;
		if (atch_sq != other.atch_sq)
			return false;
		if (board_sq != other.board_sq)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtchFileVo [atch_sq=" + atch_sq + ", atch_filepath=" + atch_filepath + ", atch_filename="
				+ atch_filename + ", board_sq=" + board_sq + "]";
	}

}
