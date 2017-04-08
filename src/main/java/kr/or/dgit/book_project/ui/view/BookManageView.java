package kr.or.dgit.book_project.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import kr.or.dgit.book_project.dto.BookInfo;

public class BookManageView extends AbsBookSearchView implements ActionListener {
	// 도서 관리 화면

	public BookManageView() {
		super();
		// 삭제되지 않은 도서만 출력
		map.put("isDel", false);
		loadTable();
		addPopupMenu();
	}
	
	@Override
	protected void createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfo bookInfo = pTable.getSelectedObject();
				if (bookInfo == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				BookDetailViewFrame bookDetailViewFrame = new BookDetailViewFrame();
				bookDetailViewFrame.setBookDetailInfo(bookInfo);
				bookDetailViewFrame.setMyActionLister(BookManageView.this);
				bookDetailViewFrame.setVisible(true);
			}
		});
		popupMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("대여현황");
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfo bookInfo = pTable.getSelectedObject();
				if (bookInfo == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				// 대여현황 페이지 띄우기
				BookPaymentViewFrame bookPaymentViewFrame = new BookPaymentViewFrame();
				bookPaymentViewFrame.setBookInfo(bookInfo);
				bookPaymentViewFrame.setVisible(true);
			}

		});
		popupMenu.add(deleteItem);

	}

	

}
