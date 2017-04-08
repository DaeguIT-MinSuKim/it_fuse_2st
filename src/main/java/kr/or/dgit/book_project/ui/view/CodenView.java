package kr.or.dgit.book_project.ui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.ui.component.BookInfoP;
import kr.or.dgit.book_project.ui.table.CodenTable;

public class CodenView extends JFrame {

	private JPanel contentPane;
	private CodenTable pTable;

	public CodenView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel("도서분류표");
		label.setFont(new Font("굴림", Font.BOLD, 18));
		panel.add(label);

		pTable = new CodenTable();
		pTable.loadData();
		contentPane.add(pTable);
		pTable.setLayout(new GridLayout(1, 0, 0, 0));
	}

	public void addMyMouseListner(BookInfoP bookInfoP) {
		pTable.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Coden coden = pTable.getSelectedObject();
					Map<String, Object> param = new HashMap<>();
					param.put("bSubCode", 0);
					param.put("cName", coden.getcName());
					int cnt = BookInfoService.getInstance().countBookInfo(param);
					System.out.println("해당분야 권수 : " + cnt);
					bookInfoP.setClear();
					bookInfoP.getpBCode().setTfBCode(coden.getcCode() + String.format("%03d", cnt + 1));
					bookInfoP.getpBCode().setTfBSubCode(00 + "");
					setVisible(false);
				}
			}

		});
	}
}