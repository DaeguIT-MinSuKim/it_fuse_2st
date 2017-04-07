package kr.or.dgit.book_project.ui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.CheckSearchDesign;
import kr.or.dgit.book_project.ui.component.MemberSearchPanel;
import kr.or.dgit.book_project.ui.table.MemberInfoTable;

public class MemberSearchView extends AbsViewPanel {

	private MemberInfoTable pTable;

	/**
	 * Create the panel.
	 */
	public MemberSearchView() {
		
		JPanel panel_2 = new JPanel();
		pMain.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		CheckSearchDesign panel = new CheckSearchDesign();
		panel_2.add(panel);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) panel.getLayout();
		gridBagLayout_1.rowHeights = new int[] {200, 0};
		MemberSearchPanel msp = new MemberSearchPanel();
		panel.getpContent().add(msp);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		
		// 테이블 모프
		pTable = new MemberInfoTable();
		panel_2.add(pTable);
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.weighty = 2.0;
		gbc_pTable.weightx = 1.0;
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 1;
		pTable.setLayout(new GridLayout(1, 0, 0, 0));
		// 로드데이터 연결
		/*pTable.loadData();
		pMain.add(pTable, gbc_pTable);*/
	}
	
	
	public void loadDate() {
		pTable.loadData();
	}

	public MemberInfoTable getpTable() {
		return pTable;
	}
	
}
