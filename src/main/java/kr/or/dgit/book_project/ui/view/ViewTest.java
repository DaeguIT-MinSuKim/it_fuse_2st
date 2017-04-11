package kr.or.dgit.book_project.ui.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_prject.chart.TestChart;

public class ViewTest extends JFrame {

	private JPanel contentPane;

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

		/*
		 * JPanel panel = new JPanel(); contentPane.add(panel);
		 * 
		 * JButton btnNewButton = new JButton("New button");
		 * panel.add(btnNewButton);
		 */

		/*
		 * BookSearchView absv = new BookSearchView(); BookSearchTableForCgroup
		 * bsbs = new BookSearchTableForCgroup(); absv.setpTable(bsbs);
		 * Map<String, Object> map = new HashMap<>(); //map.put("onlyBook",
		 * true); map.put("isDel", false); absv.setMap(map); absv.loadTable();
		 * contentPane.add(absv);
		 */

		/*
		 * BookCodePanel bcp = new BookCodePanel(); InputComp ic = new
		 * InputComp(); ic.setTitle("테스트"); add(bcp); add(ic);
		 */

		/*
		 * MemberSearchMemberPaymentViewFrame paymentInfoView = new
		 * MemberSearchMemberPaymentViewFrame();
		 * 
		 * /* MemberSearchMemberPaymentViewFrame paymentInfoView = new
		 * MemberSearchMemberPaymentViewFrame();
		 * 
		 * MemberInfo memberInfo = new MemberInfo("C002");
		 * paymentInfoView.loadTable(memberInfo); add(paymentInfoView);
		 */

		/*
		 * String reDate = "2017.4.1"; int idx = reDate.indexOf("."); int idx2 =
		 * reDate.lastIndexOf("."); String date1 = reDate.substring(0, idx);
		 * String date2 = reDate.substring(idx+1, idx2); String date3 =
		 * reDate.substring(idx2+1, reDate.length()); String returnDate =
		 * String.format("%s-%s-%s", date1, date2, date3);
		 * JOptionPane.showMessageDialog(null, returnDate);
		 */

		
	}
}
