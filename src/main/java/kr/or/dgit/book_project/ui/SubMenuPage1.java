package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.book_project.ui.view.BookInsertView;
import kr.or.dgit.book_project.ui.view.BookManageView;
import kr.or.dgit.book_project.ui.view.CodenManageView;
import kr.or.dgit.book_project.ui.view.DiscardBookManage;
import kr.or.dgit.book_project.ui.view.MemberInsertView;
import kr.or.dgit.book_project.ui.view.MemberSearchComboView;
import kr.or.dgit.book_project.ui.view.PublisherView;

public class SubMenuPage1 extends JTabbedPane implements ChangeListener {

	private JPanel pMember;
	private JPanel pManager;
	private JPanel pMemberManager;
	private MemberSearchComboView memberSearchComboView;
	private MemberInsertView memberInsertViewEmp;

	public SubMenuPage1(char mGroup) {
		addChangeListener(this);
		pMember = new JPanel();
		addTab("회원등록", null, pMember, null);
		pMember.setLayout(new GridLayout(0, 1, 0, 0));
		MemberInsertView memberInsertView = new MemberInsertView();
		pMember.add(memberInsertView);

		setSubMenuPage1(mGroup);

	}

	public void setSubMenuPage1(char mGroup) {
		switch (mGroup) {
		case 'A':
			// 관리자..직원메뉴까지 볼수있음
			pMemberManager = new JPanel();
			addTab("회원관리", null, pMemberManager, null);

			pManager = new JPanel();
			addTab("직원관리", null, pManager, null);
			break;
		case 'B':
			// 사서.... 직원메뉴 제외 전부 볼 수 있음..
			pMemberManager = new JPanel();
			addTab("회원관리", null, pMemberManager, null);
			break;
		default:
			break;
		}
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this) {
			// 선택된 탭의 idx를 넘겨줌
			stateChangedThis(this.getSelectedIndex());
		}

	}

	private void stateChangedThis(int idx) {
		if (this.getTitleAt(idx).equals("회원관리") && memberSearchComboView == null) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pMemberManager.setLayout(new GridLayout(0, 1, 0, 0));
			memberSearchComboView = new MemberSearchComboView();
			memberSearchComboView.setLayout(new GridLayout(1, 0, 0, 0));
			pMemberManager.add(memberSearchComboView);
		} else if (this.getTitleAt(idx).equals("직원관리") && memberInsertViewEmp == null) {
			pManager.setLayout(new GridLayout(1, 0, 0, 0));
			memberInsertViewEmp = new MemberInsertView();
			pManager.add(memberInsertViewEmp);
		}

	}
}
