package kr.or.dgit.book_project.ui.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.service.PaymentIOService;

public class MemberInfoTable extends AbsTable<MemberInfo> {
	
	private Map<String, Object> param;
	public void setParam(Map<String, Object> param) {
		this.param = param;
	}
	
	
	public MemberInfoTable() { 	}	
	
	@Override
	protected void createPopupMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateData(MemberInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void deleteItem(MemberInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cellWith() {
		tableSetWidth(80,50,100,50,200,100);
		
	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 1);		
	}

	@Override
	protected Object[][] getRowData() {		
		List<MemberInfo> list = MemberInfoService.getInstance().selectMemberByAll(param);// 회원 목록 검색해서 출력		
		
		Object[][] datas = new Object[list.size()][];
		for(int i=0; i<datas.length; i++){
			datas[i] = list.get(i).toArrayForMemberList();		// 검색결과 리스트 출력
		}
		return datas;
	}
	
	@Override
	protected Object[] getColumn() {
		return new String[] {"이름","회원코드","전화번호","우편번호","주소","대여금지일"};
	}

	@Override
	public MemberInfo getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1){
			return null;
		}
		String mCode = (String) table.getValueAt(selectedIdx, 1);
		MemberInfo memberinfo = new MemberInfo();
		memberinfo.setmCode(mCode);
		return MemberInfoService.getInstance().findMemberInfoByCode(memberinfo);
	}	
	
	
}
