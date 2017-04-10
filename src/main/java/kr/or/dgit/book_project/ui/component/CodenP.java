package kr.or.dgit.book_project.ui.component;

import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.CodenService;
import kr.or.dgit.book_project.service.PublisherInfoService;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.view.CodenManageView;
import kr.or.dgit.book_project.ui.view.CodenView;
import kr.or.dgit.book_project.ui.view.PublisherView;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CodenP extends JPanel implements ActionListener {

	public JButton btnCodenSave;
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

		btnCodenSave = new JButton("저장");
		btnCodenSave.addActionListener(this);
		pCodenBtn.add(btnCodenSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pCodenBtn.add(btnCancel);
	}
	

	public JButton getBtnCodenSave() {
		return btnCodenSave;
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

	public Coden getCodenObject() {
		String cName = pCName.getTFValue();
		String cCode = pCCode.getTFValue();
		return new Coden(cName, cCode);
	}
	public void setCodenObject(Coden codenItem){
		pCCode.setTFValue(codenItem.getcCode());
		pCName.setTFValue(codenItem.getcName());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCodenSave) {
			actionPerformedBtnCodenSave(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clear();
		btnCodenSave.setText("저장");
	}

	protected void actionPerformedBtnCodenSave(ActionEvent e) {
		if (btnCodenSave.getText() == "저장") {
			if (isVaildCheck()) {
				CodenService.getInstance().insertCoden(getCodenObject());
				JOptionPane.showMessageDialog(null, "등록완료");
				clear();
				CodenManageView.pTable.loadData();
			}
		} else if (btnCodenSave.getText() == "수정") {
				CodenService.getInstance().updateCoden(getCodenObject());
				JOptionPane.showMessageDialog(null, "수정완료");
				clear();
				CodenManageView.pTable.loadData();
				btnCodenSave.setText("저장");
			
		}
	}
}
