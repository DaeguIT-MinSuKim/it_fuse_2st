package kr.or.dgit.book_project.ui.view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.dgit.book_project.chart.PieChartEx;

public class ChartView {
	private JPanel panel;

	private void initAndShowGUI() {

		panel = new JPanel();
		final JFXPanel fxPanel = new JFXPanel();
		panel.add(fxPanel);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				initFX(fxPanel);
			}
		});
	}

	private void initFX(JFXPanel fxPanel) {
		PieChartEx pc = new PieChartEx();
		Scene scene = pc.getScene();
		fxPanel.setScene(scene); // jfxPanel에 scene을 붙인다
	}

	public void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initAndShowGUI();
			}
		});
	}

	public JPanel getPanel() {
		//panel.setBorder(new TitledBorder(null, "도서별 보유비율", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		initAndShowGUI();
		return panel;
	}

}
