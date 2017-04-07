package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.dgit.book_project.ui.view.BookInsertView;
import kr.or.dgit.book_project.ui.view.BookManageView;
import kr.or.dgit.book_project.ui.view.CodenManageView;
import kr.or.dgit.book_project.ui.view.MemberInsertView;
import kr.or.dgit.book_project.ui.view.MemberSearchComboView;
import kr.or.dgit.book_project.ui.view.PublisherView;

public class SubMenuPage1 extends JTabbedPane {

private JPanel pMember;
private JPanel pBook;
private JPanel pManager;
private JPanel pPublisher;
private JPanel pCoden;

	public SubMenuPage1() {		
		pBook = new JPanel();		
		addTab("도서등록", null, pBook, null);
		pBook.setLayout(new GridLayout(0, 1, 0, 0));
		BookInsertView bookInsertview = new BookInsertView();
		pBook.add(bookInsertview);
		
		JPanel pBookManager = new JPanel();
		addTab("도서관리", null, pBookManager, null);
		pBookManager.setLayout(new BorderLayout(0, 0));
		BookManageView bookManageView = new BookManageView();
		pBookManager.add(bookManageView);
		
		pMember = new JPanel();
		addTab("회원등록", null, pMember, null);		
		pMember.setLayout(new GridLayout(0, 1, 0, 0));
		MemberInsertView memberInsertView = new MemberInsertView();
		pMember.add(memberInsertView);		
				
		
		JPanel pMemberManager = new JPanel();
		addTab("회원관리", null, pMemberManager, null);
		pMemberManager.setLayout(new GridLayout(0, 1, 0, 0));
		
		MemberSearchComboView panel = new MemberSearchComboView();
		pMemberManager.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		pManager = new JPanel();
		addTab("직원관리", null, pManager, null);
		pManager.setLayout(new GridLayout(1, 0, 0, 0));
		MemberInsertView memberInsertViewEmp = new MemberInsertView();
		pManager.add(memberInsertViewEmp);
		
		
		pPublisher = new JPanel();
		addTab("출판사관리", null, pPublisher, null);
		pPublisher.setLayout(new GridLayout(0, 1, 0, 0));
		PublisherView publisherView = new PublisherView();
		pPublisher.add(publisherView);
		
		pCoden = new JPanel();
		addTab("분류관리", null, pCoden, null);
		pCoden.setLayout(new GridLayout(0, 1, 0, 0));
		CodenManageView codenManagerView = new CodenManageView();
		pCoden.add(codenManagerView);
	}	
}
