package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.table.BookSearchTableForCgroup;
import kr.or.dgit.book_project.ui.view.AbsBookSearchView;
import kr.or.dgit.book_project.ui.view.BookSearchView;
import kr.or.dgit.book_project.ui.view.BookSearchViewForC;
import kr.or.dgit.book_project.ui.view.MemberSearchMemberDetailViewFrame;
import kr.or.dgit.book_project.ui.view.MemberSearchMemberPaymentViewFrame;
import javax.swing.JLabel;

public class PageSubForCgroup extends JFrame implements ActionListener, ChangeListener {

	private MemberInfo memberInfo;
	private JPanel contentPane;
	private JButton btnHome;
	private JTabbedPane tabbedPane;
	private JPanel pBookSearch;
	private JPanel pMyInfo;
	private JPanel pMyPaymentIO;
	private MemberSearchMemberDetailViewFrame memberInfoView;
	private BookSearchViewForC absv;
	private MemberSearchMemberPaymentViewFrame paymentInfoView;
	private JPanel panel;
	private JLabel lblNewLabel;

	public PageSubForCgroup() {
		setTitle("도서관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1000, 600);

		JPanel pSideMenu = new JPanel();
		pSideMenu.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(pSideMenu, BorderLayout.WEST);
		pSideMenu.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		pSideMenu.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		lblNewLabel = new JLabel("회원님 접속중");
		panel.add(lblNewLabel);

		btnHome = new JButton("로그아웃");
		panel.add(btnHome);
		btnHome.addActionListener(this);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		pBookSearch = new JPanel();
		tabbedPane.addTab("도서검색", null, pBookSearch, null);

		pMyInfo = new JPanel();
		tabbedPane.addTab("내정보", null, pMyInfo, null);

		pMyPaymentIO = new JPanel();
		tabbedPane.addTab("대여현황", null, pMyPaymentIO, null);

	}

	public void setMemberInfo(MemberInfo memberInfo) {
		// 로그인한 회원의 정보 받기
		this.memberInfo = memberInfo;
		lblNewLabel.setText("[" + memberInfo.getmName() + "] 님 접속중");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHome) {
			actionPerformedBtnHome(e);
		}
	}

	protected void actionPerformedBtnHome(ActionEvent e) {
		// 로그아웃
		int res = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?\n로그아웃 시 해당 페이지가 종료됩니다.", "",
				JOptionPane.YES_NO_OPTION);
		if (res != 0) {
			JOptionPane.showMessageDialog(null, "취소하였습니다");
			return;
		}
		memberInfo = null;
		setVisible(false);
		// 회원 아닌 내정보 제외한 검색창이 떠야하나?
		new PageLogin().setVisible(true);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == tabbedPane) {
			stateChangedTabbedPane(tabbedPane.getSelectedIndex());
		}
	}

	protected void stateChangedTabbedPane(int idx) {
		if (tabbedPane.getTitleAt(idx).equals("도서검색")) {
			pBookSearch.setLayout(new GridLayout(1, 0, 0, 0));
			if (absv != null) {
				pBookSearch.removeAll();
			}
			absv = new BookSearchViewForC();
			Map<String, Object> map = new HashMap<>();
			// map.put("onlyBook", true);
			map.put("isDel", false);
			absv.setMap(map);
			absv.loadTable();
			pBookSearch.add(absv);

			/*
			 * BookSearchView absv = new BookSearchView();
			 * BookSearchTableForCgroup bsbs = new BookSearchTableForCgroup();
			 * absv.setpTable(bsbs); Map<String, Object> map = new HashMap<>();
			 * //map.put("onlyBook", true); map.put("isDel", false);
			 * absv.setMap(map); absv.loadTable(); // 테이블 로드가 안된다....
			 * pBookSearch.add(absv);
			 */

		} else if (tabbedPane.getTitleAt(idx).equals("내정보")) {
			pMyInfo.setLayout(new GridLayout(1, 0, 0, 0));
			if (memberInfoView != null) {
				pMyInfo.removeAll();
			}
			memberInfoView = new MemberSearchMemberDetailViewFrame();
			// msmdvf에 해당 회원 정보 뿌리기
			memberInfoView.setMemberinfo(memberInfo);
			//memberInfoView.getPanel().setObject(memberInfo);
			memberInfoView.getPanel().getpMCode().getTF().setEnabled(false);
	
			pMyInfo.add(memberInfoView);
		} else if (tabbedPane.getTitleAt(idx).equals("대여현황")) {
			// 회원대여정보
			pMyPaymentIO.setLayout(new GridLayout(1, 0, 0, 0));
			if (paymentInfoView != null) {
				pMyPaymentIO.removeAll();
			}
			paymentInfoView = new MemberSearchMemberPaymentViewFrame();
			paymentInfoView.loadTable(memberInfo);
			pMyPaymentIO.add(paymentInfoView);
		}

	}

}
