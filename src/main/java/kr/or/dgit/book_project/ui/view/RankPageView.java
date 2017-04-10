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
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RankPageView extends JPanel {

	private String viewTitle;
	protected JPanel pMain;
	protected JPanel pCombo;
	protected Map<String, Object> param;
	private JPanel panel;
	private JPanel panel2;

	public RankPageView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 410, 0 };
		gridBagLayout.rowHeights = new int[] { 100, 400, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		panel2 = new JPanel();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.weighty = 1.0;
		gbc_panel2.weightx = 1.0;
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 0;
		add(panel2, gbc_panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		pCombo = new JPanel();
		panel2.add(pCombo, BorderLayout.WEST);

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
		System.out.println(list);
		RankPage rank1 = new RankPage(1, list.get(0));
		pMain.add(rank1.setRankBookInfo());
		RankPage rank2 = new RankPage(2, list.get(1));
		pMain.add(rank2.setRankBookInfo());
		RankPage rank3 = new RankPage(3, list.get(2));
		pMain.add(rank3.setRankBookInfo());
	}

	public void setViewTitle(String viewTitle) {
		this.viewTitle = viewTitle;
		panel.setBorder(new TitledBorder(null, viewTitle, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

}
