package kr.or.dgit.book_project.ui.common;

import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class SearchTF extends JPanel {
	private JTextField textField;
	private Container pContent;

	public SearchTF() {
		setLayout(new GridLayout(0, 1, 0, 0));

		textField = new JTextField();
		pContent.add(textField);
		textField.setColumns(10);
		add(textField);

	}

}
