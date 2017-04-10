package kr.or.dgit.book_project.dto;

public class Coden {
	private String cName; // 분류
	private String cCode; // 코드

	public Coden() {
	}

	public Coden(String cName, String cCode) {
		this.cName = cName;
		this.cCode = cCode;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", cName, cCode);
	}

	public Object[] toArray() {
		return new String[]{ cName, cCode};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cCode == null) ? 0 : cCode.hashCode());
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
		Coden other = (Coden) obj;
		if (cCode == null) {
			if (other.cCode != null)
				return false;
		} else if (!cCode.equals(other.cCode))
			return false;
		return true;
	}

}
