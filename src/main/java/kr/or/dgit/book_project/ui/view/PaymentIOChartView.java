package kr.or.dgit.book_project.ui.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.border.TitledBorder;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.service.BookInfoService;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class PaymentIOChartView extends JPanel {

	private JPanel pTXT;

	public PaymentIOChartView() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		ChartView cv = new ChartView();
		setLayout(null);

		JPanel pChart = new JPanel();
		pChart.setBounds(50, 100, 520, 425);
		pChart.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pChart.add(cv.getPanel());
		add(pChart);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(620, 100, 300, 425);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 296, 0 };
		gbl_panel.rowHeights = new int[] { 200, 225, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel pTitle = new JPanel();

		String title = String.format("현재 대여현황");
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		pTitle.setLayout(new GridLayout(0, 1, 0, 0));
		pTitle.add(lblTitle);
		GridBagConstraints gbc_pTitle = new GridBagConstraints();
		gbc_pTitle.weighty = 1.0;
		gbc_pTitle.weightx = 1.0;
		gbc_pTitle.fill = GridBagConstraints.BOTH;
		gbc_pTitle.insets = new Insets(0, 0, 5, 0);
		gbc_pTitle.gridx = 0;
		gbc_pTitle.gridy = 0;
		panel.add(pTitle, gbc_pTitle);

		pTXT = new JPanel();
		pTXT.setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagConstraints gbc_pTXT = new GridBagConstraints();
		gbc_pTXT.weighty = 1.0;
		gbc_pTXT.weightx = 1.0;
		gbc_pTXT.fill = GridBagConstraints.BOTH;
		gbc_pTXT.gridx = 0;
		gbc_pTXT.gridy = 1;
		panel.add(pTXT, gbc_pTXT);
		
		setDateInfo();

	}

	public void setDateInfo() {
		/*List<Coden> list = CodenService.getInstance().selectCodenAll();*/
		List<BookInfo> list = BookInfoService.getInstance().selectIslending(null);
		pTXT.setLayout(new GridLayout(list.size(), 0, 0, 0));
		/*for (int i = 0; i < list.size(); i++) {*/
			Map<String, Object> map = new HashMap<>();
			/*map.put("cName", list.get(i).getcName());*/
			map.put("isLending", true);
			pTXT.add(new AddInfoLabel().setDate("대여중도서", BookInfoService.getInstance().countBookInfo(map)));
			map.put("isLending", false);
			pTXT.add(new AddInfoLabel().setDate("대여가능도서", BookInfoService.getInstance().countBookInfo(map)));
			/*pTXT.add(new AddInfoLabel().setDate(list.get(i).getcName(),
					BookInfoService.getInstance().countBookInfo(map)));*/
		}
	}
