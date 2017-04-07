package kr.or.dgit.book_project.ui.common;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionSearchTF extends OptionSearchPanel {
	private JTextField textField;

	public OptionSearchTF() {
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		

	}
	
	public String getTfValue(){
		return textField.getText();
	}
	
	public void clear(){
		chbTitle.setSelected(false);
		textField.setText("");
	}
	


}
