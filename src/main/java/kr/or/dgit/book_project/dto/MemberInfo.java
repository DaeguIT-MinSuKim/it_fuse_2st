package kr.or.dgit.book_project.dto;

public class MemberInfo {
	private String mCode;		// 회원코드
	private String mPass;		// 비밀번호
	private String mName;		// 성명
	private String mTel;		// 연락처
	private int mZipCode;		// 우편번호
	private String mAddress;	// 주소
	private boolean isPosbl; 	// 대여가능여부
	private int delayCount;		// 연체횟수
	private int mLendCount;		// 총 대여권수
	private int mNowCount;		// 현재 대여권수
	private String blackDate;	// 대여금지일
	private char mGroup;		// A/B/C : 관리자/사서/일반회원
	private boolean isSecsn;	// 탈퇴여부
	
	public MemberInfo() {	}
	
	
		
	public MemberInfo(String mCode) {
		super();
		this.mCode = mCode;
	}



	public MemberInfo(String mCode, String mName, String mTel, int mZipCode, String mAddress) {
		this.mCode = mCode;
		this.mName = mName;
		this.mTel = mTel;
		this.mZipCode = mZipCode;
		this.mAddress = mAddress;
	}
	
	public MemberInfo(String mCode, String mPass, String mName, String mTel, int mZipCode, String mAddress) {
		this.mCode = mCode;
		this.mPass = mPass;
		this.mName = mName;
		this.mTel = mTel;
		this.mZipCode = mZipCode;
		this.mAddress = mAddress;
	}



	public MemberInfo(String mCode, String mName, String mTel) {
		super();
		this.mCode = mCode;
		this.mName = mName;
		this.mTel = mTel;
	}
	
	
	


	public String getmCode() {
		return mCode;
	}

	public void setmCode(String mCode) {
		this.mCode = mCode;
	}

	public String getmPass() {
		return mPass;
	}

	public void setmPass(String mPass) {
		this.mPass = mPass;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public int getmZipCode() {
		return mZipCode;
	}

	public void setmZipCode(int mZipCode) {
		this.mZipCode = mZipCode;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public boolean isPosbl() {
		return isPosbl;
	}

	public void setPosbl(boolean isPosbl) {
		this.isPosbl = isPosbl;
	}

	public int getDelayCount() {
		return delayCount;
	}

	public void setDelayCount(int delayCount) {
		this.delayCount = delayCount;
	}

	public int getmLendCount() {
		return mLendCount;
	}

	public void setmLendCount(int mLendCount) {
		this.mLendCount = mLendCount;
	}

	public int getmNowCount() {
		return mNowCount;
	}

	public void setmNowCount(int mNowCount) {
		this.mNowCount = mNowCount;
	}

	public String getBlackDate() {
		return blackDate;
	}

	public void setBlackDate(String blackDate) {
		this.blackDate = blackDate;
	}

	public char getmGroup() {
		return mGroup;
	}

	public void setmGroup(char mGroup) {
		this.mGroup = mGroup;
	}

	public boolean isSecsn() {
		return isSecsn;
	}

	public void setSecsn(boolean isSecsn) {
		this.isSecsn = isSecsn;
	}

	@Override
	public String toString() {
		return String.format(
				"%s %s %s %s %s %s %s %s %s %s %s %s %s ",
				mCode, mPass, mName, mTel, mZipCode, mAddress, isPosbl, delayCount, mLendCount, mNowCount, blackDate,
				mGroup, isSecsn);
	}

	public Object[] toArrayForMemberList() {
		//{"이름","회원코드","전화번호","우편번호","주소","대여금지일"};		
		return new Object[]{mName, mCode, mTel, mZipCode, mAddress, blackDate};
	}


	//대여 프로시저때문에
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mCode == null) ? 0 : mCode.hashCode());
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
		MemberInfo other = (MemberInfo) obj;
		if (mCode == null) {
			if (other.mCode != null)
				return false;
		} else if (!mCode.equals(other.mCode))
			return false;
		return true;
	}	
	
	
	
}
