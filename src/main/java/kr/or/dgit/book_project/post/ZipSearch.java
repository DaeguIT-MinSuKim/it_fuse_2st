package kr.or.dgit.book_project.post;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ZipSearch extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfDoro;
	private ZipTable zipTable;
	private JComboBox cmbSido;
	private JButton btnSearch;
	private PostMain postMain;

	public ZipSearch() {
		setTitle("우편번호 검색");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblSido = new JLabel("시도");
		panel.add(lblSido);

		cmbSido = new JComboBox();
		cmbSido.setModel(new DefaultComboBoxModel(new String[] { "강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시",
				"대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도" }));
		panel.add(cmbSido);

		JLabel lblDoro = new JLabel("도로명");
		panel.add(lblDoro);

		tfDoro = new JTextField();
		panel.add(tfDoro);
		tfDoro.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		contentPane.add(panel_1);

		zipTable = new ZipTable();
		zipTable.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] post = zipTable.getSelectedObject();
				if (post == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				postMain.tfZip.setText(post[0]);
				postMain.tfAddr.setText(post[1]);
				postMain.tfAddrDe.setFocusable(true);
				setVisible(false);
			}
		});
		panel_1.add(zipTable);
	}

	public void setPostMain(PostMain postMain) {
		this.postMain = postMain;
	}

	public void setMouseListener() {
		zipTable.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println(postMain);
				System.out.println(e.getSource());
				String[] post = zipTable.getSelectedObject();
				if (post == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				System.out.println("postMain : " + postMain);
				postMain.tfZip.setText(post[0]);
				postMain.tfAddr.setText(post[1]);
				postMain.tfAddrDe.setFocusable(true);
				// setVisible(false);

			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		String sido = (String) cmbSido.getSelectedItem();
		String doro = tfDoro.getText();
		zipTable.loadData(sido, doro);

		// 얘네로 검색해서 table로 테이터 입력해서 리로드
	}
}
