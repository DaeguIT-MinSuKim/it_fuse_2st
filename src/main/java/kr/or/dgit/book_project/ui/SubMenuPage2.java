package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.book_project.ui.view.BookLendView;
import kr.or.dgit.book_project.ui.view.BookReturnView;
import kr.or.dgit.book_project.ui.view.MemberInsertView;
import kr.or.dgit.book_project.ui.view.MemberSearchComboView;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class SubMenuPage2 extends JTabbedPane implements ChangeListener {

	private BookReturnView bRetrunView;
	private JPanel pPaymentUpdate;

	public SubMenuPage2() {
		addChangeListener(this);
		JPanel pPaymentInput = new JPanel();
		add("대여관리", pPaymentInput);
		pPaymentInput.setLayout(new GridLayout(0, 1, 0, 0));
		BookLendView bLendView = new BookLendView();
		pPaymentInput.add(bLendView);

		pPaymentUpdate = new JPanel();
		add("반납관리", pPaymentUpdate);
		pPaymentUpdate.setLayout(new GridLayout(0, 1, 0, 0));
		bRetrunView = new BookReturnView();
		pPaymentUpdate.add(bRetrunView);

	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this) {
			// 선택된 탭의 idx를 넘겨줌
			stateChangedThis(this.getSelectedIndex());
		}

	}

	private void stateChangedThis(int idx) {
		if (this.getTitleAt(idx).equals("반납관리") && bRetrunView == null) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pPaymentUpdate.setLayout(new GridLayout(0, 1, 0, 0));
			bRetrunView = new BookReturnView();
			pPaymentUpdate.add(bRetrunView);
		}

	}
}
