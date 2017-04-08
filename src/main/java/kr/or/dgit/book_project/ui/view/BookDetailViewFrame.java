package kr.or.dgit.book_project.ui.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.ui.common.InformDetailPanel;
import kr.or.dgit.book_project.ui.component.BookInfoBasic;

public class BookDetailViewFrame extends JFrame {
	// 도서 상세정보

	private JPanel contentPane;
	private BookInfoBasic bookInfoBasic;
	private InformDetailPanel bookInformDetailPanel;

	public BookDetailViewFrame() {
		setTitle("도서정보");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		bookInformDetailPanel = new InformDetailPanel();
		bookInformDetailPanel.setOption("- 도서정보 -", "폐기");
		bookInfoBasic = new BookInfoBasic();
		bookInfoBasic.setEnable(false);
		bookInformDetailPanel.getpContent().add(bookInfoBasic);
		contentPane.add(bookInformDetailPanel);
	}

	public void setBookDetailInfo(BookInfo bookInfo) {
		bookInfoBasic.setObject(bookInfo);
	}

	public void setMyActionLister(AbsBookSearchView bookManageView) {
		bookInformDetailPanel.getBtnModify().addActionListener(new ActionListener() {

			// 수정버튼 동작
			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfoService.getInstance().updateBookInfo(bookInfoBasic.getObject());
				bookManageView.loadTable();
			}
		});

		bookInformDetailPanel.getBtnDel().addActionListener(new ActionListener() {
			// 폐기 버튼 동작
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "해당도서를 폐기하시겠습니까", "", JOptionPane.YES_NO_OPTION);
				if (res != 0) {
					JOptionPane.showMessageDialog(null, "취소하였습니다");
					return;
				}
				BookInfoService.getInstance().setDelBookInfo(bookInfoBasic.getObject(), true);
				bookManageView.loadTable();
			}
		});
	}

}
