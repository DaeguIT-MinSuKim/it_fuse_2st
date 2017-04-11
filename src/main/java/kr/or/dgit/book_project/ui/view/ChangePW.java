package kr.or.dgit.book_project.ui.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.MemberInfoService;
import kr.or.dgit.book_project.ui.common.PasswordPanel;

public class ChangePW extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton button;
	private PasswordPanel pPW1;
	private PasswordPanel pPW2;
	private MemberInfo memberInfo;
	private JFrame upFrame;

	public ChangePW() {
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 10));

		pPW1 = new PasswordPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) pPW1.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0 };
		gridBagLayout.rowHeights = new int[] { 50 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.columnWidths = new int[] { 100, 200 };
		pPW1.setTitle("비밀번호 입력");
		panel_3.add(pPW1);

		pPW2 = new PasswordPanel();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) pPW2.getLayout();
		gridBagLayout_1.rowWeights = new double[] { 0.0 };
		gridBagLayout_1.rowHeights = new int[] { 50 };
		gridBagLayout_1.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout_1.columnWidths = new int[] { 100, 200 };
		pPW2.setTitle("비밀번호 변경");
		panel_3.add(pPW2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		button = new JButton("확인");
		button.addActionListener(this);
		panel_4.add(button);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
	}

	protected void actionPerformedButton(ActionEvent e) {
		// 비밀번호 변경하기
		if (!String.valueOf(pPW1.getPwField().getPassword()).equals(String.valueOf(pPW2.getPwField().getPassword()))) {
			JOptionPane.showMessageDialog(null, "입력된 비밀번호가 일치하지 않습니다.");
			pPW2.getPwField().setText("");
			pPW2.getPwField().requestFocus();
			return;
		}
		memberInfo.setmPass(String.valueOf(pPW1.getPwField().getPassword()));
		if (MemberInfoService.getInstance().updateMemberInfo(memberInfo) != 0) {
			JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.");
			clear();
			upFrame.setVisible(false);
			setVisible(false);
		}
	}

	public void clear() {
		pPW1.getPwField().setText("");
		
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public void setUpFrame(JFrame upFrame) {
		this.upFrame = upFrame;
	}
	
	

}
