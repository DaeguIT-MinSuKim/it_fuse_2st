package kr.or.dgit.book_project.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.setting.Config;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.common.PasswordPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PageAdminLogin extends JFrame {
	
	private JPanel contentPane;
	private PasswordPanel pPass;
	private InputComp pId;

	public PageAdminLogin() {
		setTitle("관리자 로그인");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 400, 350, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));
		
		pId = new InputComp();
		pId.setTitle("아이디");
		contentPane.add(pId);
		
		pPass = new PasswordPanel();
		pPass.getPwField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				keyPressedPPassPwField(arg0);
			}
		});
		pPass.setTitle("비밀번호");
		contentPane.add(pPass);
		
		JPanel pLogbtn = new JPanel();
		pLogbtn.setBorder(new EmptyBorder(0, 50, 0, 50));
		contentPane.add(pLogbtn);
		pLogbtn.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnLog = new JButton("로그인");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnLog(arg0);
			}
		});
		pLogbtn.add(btnLog);
	}
	
	public void clear(){
		pId.setTFValue("");
		pPass.getPwField().setText("");
	}
	
	protected void actionPerformedBtnLog(ActionEvent arg0) {
		// 로그인 버튼 누르기		
		loginCheck();
	}
	protected void keyPressedPPassPwField(KeyEvent arg0) {
		// 엔터키
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			loginCheck();
		}
	}
	
	private void loginCheck(){
		if(pId.getTFValue().equals(Config.DBMANAGER_ID)&&String.valueOf(pPass.getPwField().getPassword()).equals(Config.DBMANAGER_PWD)){
			JOptionPane.showMessageDialog(null, "관리자입니다");
			PageSetting ps = new PageSetting();
			ps.setVisible(true);
			setVisible(false);
		}else if(!pId.getTFValue().equals(Config.DBMANAGER_ID)){
			JOptionPane.showMessageDialog(null, "관리자가 아닙니다");
			clear();
			pId.getTF().requestFocus();
		}else if(pId.getTFValue().equals(Config.DBMANAGER_ID) && !String.valueOf(pPass.getPwField().getPassword()).equals(Config.DBMANAGER_PWD)){
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			clear();
			pId.getTF().requestFocus();
		}
	}
}
