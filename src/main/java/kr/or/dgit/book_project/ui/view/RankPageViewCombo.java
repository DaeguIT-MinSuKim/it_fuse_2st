package kr.or.dgit.book_project.ui.view;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.CodenService;
import kr.or.dgit.book_project.ui.common.ComboBoxPanel;

public class RankPageViewCombo extends RankPageView {

	// private String cName;

	public RankPageViewCombo() {

		ComboBoxPanel panel = new ComboBoxPanel();
		panel.setTitle("분야");
		panel.getComboBox().addItem("-분야선택-");
		List<Coden> items = CodenService.getInstance().selectCodenAll();
		panel.setComboDate(items);
		panel.getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (!e.getItem().equals("-분야선택-")) {
					param.put("cName", ((Coden) e.getItem()).getcName());
					pMain.removeAll();
					setRankInfo();
					pMain.revalidate();
					pMain.repaint();
				}

			}
		});
		pCombo.add(panel);

	}

	/*
	 * public String getcName() { return cName; }
	 */

}
