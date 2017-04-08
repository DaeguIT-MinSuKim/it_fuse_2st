package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageSub extends JFrame implements ActionListener {

	private JPanel contentPane;
	private SideBar pSideBar;
	private JPanel pTabSub;
	private char mGroup;

	/*public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		} catch (Exception e) {
		}
		PageMain frame = new PageMain();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PageSub frame = new PageSub();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public PageSub() {
		setTitle("도서관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1000, 600);

		pSideBar = new SideBar();
		pSideBar.btnMenu0.addActionListener(this);
		pSideBar.getBtnMenu4().addActionListener(this);
		pSideBar.btnMenu3.addActionListener(this);
		pSideBar.btnMenu2.addActionListener(this);
		pSideBar.btnMenu1.addActionListener(this);
		pSideBar.setBorder(new EmptyBorder(30, 10, 30, 10));
		GridLayout gl_pSideBar = (GridLayout) pSideBar.getLayout();
		gl_pSideBar.setVgap(10);
		gl_pSideBar.setHgap(10);
		getContentPane().add(pSideBar, BorderLayout.WEST);

		pTabSub = new JPanel();
		getContentPane().add(pTabSub, BorderLayout.CENTER);
		pTabSub.setLayout(new GridLayout(1, 0, 0, 0));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pSideBar.btnMenu0) {
			actionPerformedPSideBarBtnMenu0(e);
		}
		if (e.getSource() == pSideBar.getBtnMenu4()) {
			actionPerformedPSideBarBtnMenu4(e);
		}
		if (e.getSource() == pSideBar.btnMenu3) {
			actionPerformedPSideBarBtnMenu3(e);
		}
		if (e.getSource() == pSideBar.btnMenu2) {
			actionPerformedPSideBarBtnMenu2(e);
		}
		if (e.getSource() == pSideBar.btnMenu1) {
			actionPerformedPSideBarBtnMenu1(e);
		}
	}

	protected void actionPerformedPSideBarBtnMenu0(ActionEvent e) {
		// 자료관리
		pTabSub.removeAll();
		pTabSub.add(new SubMenuPage0());
		revalidate();
		repaint();
	}

	protected void actionPerformedPSideBarBtnMenu1(ActionEvent e) {
		// 멤버관리
		pTabSub.removeAll();
		pTabSub.add(new SubMenuPage1(mGroup));
		revalidate();
		repaint();
	}

	protected void actionPerformedPSideBarBtnMenu2(ActionEvent e) {
		// 출납관리
		pTabSub.removeAll();
		pTabSub.add(new SubMenuPage2());
		revalidate();
		repaint();
	}

	protected void actionPerformedPSideBarBtnMenu3(ActionEvent e) {
		// 통계
		pTabSub.removeAll();
		pTabSub.add(new SubMenuPage3());
		revalidate();
		repaint();
	}

	protected void actionPerformedPSideBarBtnMenu4(ActionEvent e) {
		setVisible(false);
	}

	public JPanel getpTabSub() {
		return pTabSub;
	}

	public void setpTabSub(JPanel pTabSub) {
		this.pTabSub = pTabSub;
	}

	public void setmGroup(char mGroup) {
		this.mGroup = mGroup;
	}

}
