package kr.or.dgit.book_project.ui.component;

import javax.swing.JPanel;

import kr.or.dgit.book_project.ui.common.InputComp;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class CodenP extends JPanel {

	/**
	 * Create the panel.
	 */
	public CodenP() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelC = new JPanel();
		add(panelC);
		panelC.setLayout(new GridLayout(4, 1, 0, 10));
		
		JPanel pPanel = new JPanel();
		panelC.add(pPanel);
		
		InputComp pCName = new InputComp();
		pCName.setTitle("분      류");
		panelC.add(pCName);
		
		InputComp pCCode = new InputComp();
		pCCode.setTitle("코      드");
		panelC.add(pCCode);
		
		JPanel pCodenBtn = new JPanel();
		panelC.add(pCodenBtn);
		pCodenBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSave = new JButton("저장");
		pCodenBtn.add(btnSave);
		
		JButton btnCancel = new JButton("취소");
		pCodenBtn.add(btnCancel);

	}

}
