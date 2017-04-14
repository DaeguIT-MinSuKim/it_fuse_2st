package kr.or.dgit.book_project.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.PublisherInfoService;

@SuppressWarnings("serial")
public class PublisherInfoTable extends AbsTable<PublisherInfo> {
	
	
	public Object getSelectedObject;

	public PublisherInfoTable() {
		loadData();
	}

	

	@Override
	protected void cellWith() {
		tableSetWidth(50, 80, 50, 50, 50, 170, 50);

	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
	}

	@Override
	public Object[][] getRowData() {
		List<PublisherInfo> pub = PublisherInfoService.getInstance().selectByAll();
		Object[][] datas = new Object[pub.size()][];
		for(int i=0; i<datas.length;i++){
			datas[i] = pub.get(i).toArrayForPublisherList();
		}
		return datas;
	}

	@Override
	protected Object[] getColumn() {
		return new String[] {"출판사코드","출판사명","담당자명","연락처","우편번호","주소","상세주소"};
	}

	@Override
	public PublisherInfo getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if(selectedIdx == -1){
			return null;
		}

		String pCode = (String) table.getValueAt(selectedIdx, 0);
		String publisher = (String) table.getValueAt(selectedIdx, 1);
		String pName = (String) table.getValueAt(selectedIdx, 2);
		String pTel = (String) table.getValueAt(selectedIdx, 3);
		String	pZipCode = (String) table.getValueAt(selectedIdx, 4);
		String	pAddress = (String) table.getValueAt(selectedIdx, 5);
		String pAddDetail = (String) table.getValueAt(selectedIdx, 6);
		//return new PublisherInfo(pCode, publisher, pName, pTel, Integer.parseInt(pZipCode), pAddress);
		return new PublisherInfo(pCode, publisher, pName, pTel, pZipCode, pAddress, pAddDetail);
	}

	

}
