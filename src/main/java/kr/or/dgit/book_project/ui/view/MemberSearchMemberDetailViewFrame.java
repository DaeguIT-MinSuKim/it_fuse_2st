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
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;

public class MemberSearchMemberDetailViewFrame extends InformDetailPanel implements ActionListener{

	private MemberInfoP memberInfoP;
	private MemberInfoSearchTable pTable;
	private MemberInfo memberinfo;
	private MemberSearchMemberDetailViewFrame memberInfoView;
	//private Map<String, Object> mapererer;
	private JFrame jf;

	public MemberSearchMemberDetailViewFrame() {
		getBtnDel().addActionListener(this);
		getBtnModify().addActionListener(this);
		getBtnDel().setText("삭제");
		lblTitle.setText("");

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
		pTable.setMap(param);
		// System.out.println("pTable 넘어왔니 여기는 멤버서치 : " + pTable);
		pTable.loadData();

		JOptionPane.showMessageDialog(null, "수정되었습니다.");
		jf.setVisible(false);
	}

	protected void actionPerformedThisBtnDel(ActionEvent e) {
		// 탈퇴 버튼을 눌렀을때
		if (memberinfo.getmNowCount() != 0) { 
			// 현재 대여중인 도서가 있을 때
			JOptionPane.showMessageDialog(null, "도서 대여중에는 탈퇴하실 수 없습니다.");
			return;
		} else {
			int res = JOptionPane.showConfirmDialog(null, "탈퇴하시겠습니까?", "", JOptionPane.YES_NO_OPTION); 
			if (res != 0) {
				JOptionPane.showMessageDialog(null, "취소하였습니다.");
				return;
			} else {
				MemberInfo mi = getPanel().getObject();
				mi.setSecsn(true);
				MemberInfoService.getInstance().delMemberInfo(mi);
				JOptionPane.showMessageDialog(null, "탈퇴하였습니다.");
				// 탈퇴한 회원 정보 날리기
				memberinfo = null;
				Map<String, Object> param = new HashMap<>();
				// param.put("isSecsn", false);
				pTable.setMap(param);
				pTable.loadData();
				jf.setVisible(false);
			}
		}
	}

	public void setpTable(MemberInfoSearchTable pTable) {
		this.pTable = pTable;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public void setMemberinfo(MemberInfo memberinfo) {
		this.memberinfo = memberinfo;
		getPanel().setObject(memberinfo);		// getSelectObject로  찾아서
		// Detail에
		// 정보
		// 심기
	}
	
	
	
	
	
		
		

}
