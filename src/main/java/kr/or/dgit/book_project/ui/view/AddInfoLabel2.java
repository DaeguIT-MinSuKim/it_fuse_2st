package kr.or.dgit.book_project.ui.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class AddInfoLabel2 extends JPanel {

	private JLabel lblNewLabel;

	public AddInfoLabel2() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

	}
	
	public JLabel setDate(int cnt){
		String str = String.format(" %s : %s권", cnt);
		lblNewLabel.setText(str);
		return lblNewLabel;
	}
}
