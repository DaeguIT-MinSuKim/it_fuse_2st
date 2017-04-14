package kr.or.dgit.book_project.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.setting.InitSettingService;

public class PageSetting extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	public PageSetting() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 400, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 0, 5, 0));
		setContentPane(contentPane);

		btnNewButton = new JButton("초기화");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("백업");
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("복원");
		btnNewButton_2.addActionListener(this);
		contentPane.add(btnNewButton_2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(e);
		}
	}

	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		InitSettingService init = new InitSettingService();
		init.initSetting(0, 1); // 초기화
	}

	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		InitSettingService init = new InitSettingService();
		init.initSetting(1, 0); // 백업
	}

	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		InitSettingService init = new InitSettingService();
		init.initSetting(1, 1); // 복원
	}

	

}
