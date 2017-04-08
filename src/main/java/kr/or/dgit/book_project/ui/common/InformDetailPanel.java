package kr.or.dgit.book_project.ui.common;

import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class InformDetailPanel extends JPanel {

	protected JLabel lblTitle;
	protected JPanel pContent;
	protected JButton btnDel;
	protected JButton btnModify;

	public InformDetailPanel() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel pTitle = new JPanel();
		panel.add(pTitle, BorderLayout.NORTH);
		FlowLayout flowLayout = (FlowLayout) pTitle.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);

		lblTitle = new JLabel("New label");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 15));
		lblTitle.setBounds(new Rectangle(20, 20, 0, 0));
		pTitle.add(lblTitle);

		pContent = new JPanel();
		panel.add(pContent);
		pContent.setLayout(new GridLayout(1, 0, 0, 0));
		JPanel idp1 = new JPanel();
		idp1.setBorder(new EmptyBorder(10, 100, 10, 100));
		panel.add(idp1, BorderLayout.SOUTH);
		idp1.setLayout(new GridLayout(1, 1, 20, 0));

		btnModify = new JButton("수정");
		idp1.add(btnModify);

		btnDel = new JButton("버튼");
		idp1.add(btnDel);

	}

	public void setOption(String title, String button) {
		lblTitle.setText(title);
		btnDel.setText(button);
	}

	public JPanel getpContent() {
		return pContent;
	}

	public JButton getBtnDel() {
		return btnDel;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

}