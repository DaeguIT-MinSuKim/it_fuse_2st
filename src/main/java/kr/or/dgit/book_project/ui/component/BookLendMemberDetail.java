package kr.or.dgit.book_project.ui.component;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.ui.common.InputComp;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BookLendMemberDetail extends JPanel {

	protected JLabel lblMsg;
	private InputComp pMCode;
	private InputComp pMName;
	private InputComp pMTel;

	/**
	 * Create the panel.
	 */
	public BookLendMemberDetail() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pMCode = new InputComp();
		add(pMCode);
		pMCode.setTitle("회원코드");
		
		lblMsg = new JLabel();
		lblMsg.setForeground(Color.RED);
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMsg);
		
		pMName = new InputComp();
		add(pMName);
		pMName.setTitle("성명");
		
		pMTel = new InputComp();
		add(pMTel);
		pMTel.setTitle("전화번호");
	}
	// 겟
	public MemberInfo getObject(){
		String mCode = pMCode.getTFValue();
		String mName = pMName.getTFValue();
		String mTel = pMTel.getTFValue();
		return new MemberInfo(mCode, mName, mTel);
	}
	// 셋
	public void setObject(MemberInfo memberinfo){
		pMCode.setTFValue(memberinfo.getmCode());
		pMName.setTFValue(memberinfo.getmName());
		pMTel.setTFValue(memberinfo.getmTel());
	}
	
	//클리어
	public void clear(){
		pMCode.setTFValue("");
		pMName.setTFValue("");
		pMTel.setTFValue("");
	}
	public InputComp getpMCode() {
		return pMCode;
	}
	public InputComp getpMName() {
		return pMName;
	}
	public InputComp getpMTel() {
		return pMTel;
	}
	public JLabel getLblMsg() {
		return lblMsg;
	}
	public void setLblMsg(JLabel lblMsg) {
		this.lblMsg = lblMsg;
	}
}
