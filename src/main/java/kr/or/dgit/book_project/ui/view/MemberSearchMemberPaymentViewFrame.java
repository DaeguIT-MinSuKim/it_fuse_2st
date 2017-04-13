package kr.or.dgit.book_project.ui.view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.ui.common.PaymentDataDetail;
import kr.or.dgit.book_project.ui.table.MemberPaymentIOInfoTable;
import java.awt.Color;

public class MemberSearchMemberPaymentViewFrame extends PaymentDataDetail {

	private JLabel lblreturnBook;
	private JLabel lblLendBook;
	private JLabel lblAllBook;
	private MemberPaymentIOInfoTable pTable;

	public MemberSearchMemberPaymentViewFrame() {
		lblTitle.setText("- 회원대여정보 -");

		pTable = new MemberPaymentIOInfoTable();
		pResult.add(pTable);

		JPanel pSum = new JPanel();
		pSum.setLayout(new GridLayout(0, 1, 0, 0));

		pResult.add(pSum);

		lblreturnBook = new JLabel("label");
		pSum.add(lblreturnBook);

		lblLendBook = new JLabel("New label");
		pSum.add(lblLendBook);

		lblAllBook = new JLabel("New label");
		pSum.add(lblAllBook);

	}

	public void loadTable(MemberInfo memberInfo) {
		Map<String, Object> param = new HashMap<>();
		param.put("no", "no");
		param.put("mCode", memberInfo.getmCode());
		pTable.setMap(param);
		pTable.loadData();
		setPSum(pTable.getArrayCnt());
	}

	public void setPSum(int[] cntArray) {
		int allCnt = cntArray[0]; // 총 이용권수
		int allDelayCnt = cntArray[1]; // 총 연체권수
		int lendCnt = cntArray[2]; // 현재 대여권수
		int lendDelayCnt = cntArray[3]; // 대여도서 중 연체권수
		int returnCnt = cntArray[4]; // 현재 반납권수
		int returnDelayCnt = cntArray[5]; // 반납도서 중 연체권수

		String text = String.format("총계 : %n반납된 도서 : %d권 (연체 : %d권),", returnCnt, returnDelayCnt);
		lblreturnBook.setText(text);
		if( lendDelayCnt != 0 ){
			String text1 = String.format("\t대출중 도서: %d권(연체 : %d권), 연체중인 도서가 있습니다", lendCnt, lendDelayCnt);
			lblLendBook.setForeground(Color.RED);
			lblLendBook.setText(text1);
		}else{
		String text1 = String.format("\t대출중 도서: %d권(연체 : %d권),", lendCnt, lendDelayCnt);
		lblLendBook.setForeground(Color.BLACK);
		lblLendBook.setText(text1);
		}
		String text2 = String.format("\t총 이용도서: %d권(연체 : %d권)", allCnt, allDelayCnt);
		lblAllBook.setText(text2);
	}


}
