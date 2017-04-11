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
import kr.or.dgit.book_project.ui.view.BookManageForDelBookView;
import kr.or.dgit.book_project.ui.view.MemberInsertView;
import kr.or.dgit.book_project.ui.view.MemberSearchComboView;
import kr.or.dgit.book_project.ui.view.PublisherView;

public class SubMenuPage1 extends JTabbedPane implements ChangeListener {

	private JPanel pMember;
	private JPanel pManager;
	private JPanel pMemberManager;
	private JPanel pManagerManage;
	private MemberSearchComboView memberSearchComboView;
	private MemberSearchComboView managerSearchComboView;
	private MemberInsertView memberInsertViewEmp;
	private MemberInsertView memberInsertView;

	public SubMenuPage1(char mGroup) {
		addChangeListener(this);
		pMember = new JPanel();
		addTab("회원등록", null, pMember, null);
		pMember.setLayout(new GridLayout(0, 1, 0, 0));
		if (memberInsertView != null) {
			pMember.removeAll();
		}
		memberInsertView = new MemberInsertView();
		memberInsertView.setMcodeAuto(); // 회원등록 번호 자동 카운팅

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
			addTab("직원등록", null, pManager, null);

			pManagerManage = new JPanel();
			addTab("직원관리", null, pManagerManage, null);

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
		if (this.getTitleAt(idx).equals("회원관리")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pMemberManager.setLayout(new GridLayout(0, 1, 0, 0));
			if (memberSearchComboView != null) {
				pMemberManager.removeAll();
			}
			memberSearchComboView = new MemberSearchComboView();
			memberSearchComboView.setTableMap('C');
			memberSearchComboView.setMyMouseListenerForManage(); // 회원검색화면에서 우클
			memberSearchComboView.setLayout(new GridLayout(1, 0, 0, 0));
			pMemberManager.add(memberSearchComboView);
		} else if (this.getTitleAt(idx).equals("직원등록")) {
			pManager.setLayout(new GridLayout(1, 0, 0, 0));
			if (memberInsertViewEmp != null) {
				pManager.removeAll();
			}
			memberInsertViewEmp = new MemberInsertView();
			pManager.add(memberInsertViewEmp);
		} else if (this.getTitleAt(idx).equals("직원관리")) {
			pManagerManage.setLayout(new GridLayout(1, 0, 0, 0));
			if (managerSearchComboView != null) {
				pManagerManage.removeAll();
			}
			managerSearchComboView = new MemberSearchComboView();
			managerSearchComboView.setTableMap('B');
			managerSearchComboView.setMyMouseListenerForManage(); // 회원검색화면에서 우클
			managerSearchComboView.setLayout(new GridLayout(1, 0, 0, 0));
			pManagerManage.add(managerSearchComboView);
		}

	}
}
