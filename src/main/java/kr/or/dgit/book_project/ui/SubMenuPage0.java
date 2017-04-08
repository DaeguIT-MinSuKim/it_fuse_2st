package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.dgit.book_project.ui.view.BookInsertView;
import kr.or.dgit.book_project.ui.view.BookManageView;
import kr.or.dgit.book_project.ui.view.CodenManageView;
import kr.or.dgit.book_project.ui.view.DiscardBookManage;
import kr.or.dgit.book_project.ui.view.PublisherView;
import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SubMenuPage0 extends JTabbedPane implements ChangeListener {

	private JPanel pMember;
	private JPanel pBook;
	private JPanel pManager;
	private JPanel pPublisher;
	private JPanel pCoden;
	private JPanel pBookManager;
	private JPanel pDiscardBook;
	private BookManageView bookManageView;
	private PublisherView publisherView;
	private DiscardBookManage discardBookManage;
	private CodenManageView codenManagerView;

	public SubMenuPage0() {
		addChangeListener(this);
		pBook = new JPanel();

		addTab("도서등록", null, pBook, null);
		pBook.setLayout(new GridLayout(0, 1, 0, 0));
		BookInsertView bookInsertview = new BookInsertView();
		pBook.add(bookInsertview);

		pBookManager = new JPanel();
		addTab("도서관리", null, pBookManager, null);

		pDiscardBook = new JPanel();
		addTab("폐기도서", null, pDiscardBook, null);

		pPublisher = new JPanel();
		addTab("출판사관리", null, pPublisher, null);

		pCoden = new JPanel();
		addTab("분류관리", null, pCoden, null);

	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this) {
			// 선택된 탭의 idx를 넘겨줌
			stateChangedThis(this.getSelectedIndex());
		}

	}

	private void stateChangedThis(int idx) {
		if (this.getTitleAt(idx).equals("도서관리") && bookManageView == null) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pBookManager.setLayout(new GridLayout(0, 1, 0, 0));
			bookManageView = new BookManageView();
			pBookManager.add(bookManageView);
		} else if (this.getTitleAt(idx).equals("폐기도서") && discardBookManage == null) {
			pDiscardBook.setLayout(new GridLayout(0, 1, 0, 0));
			discardBookManage = new DiscardBookManage();
			pDiscardBook.add(discardBookManage);
		} else if (this.getTitleAt(idx).equals("출판사관리") && publisherView == null) {
			pPublisher.setLayout(new GridLayout(0, 1, 0, 0));
			publisherView = new PublisherView();
			pPublisher.add(publisherView);
		} else if (this.getTitleAt(idx).equals("분류관리") && codenManagerView == null) {
			pCoden.setLayout(new GridLayout(0, 1, 0, 0));
			codenManagerView = new CodenManageView();
			pCoden.add(codenManagerView);
		}

	}

	/*
	 * JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource(); int
	 * index = sourceTabbedPane.getSelectedIndex(); System.out.println(
	 * "Tab changed to: " + sourceTabbedPane.getTitleAt(index));
	 */
}
