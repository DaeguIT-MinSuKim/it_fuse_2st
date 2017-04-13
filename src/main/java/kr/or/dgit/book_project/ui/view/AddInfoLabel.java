package kr.or.dgit.book_project.ui.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class AddInfoLabel extends JPanel {

	private JLabel lblNewLabel;

	public AddInfoLabel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

	}
	
	public JLabel setDate(String cName, int cnt){
		String str = String.format("[ %s ] 분야 현재 보유 권수 : %s권", cName, cnt);
		lblNewLabel.setText(str);
		return lblNewLabel;
	}
}
