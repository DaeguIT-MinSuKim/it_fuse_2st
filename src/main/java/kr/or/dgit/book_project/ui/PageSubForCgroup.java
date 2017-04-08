package kr.or.dgit.book_project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.view.AbsBookSearchView;
import kr.or.dgit.book_project.ui.view.MemberSearchMemberDetailViewFrame;

public class PageSubForCgroup extends JFrame implements ActionListener, ChangeListener {

	private MemberInfo memberInfo;
	private JPanel contentPane;
	private JButton btnHome;
	private JTabbedPane tabbedPane;
	private JPanel pBookSearch;
	private JPanel pMyInfo;
	private MemberSearchMemberDetailViewFrame msmdvf;
	private AbsBookSearchView absv;

	public PageSubForCgroup() {
		setTitle("도서관리프로그램");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 200, 1000, 600);

		JPanel pSideMenu = new JPanel();
		pSideMenu.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(pSideMenu, BorderLayout.WEST);
		pSideMenu.setLayout(new BorderLayout(0, 0));

		btnHome = new JButton("로그아웃");
		btnHome.addActionListener(this);
		pSideMenu.add(btnHome, BorderLayout.NORTH);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		pBookSearch = new JPanel();
		tabbedPane.addTab("도서검색", null, pBookSearch, null);

		pMyInfo = new JPanel();
		tabbedPane.addTab("내정보", null, pMyInfo, null);

	}
	
	public void setMemberInfo(MemberInfo memberInfo) {
		// 로그인한 회원의 정보 받기
		this.memberInfo = memberInfo;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHome) {
			actionPerformedBtnHome(e);
		}
	}

	protected void actionPerformedBtnHome(ActionEvent e) {
		// 로그아웃
		memberInfo = null;
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == tabbedPane) {
			stateChangedTabbedPane(tabbedPane.getSelectedIndex());
		}
	}

	protected void stateChangedTabbedPane(int idx) {
		if (tabbedPane.getTitleAt(idx).equals("도서검색") && absv == null) {
			pBookSearch.setLayout(new GridLayout(1, 0, 0, 0));
			absv = new AbsBookSearchView() {				
				@Override
				protected void createPopupMenu() {					
				}
			};
			Map<String, Object> map = new HashMap<>();
			map.put("isDel", false);
			absv.setMap(map);
		} else if (tabbedPane.getTitleAt(idx).equals("내정보") && msmdvf == null) {
			pMyInfo.setLayout(new GridLayout(1, 0, 0, 0));
			msmdvf = new MemberSearchMemberDetailViewFrame();
			// msmdvf에 해당 회원 정보 뿌리기
			msmdvf.getPanel().setObject(memberInfo);
			msmdvf.getPanel().getpMCode().getTF().setEnabled(false);
			msmdvf.getBtnDel().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 수정 버튼을 눌렀을때
					/*Map<String, Object> param = new HashMap<>();
					param.put("isDel", false);
					MemberInfoService.getInstance().updateMemberInfo(param);*/
					
				}
			});
			pMyInfo.add(msmdvf);
		}

	}




}
