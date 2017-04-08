package kr.or.dgit.book_project.ui.view;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.ui.table.BookSearchTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class tableTestView extends JPanel {
	
	private JPopupMenu popupMenu;
	private BookSearchTable bsv;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new tableTestView());
		jf.setVisible(true);
	}

	public tableTestView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		bsv = new BookSearchTable();
		
		Map<String, Object> map = new HashMap<>();
		map.put("onlyBook", true);
		bsv.loadData();
		add(bsv);
		
		createPopupMenu();
		(bsv.getTable()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					
					popupMenu.show(bsv.getTable(), e.getX(), e.getY());
					// show(활성화될 컴포넌트, X좌표, Y좌표)
				}
			}
		});
		
		
	}
	
	protected void createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfo bookInfo = bsv.getSelectedObject();
				if (bookInfo == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				/*BookDetailViewFrame bookDetailViewFrame = new BookDetailViewFrame();
				bookDetailViewFrame.setBookDetailInfo(bookInfo);
				bookDetailViewFrame.setMyActionLister(BookManageView.this);
				bookDetailViewFrame.setVisible(true);*/
			}
		});
		popupMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("대여현황");
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfo bookInfo = bsv.getSelectedObject();
				if (bookInfo == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				// 대여현황 페이지 띄우기
			/*	BookPaymentViewFrame bookPaymentViewFrame = new BookPaymentViewFrame();
				bookPaymentViewFrame.setBookInfo(bookInfo);
				bookPaymentViewFrame.setVisible(true);*/
			}

		});
		popupMenu.add(deleteItem);

	}

}
