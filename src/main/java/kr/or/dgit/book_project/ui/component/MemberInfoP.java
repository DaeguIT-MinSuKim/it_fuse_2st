package kr.or.dgit.book_project.ui.component;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.post.PostMain;
import kr.or.dgit.book_project.ui.common.InputComp;

public class MemberInfoP extends JPanel {
	private InputComp pMCode;
	private InputComp pMName;
	private InputComp pMTel;
	private InputComp pMZipCode;
	private InputComp pMAddress;
	private InputComp pMAddDetail;
	private InputComp pMPass;
	private PostMain post;

	public MemberInfoP() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelM = new JPanel();
		add(panelM);
		panelM.setLayout(new GridLayout(0, 1, 10, 10));
		
		pMCode = new InputComp();
		pMCode.setTitle("회원코드");
		panelM.add(pMCode);
		
		pMName = new InputComp();
		pMName.setTitle("성      명");
		panelM.add(pMName);
		
		pMPass = new InputComp();
		GridBagLayout pMPassGridBagLayout = (GridBagLayout) pMPass.getLayout();
		pMPassGridBagLayout.rowWeights = new double[]{0.0};
		pMPassGridBagLayout.rowHeights = new int[]{50};
		pMPassGridBagLayout.columnWeights = new double[]{0.0, 0.0};
		pMPassGridBagLayout.columnWidths = new int[]{100, 200};
		pMPass.setTitle("비밀번호");
		panelM.add(pMPass);
		
		pMTel = new InputComp();
		pMTel.setTitle("전화번호");
		panelM.add(pMTel);
		
		pMZipCode = new InputComp();
		panelM.add(pMZipCode);
		pMZipCode.setTitle("우편번호");
		
		pMAddress = new InputComp();
		pMAddress.setTitle("주      소");
		panelM.add(pMAddress);
		
		pMAddDetail = new InputComp();
		pMAddDetail.setTitle("상세주소");
		panelM.add(pMAddDetail);
	}
	
	public void setClear(){		
		pMName.setTFValue("");
		pMPass.setTFValue("");		
		pMTel.setTFValue("");
		pMZipCode.setTFValue("");
		pMAddress.setTFValue("");
		pMAddDetail.setTFValue("");	
	}
	
	public MemberInfo getObject(){				
		String mCode = pMCode.getTFValue();
		String mName = pMName.getTFValue();
		String mPass = pMPass.getTFValue();
		String mTel  = pMTel.getTFValue();
		//int mZipCode = Integer.parseInt(pMZipCode.getTFValue());
		//String mZipCode  = pMZipCode.getTFValue();
		
		String mZipCode  = pMZipCode.getTFValue();		
		String mAddress = pMAddress.getTFValue();
		String mAddDetail = pMAddDetail.getTFValue();		
		char mGroup = mCode.charAt(0);		
		return new MemberInfo(mCode, mPass, mName, mTel, mZipCode, mAddress, mAddDetail, mGroup);
	}
	
	public void setObject(MemberInfo memberinfo){
		pMCode.setTFValue(memberinfo.getmCode());
		pMPass.setTFValue("");
		pMName.setTFValue(memberinfo.getmName());
		pMTel.setTFValue(memberinfo.getmTel());
		//pMZipCode.setTFValue(String.valueOf(memberinfo.getmZipCode()));
		pMZipCode.setTFValue(memberinfo.getmZipCode());
		pMAddress.setTFValue(memberinfo.getmAddress());
		pMAddDetail.setTFValue(memberinfo.getmAddDetail());
	}
	
	public void setObjectAddr(String[] arr){			// 우편번호 값 가져오기
		pMZipCode.setTFValue(arr[0]);
		pMAddress.setTFValue(arr[1]);
		pMAddDetail.setTFValue(arr[2]);
	}
	
	public boolean addMemberCheck() {

		/*
		 * if (pPCode.getTFValue().trim().equals("")) {
		 * JOptionPane.showMessageDialog(null, "출판사코드를 입력해주세요");
		 * pPCode.getTF().requestFocus(); return false; } else
		 */ if (pMName.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
			pMName.getTF().requestFocus();
			return false;
		} else if (pMPass.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "사용할 비밀번호를 입력해주세요");
			pMPass.getTF().requestFocus();
			return false;
		} else if (!pMTel.getTFValue().trim().matches("^[0-9]{3}-{1}[0-9]{3,4}-{1}[0-9]{4}$")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요 000-0000-0000");
			pMTel.getTF().requestFocus();
			return false;
		} else {
			return true;
		}
	} 
	
	public boolean isVaildCheck(){
		try {			
			pMPass.isValidCheck("^[a-zA-Z0-9]+$", "영문 또는 숫자만 가능합니다.");
			pMName.isValidCheck("^[a-zA-Z가-힣]+$", "영문 또는 숫자만 가능합니다.");
			pMZipCode.isValidCheck("^[0-9]{5}$", "숫자만 가능합니다.");
			pMTel.isEmptyCheck();
			pMZipCode.isEmptyCheck();
			pMAddress.isEmptyCheck();
			pMAddDetail.isEmptyCheck();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
			//e.printStackTrace();
		}
		
	}

	public InputComp getpMCode() {
		return pMCode;
	}

	public InputComp getpMName() {
		return pMName;
	}

	public void setpMName(InputComp pMName) {
		this.pMName = pMName;
	}

	public InputComp getpMTel() {
		return pMTel;
	}

	public void setpMTel(InputComp pMTel) {
		this.pMTel = pMTel;
	}

	public InputComp getpMPass() {
		return pMPass;
	}

	public void setpMPass(InputComp pMPass) {
		this.pMPass = pMPass;
	}

	public InputComp getpMZipCode() {
		return pMZipCode;
	}

	public void setpMZipCode(InputComp pMZipCode) {
		this.pMZipCode = pMZipCode;
	}

	public InputComp getpMAddress() {
		return pMAddress;
	}

	public void setpMAddress(InputComp pMAddress) {
		this.pMAddress = pMAddress;
	}

	public InputComp getpMAddDetail() {
		return pMAddDetail;
	}

	public void setpMAddDetail(InputComp pMAddDetail) {
		this.pMAddDetail = pMAddDetail;
	}
	

}
