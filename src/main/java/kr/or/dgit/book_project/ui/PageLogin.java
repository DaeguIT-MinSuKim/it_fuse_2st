package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.common.PasswordPanel;

public class PageLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Object ActionEvent;
	private PageSub sub;
	private JButton btnEnter;
	private InputComp pID;
	private PasswordPanel pPW;

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
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 500, 400);

		appearInTheCenter();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		String path = "icon/bookImage.png"; // 경로를 어떻게...
		JPanel pImage = new JPanel(new BorderLayout());
		JLabel label = new JLabel(new ImageIcon(path));
		label.setHorizontalAlignment(JLabel.CENTER);
		pImage.add(label); // default center section
		contentPane.add(pImage);

		JPanel pLogin = new JPanel();
		pLogin.setBorder(new EmptyBorder(40, 10, 40, 10));
		contentPane.add(pLogin);
		pLogin.setLayout(new BorderLayout(20, 20));

		JPanel pLoginInsert = new JPanel();
		pLogin.add(pLoginInsert);
		pLoginInsert.setLayout(new GridLayout(0, 1, 0, 20));

		pID = new InputComp();
		pID.setTitle("회원코드");
		pLoginInsert.add(pID);

		pPW = new PasswordPanel();
		pPW.setTitle("비밀번호");
		pLoginInsert.add(pPW);

		JPanel panel_3 = new JPanel();
		pLogin.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		btnEnter = new JButton("로그인");
		btnEnter.addActionListener(this);
		panel_3.add(btnEnter);

	}

	private void appearInTheCenter() {
		Dimension frameSize = this.getSize();
		// 자신의 windowscreen 사이즈 측정
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 출력해보면 두 사이즈가 출력되는걸 확인할 수 있다.
		System.out.println(frameSize + " " + windowSize);
		// 설정할 위치에 (윈도우width-프레임width)/2, (윈도우height-프레임height)/2를 입력한다
		this.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		// 프레임창 활성화하면 현재 모니터에 중앙에 프레임이 실행되는걸 볼수 있다.
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnter) {
			actionPerformedBtnEnter(e);
		}
	}

	public void actionPerformedBtnEnter(ActionEvent e) {

		String id = pID.getTFValue(); // 입력받은 ID
		String pw = String.valueOf(pPW.getPwField().getPassword());// 입력받은 PW

		// 로그인 버튼을 눌렀을때
		MemberInfo ourMember = MemberInfoService.getInstance().findMemberInfoByCode(new MemberInfo(id));
		if (ourMember == null) {
			JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않습니다");
			pID.clear();// 텍스트필드 초기화
			pID.getTF().requestFocus(); // 회원번호 텍스트에 포커스
		} else if (ourMember != null && !pw.equals(ourMember.getmPass())) {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
			pPW.getPwField().setText("");// 텍스트필드 초기화
			pPW.getPwField().requestFocus(); // 비밀번호텍스트에 포커스
		} else if (ourMember != null && pw.equals(ourMember.getmPass())) {
			// 화면을 띄움
			JOptionPane.showMessageDialog(null, "로그인 성공");
			showMainContent(ourMember);
		}
	}

	public void showMainContent(MemberInfo ourMemberInfo) {
		switch (ourMemberInfo.getmGroup()) {
		case 'A':
			// 관리자..직원메뉴까지 볼수있음
		case 'B':
			// 사서.... 직원메뉴 제외 전부 볼 수 있음..
			PageSub pageSub = new PageSub();
			pageSub.setmGroup(ourMemberInfo.getmGroup());
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
}
