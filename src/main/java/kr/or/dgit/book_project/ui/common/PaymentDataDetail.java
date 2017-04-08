package kr.or.dgit.book_project.ui.common;

import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class PaymentDataDetail extends JPanel {

	protected JLabel lblTitle;
	protected JPanel pResult;
	
	public PaymentDataDetail() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(10, 10));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pTitle = new JPanel();
		panel.add(pTitle, BorderLayout.NORTH);
		FlowLayout flowLayout = (FlowLayout) pTitle.getLayout();
		flowLayout.setVgap(10);
		
		lblTitle = new JLabel("New label");
		pTitle.add(lblTitle);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 18));
		
		pResult = new JPanel();
		panel.add(pResult);
		pResult.setLayout(new GridLayout(0, 1, 0, 0));

	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public JPanel getpResult() {
		return pResult;
	}
	
	

}
