package kr.or.dgit.book_project.post.dto;

public class Doro {
	private int zipcode;
	private String sido;
	private String sigungu;
	private String doro;
	private String building1;
	private String building2;

	public Doro() {
	}

	public Doro(int zipcode, String address) {
		super();
		String[] addArr = address.trim().split(" ");

		this.zipcode = zipcode;
		this.sido = addArr[0];
		this.sigungu = addArr[1];
		this.doro = addArr[2];
		this.building1 = addArr[3];
		if (addArr[3].contains("-")) {
			int idx = addArr[3].indexOf("-");
			addArr[4] = addArr[3].substring(idx + 1, addArr[4].length());
			addArr[3] = addArr[3].substring(0, idx);
			this.building2 = addArr[4];
		}

	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public String getBuilding1() {
		return building1;
	}

	public void setBuilding1(String building1) {
		this.building1 = building1;
	}

	public String getBuilding2() {
		return building2;
	}

	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	public Object[] toArray() {
		return new String[] { zipcode + "",
				String.format("%s %s %s %s%s", sido, sigungu, doro, building1, building2) };
	}
}
