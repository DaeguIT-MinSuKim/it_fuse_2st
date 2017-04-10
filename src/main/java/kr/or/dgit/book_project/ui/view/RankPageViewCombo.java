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

	//private String cName;

	public RankPageViewCombo() {

		ComboBoxPanel panel = new ComboBoxPanel();
		panel.setTitle("분야");
		List<Coden> items = CodenService.getInstance().selectCodenAll();
		panel.setComboDate(items);
		panel.getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				//cName = ((Coden) e.getItem()).getcName();
				param.put("c_name", ((Coden) e.getItem()).getcName());
				System.out.println(param);
				pMain.removeAll();
				setRankInfo();
			}
		});
		pCombo.add(panel);

	}

	/*public String getcName() {
		return cName;
	}*/

}
