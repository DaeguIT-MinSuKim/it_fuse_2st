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
	private BookLendView bLendView;
	private JPanel pPaymentInput;

	public SubMenuPage2() {
		addChangeListener(this);
		pPaymentInput = new JPanel();
		addTab("대여관리", null, pPaymentInput, null);
		/*pPaymentInput.setLayout(new GridLayout(0, 1, 0, 0));
		if (bLendView != null) {
			pPaymentInput.removeAll();
		}
		bLendView = new BookLendView();
		pPaymentInput.add(bLendView);*/

		pPaymentUpdate = new JPanel();
		addTab("반납관리", null, pPaymentUpdate, null);

	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this) {
			// 선택된 탭의 idx를 넘겨줌
			stateChangedThis(this.getSelectedIndex());
		}

	}

	private void stateChangedThis(int idx) {
		if (this.getTitleAt(idx).equals("대여관리")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pPaymentInput.setLayout(new GridLayout(0, 1, 0, 0));
			if (bLendView != null) {
				pPaymentInput.removeAll();
			}
			bLendView = new BookLendView();
			pPaymentInput.add(bLendView);
		} else if (this.getTitleAt(idx).equals("반납관리")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pPaymentUpdate.setLayout(new GridLayout(0, 1, 0, 0));
			if (bRetrunView != null) {
				pPaymentUpdate.removeAll();
			}
			bRetrunView = new BookReturnView();
			pPaymentUpdate.add(bRetrunView);
		}

	}
}
