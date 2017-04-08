package kr.or.dgit.book_project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentIO {

	private int no; // 출납번호
	private BookInfo bookInfo; // 도서코드
	private MemberInfo memberInfo; // 회원코드
	private String lendDate; // 대여일
	private String returnDate; // 반납일

	public PaymentIO() {
	}

	// 맴버 디테일 생성자
	public PaymentIO(MemberInfo memberInfo, String lendDate, String returnDate) {
		super();
		this.memberInfo = memberInfo;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
	}
	
	public PaymentIO(BookInfo bookInfo) {
		super();
		this.bookInfo = bookInfo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public String getLendDate() {
		return lendDate;
	}

	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isDelay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long dif = 0;
		try {
			Date d1 = sdf.parse(lendDate);
			Date d2 = null;
			if (returnDate != null) {
				// 반납도서
				d2 = sdf.parse(returnDate);
			} else {
				// 미반납도서
				d2 = new Date();
			}
			dif = (d2.getTime() - d1.getTime()) / 60 / 24 / 60 / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dif >= 3;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", no, bookInfo, memberInfo, lendDate, returnDate);
	}

	public Object[] toArrayPayment() {
		return new Object[] { bookInfo.getbCode(), bookInfo.getbSubCode(), bookInfo.getbName(), memberInfo.getmCode(),
				memberInfo.getmName(), lendDate, isDelay() ? "Y" : "N" };
	}

	public Object[] toArray() {
		return new Object[] { memberInfo.getmCode(), memberInfo.getmName(), lendDate, returnDate,
				lendDate != null ? (isDelay() ? "Y" : "N") : "" };
	}

}
