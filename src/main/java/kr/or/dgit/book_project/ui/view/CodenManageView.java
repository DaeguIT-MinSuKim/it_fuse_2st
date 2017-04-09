package kr.or.dgit.book_project.ui.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.CodenP;
import kr.or.dgit.book_project.ui.table.CodenTable;

import java.awt.BorderLayout;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class CodenManageView extends JPanel {

	public static CodenTable pTable;

	public CodenManageView() {
		setBounds(100, 100, 450, 300);
		setLayout(new GridLayout(0, 1, 0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));

		CodenP pCodenMain = new CodenP();
		add(pCodenMain);

		pTable = new CodenTable();
		add(pTable);

	}

}
