package kr.or.dgit.book_project.ui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.InputComp;

public class SearchForID extends JFrame implements ActionListener {

	private JPanel contentPane;
	private InputComp pMName;
	private InputComp pMTel;
	private JButton btnEnter;
	private InputComp pMCodeForPW;
	private InputComp pMNameForPW;
	private InputComp pMTelForPW;
	private JButton btnEnterForPW;

	public SearchForID() {
		setTitle("회원정보 찾기");
		setBounds(100, 100, 450, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 394, 0 };
		gbl_contentPane.rowHeights = new int[] { 350, 400, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel pForID = new JPanel();
		pForID.setBorder(new TitledBorder(null, "회원번호 찾기", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pForID = new GridBagConstraints();
		gbc_pForID.weighty = 1.0;
		gbc_pForID.weightx = 1.0;
		gbc_pForID.fill = GridBagConstraints.BOTH;
		gbc_pForID.insets = new Insets(0, 0, 5, 0);
		gbc_pForID.gridx = 0;
		gbc_pForID.gridy = 0;
		contentPane.add(pForID, gbc_pForID);
		pForID.setLayout(new GridLayout(0, 1, 0, 10));

		pMName = new InputComp();
		pForID.add(pMName);
		pMName.setTitle("성명");

		pMTel = new InputComp();
		pForID.add(pMTel);
		pMTel.setTitle("연락처");

		JPanel panel_3 = new JPanel();
		pForID.add(panel_3);
		panel_3.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		btnEnter = new JButton("확인");
		btnEnter.addActionListener(this);
		panel_3.add(btnEnter);

		JPanel pForPW = new JPanel();
		pForPW.setBorder(new TitledBorder(null, "비밀번호 찾기", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pForPW = new GridBagConstraints();
		gbc_pForPW.weighty = 1.0;
		gbc_pForPW.weightx = 1.0;
		gbc_pForPW.fill = GridBagConstraints.BOTH;
		gbc_pForPW.gridx = 0;
		gbc_pForPW.gridy = 1;
		contentPane.add(pForPW, gbc_pForPW);
		pForPW.setLayout(new GridLayout(0, 1, 0, 10));

		pMCodeForPW = new InputComp();
		GridBagLayout gbl_pMCode = (GridBagLayout) pMCodeForPW.getLayout();
		gbl_pMCode.rowWeights = new double[] { 0.0 };
		gbl_pMCode.rowHeights = new int[] { 50 };
		gbl_pMCode.columnWeights = new double[] { 0.0, 0.0 };
		gbl_pMCode.columnWidths = new int[] { 100, 200 };
		pMCodeForPW.setTitle("회원코드");
		pForPW.add(pMCodeForPW);

		pMNameForPW = new InputComp();
		GridBagLayout gbl_pMNameForPW = (GridBagLayout) pMNameForPW.getLayout();
		gbl_pMNameForPW.rowWeights = new double[] { 0.0 };
		gbl_pMNameForPW.rowHeights = new int[] { 50 };
		gbl_pMNameForPW.columnWeights = new double[] { 0.0, 0.0 };
		gbl_pMNameForPW.columnWidths = new int[] { 100, 200 };
		pMNameForPW.setTitle("성명");
		pForPW.add(pMNameForPW);

		pMTelForPW = new InputComp();
		GridBagLayout gbl_pMTelForPW = (GridBagLayout) pMTelForPW.getLayout();
		gbl_pMTelForPW.rowWeights = new double[] { 0.0 };
		gbl_pMTelForPW.rowHeights = new int[] { 50 };
		gbl_pMTelForPW.columnWeights = new double[] { 0.0, 0.0 };
		gbl_pMTelForPW.columnWidths = new int[] { 100, 200 };
		pMTelForPW.setTitle("연락처");
		pForPW.add(pMTelForPW);

		JPanel panel_5 = new JPanel();
		pForPW.add(panel_5);
		panel_5.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		btnEnterForPW = new JButton("확인");
		btnEnterForPW.addActionListener(this);
		panel_5.add(btnEnterForPW);
	}

	public void ClearForID() {
		pMName.clear();
		pMTel.clear();
	}

	public void ClearForPW() {
		pMCodeForPW.clear();
		pMNameForPW.clear();
		pMTelForPW.clear();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnterForPW) {
			actionPerformedBtnEnterForPW(e);
		}
		if (e.getSource() == btnEnter) {
			actionPerformedBtnEnter(e);
		}
	}

	protected void actionPerformedBtnEnter(ActionEvent e) {
		// 회원번호 찾기
		if (!pMName.isEmpty() && !pMTel.isEmpty()) {
			MemberInfo code = new MemberInfo(null, pMName.getTFValue(), changePhoneNum(pMTel.getTFValue()));
			MemberInfo searchMember = MemberInfoService.getInstance().findMemberInfoByCode(code);
			if (searchMember == null) {
				JOptionPane.showMessageDialog(null, "일치하는 회원을 찾을 수 없습니다.");
				ClearForID();
				return;
			}
			JOptionPane.showMessageDialog(null,
					String.format("[ %s ] 회원님의 회원번호는 [ %s ] 입니다.", code.getmName(), searchMember.getmCode()));
			ClearForID();
		} else {
			JOptionPane.showMessageDialog(null, "공백이 존재합니다.");
		}
	}

	protected void actionPerformedBtnEnterForPW(ActionEvent e) {
		// 비밀번호 찾기
		if (!pMCodeForPW.isEmpty() && !pMNameForPW.isEmpty() && !pMTelForPW.isEmpty()) {
			MemberInfo code = new MemberInfo(pMCodeForPW.getTFValue(), pMNameForPW.getTFValue(), null);
			MemberInfo searchMember = MemberInfoService.getInstance().findMemberInfoByCode(code);
			if (searchMember == null) {
				JOptionPane.showMessageDialog(null, "일치하는 회원을 찾을 수 없습니다.");
				ClearForPW();
				return;
			}
			if (!pMTelForPW.getTFValue().equals(searchMember.getmTel())) {
				JOptionPane.showMessageDialog(null, "등록된 연락처와 일치하지 않습니다.");
				ClearForPW();
				return;
			}
			// 비밀번호 변경
			ChangePW changePW = new ChangePW();
			changePW.setMemberInfo(searchMember);
			changePW.setUpFrame(this);
			ClearForPW();
			changePW.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "공백이 존재합니다.");
		}
	}

	private String changePhoneNum(String PhoneNum) {
		// 전화번호 형식 맞추기
		String tel1 = null;
		String tel2 = null;
		String tel3 = null;
		if (PhoneNum.length() == 11) {
			tel1 = PhoneNum.substring(0, 3);
			tel2 = PhoneNum.substring(3, 7);
			tel3 = PhoneNum.substring(7, 11);
		} else if (PhoneNum.length() == 10) {
			tel1 = PhoneNum.substring(0, 3);
			tel2 = PhoneNum.substring(3, 6);
			tel3 = PhoneNum.substring(6, 10);
		}
		return String.format("%s-%s-%s", tel1, tel2, tel3);
	}
}
