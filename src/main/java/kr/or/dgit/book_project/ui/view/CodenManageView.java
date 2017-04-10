package kr.or.dgit.book_project.ui.view;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.CodenP;
import kr.or.dgit.book_project.ui.table.CodenTable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CodenManageView extends JPanel {

	public static CodenTable pTable;
	private JPopupMenu popupMenu;
	private CodenP pCodenMain;

	public CodenManageView() {
		setBounds(100, 100, 450, 300);
		setLayout(new GridLayout(0, 1, 0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));

		pCodenMain = new CodenP();
		add(pCodenMain);

		pTable = new CodenTable();
		pTable.getTable().addMouseListener(new MouseAdapter() {
			/* pTable.loadData(); */
			/* add(pTable); */

			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					createPopupMenu();
					popupMenu.show(pTable.getTable(), e.getX(), e.getY());
				}
			}
		});

		add(pTable);
	}

	private void createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coden coden = pTable.getSelectedObject();
				if (coden == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				pCodenMain.setCodenObject(coden);
				pCodenMain.getBtnCodenSave().setText("수정");
				/*
				 * PublisherInfoTable pub2 = new PublisherInfoTable();
				 * ((PublisherInfoP) pub2.getSelectedObject).setObject(pubIn);
				 * pub.btnPubSave.setText("수정");
				 */
			}
		});
		popupMenu.add(updateItem);

	}

}
