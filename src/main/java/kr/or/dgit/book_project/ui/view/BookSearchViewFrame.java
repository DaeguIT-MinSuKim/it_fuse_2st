package kr.or.dgit.book_project.ui.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.ui.component.BookInfoBasic;
import kr.or.dgit.book_project.ui.component.BookInfoP;

public class BookSearchViewFrame extends JFrame {

	private JPanel contentPane;
	private BookInfoP bookInfoP;
	private BookSearchView bookSearchView;
	private BookInsertView bookInsertView;
	private BookLendView booklendView; // 대여 추가
	private BookInfoBasic bookinfobasic; // 대여 추가
	
	public BookSearchViewFrame() {
		setTitle("도서검색");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	public void setBookInsertView(BookInsertView bookInsertView) {
		this.bookInsertView = bookInsertView;
	}
	
	
	// 대여 부분
	public void setBooklendView(BookLendView booklendView) {
		this.booklendView = booklendView;
	}

	public void setMyMouseListener(BookInfoP bookInfoP) {
		this.bookInfoP = bookInfoP;
		bookSearchView.getpTable().getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					BookInfo bookInfo = bookSearchView.getpTable().getSelectedObject();
					Map<String, Object> param = new HashMap<>();
					param.put("bCode", bookInfo.getbCode());
					bookInfo.setbSubCode(BookInfoService.getInstance().countBookInfo(param) + "");
					bookInfoP.setObject(bookInfo);
					setVisible(false);

				}
			}

		});
	}
	
	// 대여창에서 도서코드 눌러서 코드 찾아서 넣는부분 출납!
	public void setMyMouseListenerPayment(BookInfoBasic bookinfobasic) {
		bookSearchView.getpTable().getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					BookInfo bookInfo = bookSearchView.getpTable().getSelectedObject();
					JOptionPane.showMessageDialog(null, bookInfo.toArray());
					Map<String, Object> param = new HashMap<>();
					param.put("bCode", bookInfo.getbCode());
					param.put("bSubCode", bookInfo.getbSubCode());
					JOptionPane.showMessageDialog(null, param);
					bookinfobasic.setObject(bookInfo);
					setVisible(false);
				}
			}

		});
	}

	public void addBtn(String string) {
		if (bookSearchView.getpContent().getpBtnSub().getComponentCount() != 0) {
			// 버튼이 1개만 부착되기 위해서 사용되는 구문
			return;
		}
		JButton btnAddBtn = new JButton(string);
		btnAddBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CodenView cv = new CodenView();
				cv.addMyMouseListner(bookInfoP);
				cv.setVisible(true);
				setVisible(false);

			}
		});
		bookSearchView.getpContent().getpBtnSub().add(btnAddBtn);
	}

	public void setTableDate(Map<String, Object> param) {
		bookSearchView = new BookSearchView();
		bookSearchView.setMap(param);
		bookSearchView.loadTable();
		contentPane.add(bookSearchView);
	}
	//대여에서 창띄워서 검색 하는거 할라고
	public JPanel getContentPane() {
		return contentPane;
	}
	
}
