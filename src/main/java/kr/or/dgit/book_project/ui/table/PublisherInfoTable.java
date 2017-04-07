package kr.or.dgit.book_project.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.PublisherInfoService;

public class PublisherInfoTable extends AbsTable<PublisherInfo> {
	
	
	public PublisherInfoTable() {
		loadData();
	}

	@Override
	protected void createPopupMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateData(PublisherInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void deleteItem(PublisherInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cellWith() {
	tableSetWidth(50,80,50,50,50,220);
		
	}

	@Override
	protected void CellAlign() {
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
		return new String[] {"출판사코드","출판사명","담당자명","연락처","우편번호","주소"};
	}

	@Override
	public PublisherInfo getSelectedObject() {
		/*int selectedIdx = table.getSelectedRow();
		if(selectedIdx == -1){
			return null;
		}
		String pub = (String) table.getValueAt(selectedIdx, 0);
		PublisherInfo pu = PublisherInfoService.getInstance().selectPublisherInfo(new PublisherInfo());*/
		return null;
	}

	

}
