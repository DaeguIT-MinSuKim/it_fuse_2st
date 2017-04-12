package kr.or.dgit.book_project.post;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.ui.view.MemberInsertView;

public class PostMain extends JFrame implements ActionListener {

	protected JPanel contentPane;
	protected JTextField tfZip;
	protected JTextField tfAddr;
	protected JTextField tfAddrDe;
	private JButton btnAdd;
	private JButton btnZipSearch;
	private MemberInsertView memberInsertView;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostMain frame = new PostMain();
					frame.setVisible(true);

					InitSettingService init = new InitSettingService();
					init.initSetting();
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
	}*/

	public PostMain() {
		setTitle("우편번호");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 10, 0));

		JLabel lblZip = new JLabel("우편번호");
		lblZip.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblZip);

		JPanel panel1 = new JPanel();
		panel.add(panel1);
		panel1.setLayout(new GridLayout(1, 0, 0, 0));

		tfZip = new JTextField();
		panel1.add(tfZip);
		tfZip.setColumns(10);

		btnZipSearch = new JButton("우편번호 검색");
		btnZipSearch.addActionListener(this);
		panel1.add(btnZipSearch);

		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(1, 0, 10, 0));

		JLabel lblAddr = new JLabel("주소");
		lblAddr.setHorizontalAlignment(SwingConstants.TRAILING);
		panel2.add(lblAddr);

		tfAddr = new JTextField();
		panel2.add(tfAddr);
		tfAddr.setColumns(10);

		JPanel panel3 = new JPanel();
		contentPane.add(panel3);
		panel3.setLayout(new GridLayout(1, 0, 10, 0));

		JLabel lblAddrDe = new JLabel("세부주소");
		lblAddrDe.setHorizontalAlignment(SwingConstants.TRAILING);
		panel3.add(lblAddrDe);

		tfAddrDe = new JTextField();
		tfAddrDe.setColumns(10);
		panel3.add(tfAddrDe);

		JPanel panel4 = new JPanel();
		contentPane.add(panel4);
		panel4.setLayout(new GridLayout(0, 2, 10, 0));

		JPanel panel5 = new JPanel();
		panel4.add(panel5);

		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		panel4.add(btnAdd);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnZipSearch) {
			actionPerformedBtnZipSear(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
		String[] addArray = {tfZip.getText(), tfAddr.getText(), tfAddrDe.getText()};
		memberInsertView.getMemberInfoP().setObjectAddr(addArray);
		// memberInfo에 던져주기....=ㅅ=
				
		
	}

	protected void actionPerformedBtnZipSear(ActionEvent e) {
		ZipSearch zipSearch = new ZipSearch();
		zipSearch.setPostMain(this);
		zipSearch.setMouseListener();
		zipSearch.setVisible(true);
	}

	// 우편번호 값
	public JTextField getTfZip() {
		return tfZip;
	}
	
	public JTextField getTfAddr() {
		return tfAddr;
	}

	public JTextField getTfAddrDe() {
		return tfAddrDe;
	}

	public void setMemberInsertView(MemberInsertView memberInsertView) {
		this.memberInsertView = memberInsertView;
	}
	

}
