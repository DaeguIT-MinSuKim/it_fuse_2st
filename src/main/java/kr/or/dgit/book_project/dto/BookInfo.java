package kr.or.dgit.book_project.dto;

import java.util.List;

public class BookInfo { // 도서

	private String bCode; // 도서코드
	private String bSubCode; // 도서 중복 코드
	private Coden coden; // 분류
	private String bName; // 도서명
	private String author; // 저자
	private PublisherInfo publisherInfo; // 출판사 코드
	private int price; // 가격
	private String insertDate; // 도서등록일
	private int bLendCount; // 총 대여횟수
	private boolean isLending; // 대여여부
	private boolean isDel; // 도서폐기여부

	public BookInfo() {	}
	
	public BookInfo(String bCode, String bSubCode, Coden coden, String bName, String author,
			PublisherInfo publisherInfo, int price) {
		// 도서 입력시 사용
		super();
		this.bCode = bCode;
		this.bSubCode = bSubCode;
		this.coden = coden;
		this.bName = bName;
		this.author = author;
		this.publisherInfo = publisherInfo;
		this.price = price;
	}

	public BookInfo(String bCode, String bSubCode, String bName, String author, PublisherInfo publisherInfo, int price,
			int bLendCount) {
		// 도서정보 받아올 때 사용
		super();
		this.bCode = bCode;
		this.bSubCode = bSubCode;
		this.bName = bName;
		this.author = author;
		this.publisherInfo = publisherInfo;
		this.price = price;
		this.bLendCount = bLendCount;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public String getbSubCode() {
		return bSubCode;
	}

	public void setbSubCode(String bSubCode) {
		this.bSubCode = bSubCode;
	}

	public Coden getCoden() {
		return coden;
	}

	public void setCoden(Coden coden) {
		this.coden = coden;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public PublisherInfo getPublisherInfo() {
		return publisherInfo;
	}

	public void setPublisherInfo(PublisherInfo publisherInfo) {
		this.publisherInfo = publisherInfo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public int getbLendCount() {
		return bLendCount;
	}

	public void setbLendCount(int bLendCount) {
		this.bLendCount = bLendCount;
	}

	public boolean isLending() {
		return isLending;
	}

	public void setLending(boolean isLending) {
		this.isLending = isLending;
	}

	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s %s %s %s %s %s", bCode, bSubCode, coden, bName, author, publisherInfo,
				price, insertDate, bLendCount, isLending, isDel);
	}
	public Object[] toArrayForBoookList() {
		// "도서코드", "중복코드", "도서명", "분야", "저자", "출판사"
		return new Object[] { bCode, bSubCode, bName, coden.getcName(), author,
				String.format("%s(%s)", publisherInfo.getPublisher(), publisherInfo.getpCode()) };
	}
	public Object[] toArray() {
		// "도서코드","도서중복코드","도서명","저자","출판사","가격", "총대여 횟수"
		return new Object[] { bCode, bSubCode, bName, author,
				String.format("%s(%s)", publisherInfo.getPublisher(), publisherInfo.getpCode()), price, bLendCount };
	}
	public Object[] toArrayForCgroup() {
		// "도서코드","도서중복코드","도서명","저자","출판사","가격", "대여여부"
		return new Object[] { bCode, bSubCode, bName, author,
				String.format("%s(%s)", publisherInfo.getPublisher(), publisherInfo.getpCode()), price, isLending?"대여중":"" };
	}
}
