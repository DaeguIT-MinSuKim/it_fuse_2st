package kr.or.dgit.book_project.ui.view;

import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.ui.table.PublisherInfoTable;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.ui.component.PublisherInfoP;

@SuppressWarnings("serial")
public class PublisherView extends JPanel {

	public static PublisherInfoTable pTable;
	public PublisherInfoP pub;
	private JPopupMenu popupMenu;
	private PublisherInfoP panel;

	public PublisherView() {
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 10, 10));

		panel = new PublisherInfoP();
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		pTable = new PublisherInfoTable();
		pTable.getTable().addMouseListener(new MouseAdapter() {
			/* pTable.loadData(); */
			/* add(pTable); */

			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3)
					;
				createPopupMenu();
				popupMenu.show(pTable.getTable(), e.getX(), e.getY());
			}
		});

		add(pTable);
		panel.setNoInit();
	}

	private void createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PublisherInfo pubIn = pTable.getSelectedObject();
				if (pubIn == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				panel.setObject(pubIn);
				panel.getBtnPubSave().setText("수정");
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
