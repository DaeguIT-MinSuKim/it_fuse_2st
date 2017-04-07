package kr.or.dgit.book_project.ui.common;

import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

public class AbsViewPanel extends JPanel {

	public JPanel pMain;

	public AbsViewPanel() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setBounds(new Rectangle(0, 0, 775, 600));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pMain = new JPanel();
		add(pMain);
		pMain.setLayout(new GridLayout(0, 1, 0, 0));
	}
}
