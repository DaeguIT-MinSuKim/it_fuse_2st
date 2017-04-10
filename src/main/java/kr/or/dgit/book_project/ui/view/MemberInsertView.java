package kr.or.dgit.book_project.ui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.MemberInfoP;
import kr.or.dgit.book_project.ui.table.MemberInfoSearchTable;
import kr.or.dgit.book_project.ui.table.MemberInfoTable;

public class MemberInsertView extends AbsViewPanel implements ActionListener {

	private JButton btnCancel;
	private JButton btnSave;
	private MemberInfoP memberInfoP;
	private MemberInfoTable pTable;
	private MemberInfoSearchTable memberInfoSesrchTable;

	public MemberInsertView() {
		JPanel panel_5 = new JPanel();
		pMain.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 735, 0 };
		gbl_panel_5.rowHeights = new int[] { 300, 80, 200, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_5.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		memberInfoP = new MemberInfoP();
		panel.add(memberInfoP);

		JPanel pBtn = new JPanel();
		GridBagConstraints gbc_pBtn = new GridBagConstraints();
		gbc_pBtn.weighty = 1.0;
		gbc_pBtn.weightx = 1.0;
		gbc_pBtn.fill = GridBagConstraints.BOTH;
		gbc_pBtn.insets = new Insets(0, 0, 5, 0);
		gbc_pBtn.gridx = 0;
		gbc_pBtn.gridy = 1;
		panel_5.add(pBtn, gbc_pBtn);
		pBtn.setLayout(new GridLayout(1, 0, 10, 0));

		JPanel panel_7 = new JPanel();
		pBtn.add(panel_7);

		JPanel panel_6 = new JPanel();
		pBtn.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 10, 0));

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		panel_6.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);

		panel_6.add(btnCancel);

		JPanel panel_8 = new JPanel();
		pBtn.add(panel_8);

		pTable = new MemberInfoTable();
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.weighty = 1.0;
		gbc_pTable.weightx = 1.0;
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 2;
		panel_5.add(pTable, gbc_pTable);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}

	// 우편번호 더블클릭 시, 주소 검색 창 오픈시켜야 함. (툴팁으로 힌트주기)

	protected void actionPerformedBtnSave(ActionEvent e) {		// 회원등록

		if (memberInfoP.isVaildCheck()) { // 중복체크 해야함.....
			memberInfoP.getObject();			
			MemberInfoService.getInstance().insertMemberInfo(memberInfoP.getObject()); // 입력받은 회원 정보 입력하기
			JOptionPane.showMessageDialog(null, "회원으로 등록되었습니다.");
			memberInfoP.setClear();
			setMcodeAuto();

			Map<String, Object> param = new HashMap<>();
			param.put("mCode", memberInfoP.getObject().getmCode());/*
			param.put("mName", memberInfoP.getObject().getmName());
			param.put("mPass", memberInfoP.getObject().getmPass());
			param.put("mTel", memberInfoP.getObject().getmTel());*/
			pTable.setMap(param);
			pTable.loadData();
			// 테이블에 목록을 어디로 불러온다냐...
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		memberInfoP.setClear(); // 취소버튼
	}

	public void setMcodeAuto() { // 회원코드 자동으로 넣어주기
		MemberInfo memberInfoInit = new MemberInfo();
		MemberInfo memberInfo = MemberInfoService.getInstance().insertMcodeAuto(memberInfoInit);
		memberInfoP.getpMCode().setTFValue(memberInfo.getmCode());	
		//memberInfoP.getpMCode().getTF().setEditable(false);
		memberInfoP.getpMName().getTF().requestFocus();			// 포커스 안된다.
		
		
	}	

}
