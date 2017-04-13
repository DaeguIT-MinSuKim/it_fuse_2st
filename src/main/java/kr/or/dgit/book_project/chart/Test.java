package kr.or.dgit.book_project.chart;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class Test {
	   private static void initAndShowGUI() {
	       // This method is invoked on Swing thread
	       JFrame frame = new JFrame("FX");
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
	     //  Scene scene = new Scene(root, fill)
	      // fxPanel.setScene(scene);
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