package kr.or.dgit.book_project.ui.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.dgit.book_project.chart.PieChartEx;

public class Test {
	   private static JFrame frame;

	private static void initAndShowGUI() {
		
	       frame = new JFrame("FX");
	       final JFXPanel fxPanel = new JFXPanel();
	       frame.add(fxPanel);
	       frame.setVisible(true);

	       Platform.runLater(new Runnable() {
	           @Override
	           public void run() {
	               initFX(fxPanel);
	           }
	       });
	   }

	   private static void initFX(JFXPanel fxPanel) {
	       // This method is invoked on JavaFX thread
		   PieChartEx pc = new PieChartEx();
		   Scene scene = pc.getScene();
	       fxPanel.setScene(scene); // jfxPanel에 scene을 붙인다
	   }

	   public static void main(String[] args) {
	       SwingUtilities.invokeLater(new Runnable() {
	           @Override
	           public void run() {
	               initAndShowGUI();
	           }
	       });
	   }
	}
