package kr.or.dgit.book_project.ui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.service.BookInfoService;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class BookSearchViewFrame extends JFrame {

	private JPanel contentPane;
	private BookSearchView bookSearchView;
	private BookInsertView bookInsertView;

	public BookSearchViewFrame() {
		super("도서검색");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		bookSearchView = new BookSearchView();
		contentPane.add(bookSearchView);
	}

	public void setBookInsertView(BookInsertView bookInsertView) {
		this.bookInsertView = bookInsertView;
	}

	public void addBtn(String string) {
		JButton btnAddBtn = new JButton(string);
		bookSearchView.getpContent().getpBtnSub().add(btnAddBtn);
		btnAddBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CodenView cv = new CodenView();
				cv.addMyMouseListner(bookInsertView);
				cv.setVisible(true);
				setVisible(false);
			}

		});

	}

	public void setMyMouseListener(JPanel myPanel) {
		bookSearchView.getpTable().getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					BookInfo bi = bookSearchView.getpTable().getSelectedObject();
					System.out.println(bi.toString());
					Map<String, Object> param = new HashMap<>();
					param.put("bCode", bi.getbCode());
					int cnt = BookInfoService.getInstance().countBookInfo(param);
					bookInsertView.getpContent().getpBCode().setTfBCode(bi.getbCode());
					bookInsertView.getpContent().getpBCode().setTfBSubCode(cnt + "");
					bookInsertView.getpContent().getpBName().setTFValue(bi.getbName());
					bookInsertView.getpContent().getpAuthor().setTFValue(bi.getAuthor());
					bookInsertView.getpContent().getpPrice().setValue(bi.getPrice());
					bookInsertView.getpContent().getpPublisher().setSelectedTT(bi.getPublisherInfo());
					setVisible(false);
					
					
					
				}
			}

		});
	}

}
