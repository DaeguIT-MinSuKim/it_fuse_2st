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
		setLayout(new BorderLayout(0, 0));

		panel2 = new JPanel();
		add(panel2, BorderLayout.NORTH);
		panel2.setLayout(new BorderLayout(0, 0));

		pCombo = new JPanel();
		panel2.add(pCombo, BorderLayout.WEST);
		pCombo.setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		add(panel);
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
	}

	public void setViewTitle(String viewTitle) {
		this.viewTitle = viewTitle;
		panel.setBorder(new TitledBorder(null, viewTitle, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

}
