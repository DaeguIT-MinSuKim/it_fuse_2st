package kr.or.dgit.book_project.ui.common;

import javax.swing.JTextField;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class BookCodePanel extends CompPanel {
	protected JTextField tfBCode;
	protected JTextField tfBSubCode;

	public BookCodePanel() {
		lblTitle.setText("도서코드");

		tfBCode = new JTextField();
		tfBCode.setColumns(10);
		pContent.add(tfBCode);

		tfBSubCode = new JTextField();
		tfBSubCode.setColumns(2);
		pContent.add(tfBSubCode);

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