package kr.or.dgit.book_project.ui.component;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.ui.common.InputComp;

public class MemberInfoP extends JPanel {
	private InputComp pMCode;
	private InputComp pMName;
	private InputComp pMTel;
	private InputComp pMZipCode;
	private InputComp pMAddress;
	private InputComp pMAddDetail;
	private InputComp pMPass;

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
		pMCode.setTFValue("");		
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
		int mZipCode = Integer.parseInt(pMZipCode.getTFValue());
		String mAddress = pMAddress.getTFValue();
		char mGroup = mCode.charAt(0);
		return new MemberInfo(mCode, mPass, mName, mTel, mZipCode, mAddress, mGroup);
	}
	
	public void setObject(MemberInfo memberinfo){
		pMCode.setTFValue(memberinfo.getmCode());
		pMPass.setTFValue("");
		pMName.setTFValue(memberinfo.getmName());
		pMTel.setTFValue(memberinfo.getmTel());
		pMZipCode.setTFValue(String.valueOf(memberinfo.getmZipCode()));
		pMAddress.setTFValue(memberinfo.getmAddress());
		
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
	
	

}
