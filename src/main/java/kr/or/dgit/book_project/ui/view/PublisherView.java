package kr.or.dgit.book_project.ui.view;

import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.table.PublisherInfoTable;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.ui.component.PublisherInfoP;

@SuppressWarnings("serial")
public class PublisherView extends JPanel {
	
	
	public static PublisherInfoTable pTable;
	 
	public PublisherView() {
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 10, 10));
		
		PublisherInfoP panel = new PublisherInfoP();
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		pTable = new PublisherInfoTable();
		/*pTable.loadData();*/
		add(pTable);		
	}

	/*public PublisherInfoTable getpTable() {
		return pTable;
	}

	public void setpTable(PublisherInfoTable pTable) {
		this.pTable = pTable;
	}
	*/

}
