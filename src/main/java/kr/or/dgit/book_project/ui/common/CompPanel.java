package kr.or.dgit.book_project.ui.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class CompPanel extends BasicPanel {
	
	protected JLabel lblTitle;

	public CompPanel() {
		GridLayout gridLayout = (GridLayout) pContent.getLayout();
		
		lblTitle = new JLabel("New label");
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		pTitle.add(lblTitle);
	

	}

	public void setTitle(String title) {
		lblTitle.setText(title);
	}
	
	
}
