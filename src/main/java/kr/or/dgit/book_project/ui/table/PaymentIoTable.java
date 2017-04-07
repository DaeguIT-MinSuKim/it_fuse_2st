package kr.or.dgit.book_project.ui.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.PaymentIOService;

public class PaymentIoTable extends AbsTable<PaymentIO> {

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
		/*정렬하는거 아직 뎃츠 ㄴㄴ*/
		/*tableSetWidth(50, 30, 250, 70, 100, 100);*/
		
	}

	@Override
	protected void CellAlign() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object[][] getRowData() {
		Map<String, Object> param = new HashMap<>();
		param.put("returnNull", "returnNull");
		List<PaymentIO> list = PaymentIOService.getInstance().selectAllPaymentIOInfo(param);
		Object[][] datas = new Object[list.size()][];
		for(int i = 0; i<datas.length; i++){
			datas[i] = list.get(i).toArrayPayment();
		}
		return datas;
	}

	@Override
	protected Object[] getColumn() {
		return new String[]{"도서코드","도서중복코드","도서명","회원코드","회원명","대여일","연체여부"};
	}

	@Override
	public PaymentIO getSelectedObject() {
		/*int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1){
			return null;
		}
		String bCode = (String) table.getValueAt(selectedIdx, 0);
		String bSubCode = (String) table.getValueAt(selectedIdx, 1);
		Map<String, Object> param= new HashMap<>();
		param.put("bCode", bCode);
		param.put("bSubCode", bSubCode);
		return PaymentIOService.getInstance().selectAllPaymentIOInfo(param);*/
		return null;
	}

}
