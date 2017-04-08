package kr.or.dgit.book_project.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.BookInfoService;

public class BookSearchTable extends AbsTable<BookInfo> {
	public BookSearchTable() {
	}

	private Map<String, Object> map;

	private JPopupMenu popupMenu;

	@Override
	protected void createPopupMenu() {
	}

	@Override
	protected void updateData(BookInfo t) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void deleteItem(BookInfo t) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void cellWith() {
		// return new String[] { "도서코드","도서중복코드","도서명","저자","출판사","가격","총대여
		// 횟수"};
		tableSetWidth(50, 30, 250, 70, 100, 100);

	}

	@Override
	protected void CellAlign() {
		// tableCellAlignment(SwingConstants.CENTER, 0, 1);

	}

	@Override
	protected Object[][] getRowData() {
		List<BookInfo> list = BookInfoService.getInstance().selectAllBookInfo(map);
		if (list.isEmpty()) {
			//JOptionPane.showMessageDialog(null, "해당 데이터가 존재하지 않습니다.");
			return null;
		}
		Object[][] datas = new Object[list.size()][];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = list.get(i).toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getColumn() {
		return new String[] { "도서코드", "도서중복코드", "도서명", "저자", "출판사", "가격", "총대여 횟수" };
	}

	@Override
	public BookInfo getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1) {
			return null;
		}
		String bCode = (String) table.getValueAt(selectedIdx, 0);
		String bSubCode = (String) table.getValueAt(selectedIdx, 1);
		String bName = (String) table.getValueAt(selectedIdx, 2);
		String author = (String) table.getValueAt(selectedIdx, 3);
		String pubInfo = (String) table.getValueAt(selectedIdx, 4);
		int idx = pubInfo.indexOf("(");
		String publisher = pubInfo.substring(0, idx);
		String pCode = pubInfo.substring(idx + 1, pubInfo.length() - 1);
		PublisherInfo publisherInfo = new PublisherInfo();
		publisherInfo.setpCode(pCode);
		publisherInfo.setPublisher(publisher);
		int price = (int) table.getValueAt(selectedIdx, 5);
		int bLendCount = (int) table.getValueAt(selectedIdx, 6);
		return new BookInfo(bCode, bSubCode, bName, author, publisherInfo, price, bLendCount);
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
