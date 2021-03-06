package kr.or.dgit.book_project.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import java.awt.Color;

public class BookManageForDelBookView extends AbsBookSearchView {
	// 폐기도서 관리화면

	public BookManageForDelBookView() {
		super();
		map = new HashMap<>();
		map.put("isDel", true);
		loadTable();
		addPopupMenu();
	}

	@Override
	protected void createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("복원");
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfo bookInfo = pTable.getSelectedObject();
				if (bookInfo == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				int res = JOptionPane.showConfirmDialog(null, "해당도서를 복원하시겠습니까", "", JOptionPane.YES_NO_OPTION);
				if (res != 0) {
					JOptionPane.showMessageDialog(null, "취소하였습니다");
					return;
				}
				// 복원하는 메소드
				if (BookInfoService.getInstance().setDelBookInfo(bookInfo, false) != 0) {
					System.out.println("복원!!!!!!!!!!!!!!!!!");
					map.put("isDel", true);
					loadTable();
				}
			}
		});
		popupMenu.add(updateItem);

	}

}
