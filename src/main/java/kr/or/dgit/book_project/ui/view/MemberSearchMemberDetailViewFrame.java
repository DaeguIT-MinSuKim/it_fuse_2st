package kr.or.dgit.book_project.ui.view;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.InformDetailPanel;
import kr.or.dgit.book_project.ui.component.MemberInfoP;
import kr.or.dgit.book_project.ui.table.MemberInfoSearchTable;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class MemberSearchMemberDetailViewFrame extends InformDetailPanel implements ActionListener {

	private MemberInfoP memberInfoP;	
	private MemberInfoSearchTable pTable;
	private MemberInfo memberinfo;
	private MemberSearchMemberDetailViewFrame memberInfoView;
	private Map<String, Object> map;

	public MemberSearchMemberDetailViewFrame() {		
		getBtnDel().addActionListener(this);
		getBtnModify().addActionListener(this);
		getBtnDel().setText("삭제");
		lblTitle.setText("- 회원정보 -");

		memberInfoP = new MemberInfoP();
		pContent.add(memberInfoP);
		setOption("- 회원정보 -", "탈퇴");
	}

	public MemberInfoP getPanel() {
		return memberInfoP;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnDel()) {
			actionPerformedThisBtnDel(e);
		}
		if (e.getSource() == getBtnModify()) {
			actionPerformedThisBtnModify(e);
		}
	}
	protected void actionPerformedThisBtnModify(ActionEvent e) {
		
		Map<String, Object> param = new HashMap<>();
		MemberInfoService.getInstance().updateMemberInfo(getPanel().getObject());// 해당 회원의 정보를 수정 후, 수정 버튼 누르면 끝. 데이터가 바뀌는지 확인하기		
		pTable.setParam(param);
		pTable.loadData();
		
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
		setVisible(false);
	}

	protected void actionPerformedThisBtnDel(ActionEvent e) {

		int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","", JOptionPane.YES_NO_OPTION);
		if(res != 0){
			JOptionPane.showMessageDialog(null, "취소하였습니다.");
			return;
		}else {
			MemberInfoService.getInstance().delMemberInfo(memberInfoView.getPanel().getObject());
			JOptionPane.showMessageDialog(null, "삭제하였습니다.");
		}
	}




}

