package kr.or.dgit.book_project.ui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.common.SearchComboPanel;
import kr.or.dgit.book_project.ui.table.MemberInfoSearchTable;
import kr.or.dgit.book_project.ui.table.MemberInfoTable;

public class MemberSearchComboView extends AbsViewPanel implements ActionListener, ItemListener {
	private SearchComboPanel pSearch;
	private MemberInfoSearchTable pTable;
	private Map<String, Object> map;
	private JPopupMenu popupMenu;

	public MemberSearchComboView() {
		GridBagLayout gridBagLayout_2 = new GridBagLayout();
		gridBagLayout_2.columnWidths = new int[] { 735, 0 };
		gridBagLayout_2.rowHeights = new int[] { 560, 0 };
		gridBagLayout_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pMain.setLayout(gridBagLayout_2);
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.weighty = 1.0;
		gbc_pTable.weightx = 1.0;
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.insets = new Insets(0, 0, 5, 0);
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 0;

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weighty = 1.0;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		pMain.add(panel_2, gbc_panel_2);
		GridBagLayout panel_2GridBagLayout = new GridBagLayout();
		panel_2GridBagLayout.columnWidths = new int[] { 100, 0 };
		panel_2GridBagLayout.rowHeights = new int[] { 21, 400, 0 };
		panel_2GridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2GridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(panel_2GridBagLayout);

		pSearch = new SearchComboPanel();
		pSearch.getPanel().getComboBox().addItemListener(this);
		pSearch.getBtnNewButton().addActionListener(this);
		GridBagLayout gridBagLayout = (GridBagLayout) pSearch.getPanel().getLayout();
		gridBagLayout.rowHeights = new int[] { 5 };
		GridBagConstraints gbc_pSearch = new GridBagConstraints();
		gbc_pSearch.weighty = 1.0;
		gbc_pSearch.weightx = 1.0;
		gbc_pSearch.insets = new Insets(0, 0, 5, 0);
		gbc_pSearch.fill = GridBagConstraints.BOTH;
		gbc_pSearch.gridx = 0;
		gbc_pSearch.gridy = 0;
		panel_2.add(pSearch, gbc_pSearch);

		pTable = new MemberInfoSearchTable();
		map = new HashMap<>();
		pTable.setParam(map);
		pTable.loadData();
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 1;
		panel_2.add(pTable, gbc_pTable);
		pTable.setLayout(new GridLayout(1, 0, 0, 0));
		GridBagConstraints gbc_pTable_1 = new GridBagConstraints();
		gbc_pTable_1.weighty = 2.0;
		gbc_pTable_1.weightx = 1.0;
		gbc_pTable_1.fill = GridBagConstraints.BOTH;
		gbc_pTable_1.gridx = 0;
		gbc_pTable_1.gridy = 1;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pSearch.getBtnNewButton()) {
			actionPerformedPanelBtnNewButton(e);
		}
	}

	protected void actionPerformedPanelBtnNewButton(ActionEvent e) {
		Map<String, Object> param = new HashMap<>();

		if (pSearch.gettF().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			pTable.setParam(map); 	// 검색내용이 공백일 시, 해시맵으로 전체 목록을 출력하려고 새로운 해시맵(map)을 호출
			pTable.loadData(); 		// 새로운 해시맵(map)이 호출되면 "selectMemberByAll(param)"이 호출되어 목록이 출력
		} else if (pSearch.getPanel().getComboBox().getSelectedIndex() == 0) { // 콤보박스 회원코드 선택 시,검색
			param.put("mCode", pSearch.gettF().getText()); 						// 코드 입력 받아온다.
			pTable.setParam(param); 					// view에 입력창에 들어온 값으로 해시맵에게 키와 값을 set한다.

			if (pTable.loadData() == false) { 			// 입력된 값으로 검색이 안되어서 값이 없으면 loadData 결과가 0이다. False다.
				JOptionPane.showMessageDialog(null, "해당 데이터가 존재하지 않습니다.");
			}
			pSearch.gettF().setText(""); 			// 데이터를 입력하고 검색버튼 누르면 검색결과가 출력되고, 입력창이 지워진다.
		} else if (pSearch.getPanel().getComboBox().getSelectedIndex() == 1) {
			param.put("mName", pSearch.gettF().getText());
			pTable.setParam(param);
			
			if (pTable.loadData() == false) {
				JOptionPane.showMessageDialog(null, "해당 데이터가 존재하지 않습니다.");
			}
			pSearch.gettF().setText("");
		} else if(pSearch.getPanel().getComboBox().getSelectedIndex()==2){		// 콤보박스 전화번호 선택 시, 검색
			param.put("mTel", "%"+pSearch.gettF().getText());
			pTable.setParam(param);
			
			if(pTable.loadData() == false){
				System.out.println("actionPerformedPanelBtnNewButton load false");
				JOptionPane.showMessageDialog(null, "해당 데이터가 존재하지 않습니다.");
			} else if (pSearch.getPanel().getComboBox().getSelectedIndex() == 3) { 
				param.put("mTel", "%" + pSearch.gettF().getText());
			}
			pTable.setParam(param);

			if (pTable.loadData() == false) {
				System.out.println("actionPerformedPanelBtnNewButton load false");
				JOptionPane.showMessageDialog(null, "해당 데이터가 존재하지 않습니다.");
			}
			pSearch.gettF().setText("");

		}
	}

	// 성환이 대여에서 땡겨오는거랑 인영이누나 수정부분
	public void setMyMouseListener(BookLendView booklendview, JFrame myFrarme) {
		pTable.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// 회원 검색시 회원 정보 넣기 더블클릭 , 일딴은 올리는데 내부분에서 잠시 수정해야됨
					MemberInfo memberinfo = pTable.getSelectedObject();
					JOptionPane.showMessageDialog(null, memberinfo.toArrayForMemberList());
					memberinfo.setmCode(memberinfo.getmCode());
					booklendview.getPanel_4().getpMCode().setTFValue(memberinfo.getmCode());
					JOptionPane.showMessageDialog(null, memberinfo.isPosbl());
					// MemberInfo memberinfo2 =
					// MemberInfoService.getInstance().findMemberInfoByCode(memberinfo);
					if (memberinfo.isPosbl()) {
						booklendview.getPanel_4().getpMName().setTFValue(memberinfo.getmName());
						booklendview.getPanel_4().getpMTel().setTFValue(memberinfo.getmTel());
						booklendview.getPanel_4().getLblMsg().setText("대여가능");
					} else {
						booklendview.getPanel_4().getLblMsg().setText("대여불가");
					}
					myFrarme.setVisible(false);
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					// 오른쪽 우클릭시(누나 수정부분)
				}

			}

		});
	}

	public MemberInfoSearchTable getpTable() {
		return pTable;
	}

	public void setpTable(MemberInfoSearchTable pTable) {
			this.pTable = pTable;		
	}

	// 테이블 데이터 가지고 올라고 씀
	public void loadDate() {
		pTable.loadData();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == pSearch.getPanel().getComboBox()) {
			itemStateChangedPSearchPanelComboBox(e);
		}
	}

	protected void itemStateChangedPSearchPanelComboBox(ItemEvent e) {
		pTable.setParam(map);
		pTable.loadData();
	}


}
