package kr.or.dgit.book_project.ui.component;

import javax.swing.JPanel;

import kr.or.dgit.book_project.ui.common.InputComp;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.GridLayout;

public class BookLendMemberDetailDate extends JPanel {

	private InputComp pMCode;
	private InputComp pMName;
	private InputComp pMTel;
	private InputComp pLendDate;
	private InputComp pReturnDate;

	/**
	 * Create the panel.
	 */
	public BookLendMemberDetailDate() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pMCode = new InputComp();
		add(pMCode);
		pMCode.setTitle("회원코드");
		
		pMName = new InputComp();
		add(pMName);
		pMName.setTitle("성명");
		
		pMTel = new InputComp();
		add(pMTel);
		pMTel.setTitle("전화번호");
		
		pLendDate = new InputComp();
		pLendDate.setTitle("대 여 일");
		add(pLendDate);
		
		pReturnDate = new InputComp();
		pReturnDate.setTitle("반 납 일");
		add(pReturnDate);

	}
	public BookLendMemberDetailDate getObject(){
		return null;
	}
}
