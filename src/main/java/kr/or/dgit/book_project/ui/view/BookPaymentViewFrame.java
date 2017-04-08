package kr.or.dgit.book_project.ui.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.ui.common.PaymentDataDetail;
import kr.or.dgit.book_project.ui.table.BookPaymentIOInfoTable;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BookPaymentViewFrame extends JFrame {
	// 도서 대여현황 정보

	private JPanel contentPane;
	private BookPaymentIOInfoTable pTable;
	private JLabel label;
	private PaymentDataDetail bookPaymentDataDetail;

	public BookPaymentViewFrame() {
		setTitle("도서대여현황");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		bookPaymentDataDetail = new PaymentDataDetail();
		bookPaymentDataDetail.getpResult().setLayout(new BorderLayout(0, 10));

		pTable = new BookPaymentIOInfoTable();

		bookPaymentDataDetail.getpResult().add(pTable, BorderLayout.CENTER);

		JPanel pSum = new JPanel();
		pSum.setLayout(new GridLayout(0, 1, 0, 0));
		label = new JLabel();
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		pSum.add(label);
		bookPaymentDataDetail.getpResult().add(pSum, BorderLayout.SOUTH);
		contentPane.add(bookPaymentDataDetail);

	}

	public void setBookInfo(BookInfo bookInfo) {
		Map<String, Object> param = new HashMap<>();
		param.put("bCode", bookInfo.getbCode());
		param.put("bSubCode", bookInfo.getbSubCode());
		param.put("no", true); // 대여 기록이 있는 데이터만..
		pTable.setParam(param);
		pTable.loadData();
		setBLendCount();
		setFrameTitle(bookInfo.getbName(), bookInfo.getbCode(), String.format("%02d", Integer.parseInt(bookInfo.getbSubCode())));
	}
	
	public void setBLendCount(){
		label.setText(String.format("총 대여횟수 : %d회", pTable.getDataCnt()));
	}
	
	public void setFrameTitle(String bName, String bCode, String bSubCode){
		String lblTItle = String.format("<< %s(%s-%s) >> 대여현황", bName, bCode, bSubCode);
		bookPaymentDataDetail.getLblTitle().setText(lblTItle);
	}
}
