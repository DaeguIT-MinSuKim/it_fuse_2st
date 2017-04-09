package kr.or.dgit.book_project.ui.view;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.InformDetailPanel;
import kr.or.dgit.book_project.ui.component.MemberInfoP;
import kr.or.dgit.book_project.ui.table.MemberInfoSearchTable;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class MemberSearchMemberDetailViewFrame extends InformDetailPanel implements ActionListener {

	private MemberInfoP memberInfoP;	
	private MemberInfoSearchTable memberSearchTable;
	private MemberInfo memberinfo;

	public MemberSearchMemberDetailViewFrame() {		
		getBtnDel().addActionListener(this);
		getBtnModify().addActionListener(this);
		getBtnDel().setText("삭제");
		lblTitle.setText("- 회원정보 -");

		memberInfoP = new MemberInfoP();
		pContent.add(memberInfoP);
		setOption("- 회원정보 -", "탈퇴");
	}
	
	

	public MemberInfoP getMemberInfoP() {
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
		memberInfoP.setObject(memberSearchTable.getSelectedObject());			// 해당 회원 정보를 가져와서 회원정보 창에 set
		
		//MemberInfoService.getInstance().updateMemberInfo(memberinfo);			// 해당 회원의 정보를 수정 후, 수정 버튼 누르면 끝. 데이터가 바뀌는지 확인하기
		JOptionPane.showMessageDialog(null, "정보 수정이 완료되었습니다.");
	}
	
	protected void actionPerformedThisBtnDel(ActionEvent e) {
		
		int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","", JOptionPane.YES_NO_OPTION);
		if(res != 0){
			JOptionPane.showMessageDialog(null, "취소하였습니다.");
			return;
		}else {
			MemberInfoService.getInstance().delMemberInfo(memberinfo);
			JOptionPane.showMessageDialog(null, "삭제하였습니다.");
		}
	}
}
