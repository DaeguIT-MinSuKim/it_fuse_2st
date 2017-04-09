package kr.or.dgit.book_project.ui.common;

import javax.swing.JTextField;
import java.util.regex.Pattern;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class BookCodePanel extends CompPanel {
	protected JTextField tfBCode;
	protected JTextField tfBSubCode;

	public BookCodePanel() {
		lblTitle.setText("도서코드");
		
		JPanel panel = new JPanel();
		pContent.add(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] {100, 60, 0};
				gbl_panel.rowHeights = new int[] {50, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
						
								tfBCode = new JTextField();
								GridBagConstraints gbc_tfBCode = new GridBagConstraints();
								gbc_tfBCode.weighty = 1.0;
								gbc_tfBCode.weightx = 1.0;
								gbc_tfBCode.fill = GridBagConstraints.BOTH;
								gbc_tfBCode.insets = new Insets(0, 0, 0, 5);
								gbc_tfBCode.gridx = 0;
								gbc_tfBCode.gridy = 0;
								panel.add(tfBCode, gbc_tfBCode);
				
						tfBSubCode = new JTextField();
						GridBagConstraints gbc_tfBSubCode = new GridBagConstraints();
						gbc_tfBSubCode.weighty = 1.0;
						gbc_tfBSubCode.weightx = 1.0;
						gbc_tfBSubCode.fill = GridBagConstraints.BOTH;
						gbc_tfBSubCode.gridx = 1;
						gbc_tfBSubCode.gridy = 0;
						panel.add(tfBSubCode, gbc_tfBSubCode);

	}

	public JTextField getTfBCode() {
		return tfBCode;
	}

	public void setTfBCode(String bCode) {
		tfBCode.setText(bCode);
	}

	public JTextField getTfBSubCode() {
		return tfBSubCode;
	}

	public void setTfBSubCode(String bSubCode) {
		tfBSubCode.setText(bSubCode);
	}

	public void clear() {
		tfBCode.setText("");
		tfBSubCode.setText("");
	}

	public boolean isEmpty() {
		if (getTfBCode().getText().trim().equals("") || getTfBSubCode().getText().trim().equals("")) {
			return true;
		}
		return false;
	}

	public void isEmptyCheck() throws Exception {
		if (getTfBCode().getText().trim().equals("") || getTfBSubCode().getText().trim().equals("")) {
			throw new Exception("공백 존재");
		}
	}

	public void isValidCheck() throws Exception {
		if (!Pattern.matches("^[A-Z]{1}[0-9]{3}$", getTfBCode().getText().trim())) {
			throw new Exception("도서코드 형식 오류");
		}
		if (!Pattern.matches("^[0-9]{1,2}$", getTfBSubCode().getText().trim())) {
			throw new Exception("도서중복코드 형식 오류");
		}

	}

}