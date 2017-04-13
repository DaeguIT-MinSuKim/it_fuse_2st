package kr.or.dgit.book_project.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class SideBar extends JPanel {

	protected JButton btnMenu0;
	protected JButton btnMenu1;
	protected JButton btnMenu2;
	protected JButton btnMenu3;
	protected JButton btnMenu4;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel pBtn;
	private JPanel panel_1;

	public SideBar() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pMenu = new JPanel();
		add(pMenu);
		pMenu.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		pMenu.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("회원님 접속중");
		panel.add(lblNewLabel, BorderLayout.NORTH);

		btnMenu4 = new JButton("로그아웃");
		panel.add(btnMenu4);

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		pBtn = new JPanel();
		pMenu.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 1, 0, 10));

		btnMenu0 = new JButton("자료관리");
		pBtn.add(btnMenu0);

		btnMenu1 = new JButton("멤버관리");
		pBtn.add(btnMenu1);

		btnMenu2 = new JButton("출납관리");
		pBtn.add(btnMenu2);

		btnMenu3 = new JButton("출납통계");
		pBtn.add(btnMenu3);
	}
	
	public JButton getBtnMenu4() {
		return btnMenu4;
	}

	public void setBtnMenu4(JButton btnMenu4) {
		this.btnMenu4 = btnMenu4;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	
	

}
