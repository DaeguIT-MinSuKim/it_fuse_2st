package kr.or.dgit.book_project.ui.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class BasicPanel extends JPanel {

	protected JPanel pTitle;
	protected JPanel pContent;

	/**
	 * Create the panel.
	 */
	public BasicPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 200, 0};
		gridBagLayout.rowHeights = new int[] {50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		pTitle = new JPanel();
		GridBagConstraints gbc_pTitle = new GridBagConstraints();
		gbc_pTitle.weighty = 1.0;
		gbc_pTitle.weightx = 1.0;
		gbc_pTitle.fill = GridBagConstraints.BOTH;
		gbc_pTitle.insets = new Insets(0, 0, 0, 5);
		gbc_pTitle.gridx = 0;
		gbc_pTitle.gridy = 0;
		add(pTitle, gbc_pTitle);
		pTitle.setLayout(new GridLayout(1, 0, 0, 0));
		
		pContent = new JPanel();
		GridBagConstraints gbc_pContent = new GridBagConstraints();
		gbc_pContent.weighty = 1.0;
		gbc_pContent.weightx = 1.0;
		gbc_pContent.fill = GridBagConstraints.BOTH;
		gbc_pContent.gridx = 1;
		gbc_pContent.gridy = 0;
		add(pContent, gbc_pContent);
		pContent.setLayout(new GridLayout(1, 0, 0, 0));

	}

	public JPanel getpContent() {
		return pContent;
	}

	public void setpContent(JPanel pContent) {
		this.pContent = pContent;
	}
	
	

}
