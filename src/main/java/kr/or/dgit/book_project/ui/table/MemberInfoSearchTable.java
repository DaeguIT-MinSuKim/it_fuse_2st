package kr.or.dgit.book_project.ui.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.SwingConstants;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.service.PaymentIOService;

public class MemberInfoSearchTable extends AbsTable<MemberInfo> {

	private Map<String, Object> param;

	public MemberInfoSearchTable() {
		loadData();
	}

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
		tableSetWidth(80, 50, 100, 50, 200, 100);

	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 1);

	}

	@Override
	protected Object[][] getRowData() {
		List<MemberInfo> list = MemberInfoService.getInstance().selectMemberByAll(param);
		Object[][] datas = new Object[list.size()][];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = list.get(i).toArrayForMemberList();
		}
		return datas;
	}
	

	@Override
	protected Object[] getColumn() {
		return new String[] { "이름", "회원코드", "전화번호", "우편번호", "주소", "대여금지일" };
	}

	@Override
	public MemberInfo getSelectedObject() {
		int selectedIdx = table.getSelectedRow();	// 선택된 로우의 값을 받아옴.
		if (selectedIdx == -1) {
			return null;
		}
		String mCode = (String) table.getValueAt(selectedIdx, 1); //셀렉트된 row의 두번째 컬럼값을 받아옴(검색할조건이 있는 컬럼위치)
		MemberInfo memberinfo = new MemberInfo();
		memberinfo.setmCode(mCode);		//테이블에서 받아온값을 넣어줌
		return MemberInfoService.getInstance().findMemberInfoByCode(memberinfo);		//가져온 코드값으로 select문 멤버인포타입으로 리턴
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}	

}
