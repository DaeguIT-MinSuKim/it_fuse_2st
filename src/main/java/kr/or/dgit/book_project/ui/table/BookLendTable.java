package kr.or.dgit.book_project.ui.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.BookInfoService;

public class BookLendTable extends AbsTable<BookInfo> {
	public BookLendTable() {
	}



	@Override
	protected void cellWith() {
		tableSetWidth(10, 10, 10, 10, 10, 10, 10);
		
	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0,1,2,3,4,5,6);		
	}

	@Override
	protected Object[][] getRowData() {
		Map<String, Object> param = new HashMap<>();
		param.put("isLending", false);
		param.put("isDel", false);
		List<BookInfo> bi = BookInfoService.getInstance().selectIslending(param);
		Object[][] datas = new Object[bi.size()][];
		for(int i =0; i< datas.length; i++){
			datas[i]= bi.get(i).toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getColumn() {
		return new String[]{"도서코드","도서중복코드","도서명","저자","출판사","가격","총대여 횟수"};
	}

	@Override
	public BookInfo getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1){
			return null;
		}
		String bCode = (String) table.getValueAt(selectedIdx, 0);
		String bSubCode = (String) table.getValueAt(selectedIdx, 1);
		Map<String, Object> hash= new HashMap<>();
		hash.put("bCode", bCode);
		hash.put("bSubCode", bSubCode);
		return BookInfoService.getInstance().selectBookInfoOne(hash);
	}

}
