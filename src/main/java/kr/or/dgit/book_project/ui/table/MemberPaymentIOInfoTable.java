package kr.or.dgit.book_project.ui.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.service.PaymentIOService;

public class MemberPaymentIOInfoTable extends AbsTable<PaymentIO> {

	private int allCnt = 0; // 총 이용권수
	private int allDelayCnt = 0; // 총 연체권수
	private int lendCnt = 0; // 현재 대여권수
	private int lendDelayCnt = 0; // 대여도서 중 연체권수
	private int returnCnt = 0; // 현재 반납권수
	private int returnDelayCnt = 0; // 반납도서 중 연체권수

	public MemberPaymentIOInfoTable() {

	}

	@Override
	protected void createPopupMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void updateData(PaymentIO t) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void deleteItem(PaymentIO t) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void cellWith() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void CellAlign() {
		// TODO Auto-generated method stub

	}

	@Override
	protected Object[][] getRowData() {
		List<PaymentIO> list = PaymentIOService.getInstance().selectAllPaymentIOInfo(map);
		allCnt = list.size();
		Object[][] datas = new Object[list.size()][];
		for (int i = 0; i < datas.length; i++) {
			setCnt(list.get(i)); // 해당 권수 세는 메소드
			datas[i] = list.get(i).toArrayForMember();
		}
		return datas;
	}

	@Override
	protected Object[] getColumn() {
		return new String[] { "도서코드", "도서중복코드", "도서명", "대여일", "반납일", "연체여부" };
	}

	@Override
	public PaymentIO getSelectedObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setCnt(PaymentIO memberPaymentIO) {
		if (memberPaymentIO.getReturnDate() == null) {
			// 대여 중
			lendCnt++;
			if (memberPaymentIO.isDelay()) {
				// 대여도서 중 연체
				lendDelayCnt++;
				allDelayCnt++;
			}
		} else {
			// 반납도서
			returnCnt++;
			if (memberPaymentIO.isDelay()) {
				// 반납도서 중 연체
				returnDelayCnt++;
				allDelayCnt++;
			}
		}
	}

	public int[] getArrayCnt(){
		return new int[]{allCnt, allDelayCnt, lendCnt, lendDelayCnt, returnCnt, returnDelayCnt};
	}

}
