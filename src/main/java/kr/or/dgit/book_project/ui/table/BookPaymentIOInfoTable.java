package kr.or.dgit.book_project.ui.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.service.PaymentIOService;

public class BookPaymentIOInfoTable extends AbsTable<PaymentIO> {

	private Map<String, Object> param;
	private int dataCnt = 0;

	public BookPaymentIOInfoTable() {

	}

	

	@Override
	protected void cellWith() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);

	}

	@Override
	protected Object[][] getRowData() {
		List<PaymentIO> list = PaymentIOService.getInstance().selectAllPaymentIOInfo(param);
		dataCnt = list.size();
		Object[][] datas = new Object[list.size()][];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = list.get(i).toArrayForBook();
		}
		return datas;
	}

	@Override
	protected Object[] getColumn() {
		return new String[] { "회원코드", "성명", "대여일", "반납일", "연체여부" };
	}

	@Override
	public PaymentIO getSelectedObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public int getDataCnt() {
		return dataCnt;
	}

}
