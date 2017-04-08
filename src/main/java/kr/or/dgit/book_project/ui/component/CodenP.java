package kr.or.dgit.book_project.ui.component;

import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.CodenService;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.view.CodenManageView;
import kr.or.dgit.book_project.ui.view.CodenView;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CodenP extends JPanel implements ActionListener {

	private JButton btnSave;
	private JButton btnCancel;
	private InputComp pCName;
	private InputComp pCCode;

	public CodenP() {
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelC = new JPanel();
		add(panelC);
		panelC.setLayout(new GridLayout(4, 1, 0, 10));

		JPanel pPanel = new JPanel();
		panelC.add(pPanel);

		pCName = new InputComp();
		pCName.setTitle("분      류");
		panelC.add(pCName);

		pCCode = new InputComp();
		pCCode.setTitle("코      드");
		panelC.add(pCCode);

		JPanel pCodenBtn = new JPanel();
		panelC.add(pCodenBtn);
		pCodenBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pCodenBtn.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pCodenBtn.add(btnCancel);
	}

	public void clear() {
		pCName.setTFValue("");
		pCCode.setTFValue("");
	}

	public boolean isVaildCheck() {
		try {
			pCName.isEmptyCheck();
			pCCode.isEmptyCheck();
			pCCode.isValidCheck("[A-Z]", "코드는 영문대문자 가능");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public Coden getObject() {
		String cName = pCName.getTFValue();
		String cCode = pCCode.getTFValue();
		return new Coden(cName, cCode);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clear();
	}

	protected void actionPerformedBtnSave(ActionEvent e) {
		if (isVaildCheck()) {
			CodenService.insertCoden(getObject());
			JOptionPane.showMessageDialog(null, "등록완료");
			clear();
			CodenManageView.pTable.loadData();
		}
	}
}
