package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_prject.setting.InitSettingService;
import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.common.PasswordPanel;
import kr.or.dgit.book_project.ui.view.SearchForID;

public class PageLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Object ActionEvent;
	private PageSub sub;
	private JButton btnEnter;
	private InputComp pID;
	private PasswordPanel pPW;
	private JButton btnPWSearch;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		} catch (Exception e) {
		}
		PageLogin frame = new PageLogin();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PageLogin frame = new PageLogin();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PageLogin() {
		setBackground(Color.WHITE);
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 500, 510);

		appearInTheCenter();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		String path = "icon/book-20-240.png";
		JPanel pImage = new JPanel(new BorderLayout());
		JLabel label = new JLabel(new ImageIcon(path));
		label.setHorizontalAlignment(JLabel.CENTER);
		pImage.add(label);
		contentPane.add(pImage);

		JPanel pLogin = new JPanel();
		pLogin.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(pLogin);
		pLogin.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pLoginInsert = new JPanel();
		pLogin.add(pLoginInsert);
		GridBagLayout gbl_pLoginInsert = new GridBagLayout();
		gbl_pLoginInsert.columnWidths = new int[] { 380, 120, 0 };
		gbl_pLoginInsert.rowHeights = new int[] { 80, 0 };
		gbl_pLoginInsert.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_pLoginInsert.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pLoginInsert.setLayout(gbl_pLoginInsert);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.weightx = 1.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		pLoginInsert.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 5));

		pID = new InputComp();
		panel_1.add(pID);
		pID.setTitle("회원코드");

		pPW = new PasswordPanel();
		panel_1.add(pPW);
		pPW.setTitle("비밀번호");

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.weighty = 1.0;
		gbc_panel_3.weightx = 1.0;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		pLoginInsert.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		btnEnter = new JButton("로그인");
		btnEnter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getSource() == btnEnter) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						myLogin();
					}
				}
			}

		});
		btnEnter.addActionListener(this);
		panel_3.add(btnEnter);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 50, 5, 50));
		pLogin.add(panel);
		panel.setLayout(new GridLayout(0, 1, 10, 0));

		btnPWSearch = new JButton("회원코드 / 비밀번호 찾기");
		btnPWSearch.addActionListener(this);
		panel.add(btnPWSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 50, 0, 50));
		pLogin.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton = new JButton("초기화");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnNewButton(arg0);
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("백업");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_1(e);
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("복원");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_2(e);
			}
		});
		panel_2.add(btnNewButton_2);

	}

	private void appearInTheCenter() {
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPWSearch) {
			actionPerformedBtnPWSearch(e);
		}
		if (e.getSource() == btnEnter) {
			actionPerformedBtnEnter(e);
		}
	}

	public void actionPerformedBtnEnter(ActionEvent e) {
		myLogin();

	}

	private void myLogin() {
		String id = pID.getTFValue(); // 입력받은 ID
		String pw = String.valueOf(pPW.getPwField().getPassword());// 입력받은 PW
		MemberInfo visitMember = new MemberInfo();
		visitMember.setmCode(id);
		visitMember.setmPass(pw);

		// 로그인 버튼을 눌렀을때
		MemberInfo ourMember = MemberInfoService.getInstance().findMemberInfoByCode(new MemberInfo(id));
		if (ourMember == null) {
			JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않습니다");
			pID.clear();// 텍스트필드 초기화
			pID.getTF().requestFocus(); // 회원번호 텍스트에 포커스
		} else if (ourMember != null) {
			if (ourMember.isSecsn()) {
				// 탈퇴 회원
				JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않습니다");
			} else if (!MemberInfoService.getInstance().confirmPW(visitMember)) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
				pPW.getPwField().setText("");// 텍스트필드 초기화
				pPW.getPwField().requestFocus(); // 비밀번호텍스트에 포커스
			} else if (MemberInfoService.getInstance().confirmPW(visitMember)) {
				// 화면을 띄움
				JOptionPane.showMessageDialog(null, "[ " + ourMember.getmName() + " ] 님의 방문을 환영합니다.");
				showMainContent(ourMember);
			}
		}
	}

	public void showMainContent(MemberInfo ourMemberInfo) {
		switch (ourMemberInfo.getmGroup()) {
		case 'A':
			// 관리자..직원메뉴까지 볼수있음
		case 'B':
			// 사서.... 직원메뉴 제외 전부 볼 수 있음..
			PageSub pageSub = new PageSub();
			pageSub.setMemberInfo(ourMemberInfo);
			pageSub.getpTabSub().add(new SubMenuPage0());
			pageSub.setVisible(true);
			setVisible(false);
			break;
		case 'C':
			// 일반회원.... 뭘 해야되지.....
			PageSubForCgroup pageSubForCgroup = new PageSubForCgroup();
			pageSubForCgroup.setMemberInfo(ourMemberInfo);
			pageSubForCgroup.setVisible(true);
			setVisible(false);
			break;
		default:
			break;
		}
	}

	protected void actionPerformedBtnPWSearch(ActionEvent e) {
		// 회원코드 찾기 / 비밀번호 재발급
		SearchForID searchForID = new SearchForID();
		searchForID.setVisible(true);
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
