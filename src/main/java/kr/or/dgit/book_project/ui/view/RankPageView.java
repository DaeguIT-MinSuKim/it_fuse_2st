package kr.or.dgit.book_project.ui.view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import kr.or.dgit.book_project.service.PaymentIOService;
import kr.or.dgit.book_project.ui.component.RankPage;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

public class RankPageView extends JPanel {

	private String viewTitle;
	protected JPanel pMain;
	protected JPanel pCombo;
	protected Map<String, Object> param;
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel_1;
	private JLabel lblTitle;

	public RankPageView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 500, 0 };
		gridBagLayout.rowHeights = new int[] { 150, 400, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		panel2 = new JPanel();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.weightx = 1.0;
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 0;
		add(panel2, gbc_panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));

		panel_1 = new JPanel();
		panel2.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		lblTitle = new JLabel("New label");
		lblTitle.setFont(new Font("돋움", Font.PLAIN, 34));
		panel_1.add(lblTitle);

		pCombo = new JPanel();
		panel2.add(pCombo);
		pCombo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		pMain = new JPanel();
		panel.add(pMain);
		pMain.setLayout(new GridLayout(0, 1, 0, 0));

	}

	public void setRankInfo() {
		List<HashMap<String, Object>> list = PaymentIOService.getInstance().showRank(param);
		for (int i = 0; i < list.size(); i++) {
			pMain.add(new RankPage((i + 1), list.get(i)).setRankBookInfo());
		}
		for (int j = list.size(); j < 3; j++) {
			JPanel jp = new JPanel();
			jp.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(255, 255, 255)));
			pMain.add(jp);
			//pMain.add(new JPanel().setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(255, 255, 255);
		}
	}

	public void setViewTitle(String viewTitle) {
		this.viewTitle = viewTitle;
		panel.setBorder(new TitledBorder(null, viewTitle, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public void setTitle(String title) {
		lblTitle.setText(title);
	}
}
