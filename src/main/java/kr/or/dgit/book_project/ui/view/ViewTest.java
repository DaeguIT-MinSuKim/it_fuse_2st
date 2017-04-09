package kr.or.dgit.book_project.ui.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.ui.table.BookSearchTableForCgroup;

public class ViewTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTest frame = new ViewTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ViewTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
	/*	JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);*/
		
		BookSearchView absv = new BookSearchView();
		BookSearchTableForCgroup bsbs = new BookSearchTableForCgroup();
		absv.setpTable(bsbs);
		Map<String, Object> map = new HashMap<>();
		//map.put("onlyBook", true);
		map.put("isDel", false);
		absv.setMap(map);
		absv.loadTable();
		contentPane.add(absv);
	}

}
