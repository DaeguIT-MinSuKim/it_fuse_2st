package kr.or.dgit.book_project.chart;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import kr.or.dgit.book_project.service.BookInfoService;

@SuppressWarnings("serial")
public class BarChartEx extends JPanel {
	private static List<Map<String, Object>> listmapForbc;
	private static List<Map<String, Object>> listmapForPie;
	private static BarChart<String, Number> bc;
	private static NumberAxis yAxis;
	private static CategoryAxis xAxis;
	
	public BarChartEx() {
		setLayout(new BorderLayout(0, 0));
		
		JFXPanel panel = new JFXPanel();
		add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
		
	
		Platform.runLater(new Runnable() {
			public void run() {
				initFX(panel);
			}
		});
	}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		protected void initFX(JFXPanel panel) {
			/*AnchorPane anchorPane = new AnchorPane();

			Scene scene = new Scene(anchorPane, Color.BEIGE);
			HBox box = new HBox();
			box.prefWidthProperty().bind(anchorPane.widthProperty());
			box.prefHeightProperty().bind(anchorPane.heightProperty());
			box.setStyle("-fx-alignment:center;");

			yAxis = new NumberAxis();
			xAxis = new CategoryAxis();
			bc = new BarChart<String, Number>(xAxis, yAxis);
			PieChart pie = new PieChart();
			
			HBox.setHgrow(bc, Priority.ALWAYS);
			HBox.setHgrow(pie, Priority.ALWAYS);
			bc.setMaxWidth(Double.MAX_VALUE);
			pie.setMaxWidth(Double.MAX_VALUE);
			box.getChildren().addAll(bc, pie);
			
			anchorPane.getChildren().addAll(box);

			bc.setTitle("고객별 주문수량");
			yAxis.setLabel("주문수량");
			xAxis.setLabel("상호명");*/

		/*	try {
				listmapForbc = BookInfoService.getInstance().selectAllCountBookInfo();
			} catch (Exception e) {
				if (JOptionPane.showConfirmDialog(null, "데이터가 없습니다. 초기화 하시겠습니까?") == 0) {
					new DateLabelFormatter();
					listmapForbc = BookInfoService.getInstance().selectAllCountBookInfo();
				} else {
					System.exit(0);
				}*/

			

			/*listmapForPie = BookInfoService.getInstance().selectAllCountBookInfo();
			XYChart.Series series1 = new XYChart.Series();

			for (int i = 0; i < listmapForbc.size(); i++) {
				Map<String, Object> tempMap = listmapForbc.get(i);
				series1.getData().add(new XYChart.Data(tempMap.get("bName"), tempMap.get("bName")));
			}

			bc.getData().addAll(series1);

			BigDecimal result = BigDecimal.valueOf(0);
			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

			for (int i = 0; i < listmapForPie.size(); i++) {

				Map<String, Object> tempMap = listmapForPie.get(i);
				BigDecimal bd = (BigDecimal) tempMap.get("result");
				result = result.add(bd);
			}

			for (int i = 0; i < listmapForPie.size(); i++) {

				Map<String, Object> tempMap = listmapForPie.get(i);
				BigDecimal bd = (BigDecimal) tempMap.get("result");
				BigDecimal ratio = bd.divide(result, 3, BigDecimal.ROUND_UP);
				double temp = ratio.multiply(new BigDecimal("100")).doubleValue();
				pieChartData.add(new PieChart.Data((String) tempMap.get("bName"), temp));
			}

			pieChartData.forEach(
					data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), " %")));

			pie.setData(pieChartData);
			pie.setTitle("매출비율");
			pie.setLegendSide(Side.BOTTOM);
			pie.lookup(".chart-title").setStyle("-fx-font-size: 1.8em");
			pie.lookup(".chart-legend").setStyle("-fx-background-color:  transparent");

			tableDesignSetting();
			panel.setScene(scene);
		}

		private static void tableDesignSetting() {
			for (int i = 0; i < listmapForbc.size(); i++) {
				bc.lookup(".data" + i + ".chart-bar").setStyle("-fx-background-color:#FF0051");
			}

			bc.lookup(".chart-title").setStyle("-fx-font-size: 1.8em");
			bc.setBarGap(0.0);
			bc.setCategoryGap(40);
			bc.setLegendVisible(false);

			xAxis.lookup(".axis-label").setStyle("-fx-label-padding:15 0 10 0");
			xAxis.setTickLength(5);
			xAxis.setTickLabelGap(5);
			xAxis.setTickLabelRotation(15);
*/
		
			//Defining the axes              
		      CategoryAxis xAxis = new CategoryAxis() ;  
		      xAxis.setCategories(FXCollections.<String>
		      observableArrayList(Arrays.asList("Speed", "User rating" , "Milage" , "Safety") ));
		      xAxis.setLabel("category") ;
		       
		      NumberAxis yAxis = new NumberAxis() ;
		      yAxis.setLabel("score") ;
			//Creating the Bar chart 
			BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis) ;  
			barChart.setTitle("Comparison between various cars") ; 
			
			//Prepare XYChart.Series objects by setting data        
			XYChart.Series<String, Number> series1 = new XYChart.Series<>() ; 
			series1.setName("Fiat") ; 
			series1.getData() .add(new XYChart.Data<>("Speed", 1.0) ); 
			series1.getData() .add(new XYChart.Data<>("User rating", 3.0) ); 
			series1.getData() .add(new XYChart.Data<>("Milage", 5.0) ); 
			series1.getData() .add(new XYChart.Data<>("Safety", 5.0) );   

			XYChart.Series<String, Number> series2 = new XYChart.Series<>() ; 
			series2.setName("Audi") ; 
			series2.getData() .add(new XYChart.Data<>("Speed", 5.0) ); 
			series2.getData() .add(new XYChart.Data<>("User rating", 6.0) );  

			series2.getData() .add(new XYChart.Data<>("Milage", 10.0) ); 
			series2.getData() .add(new XYChart.Data<>("Safety", 4.0) );  

			XYChart.Series<String, Number> series3 = new XYChart.Series<>() ; 
			series3.setName("Ford") ; 
			series3.getData() .add(new XYChart.Data<>("Speed", 4.0) ); 
			series3.getData() .add(new XYChart.Data<>("User rating", 2.0) ); 
			series3.getData() .add(new XYChart.Data<>("Milage", 3.0) ); 
			series3.getData() .add(new XYChart.Data<>("Safety", 6.0) );
			
			//Setting the data to bar chart        
			barChart.getData() .addAll(series1, series2, series3);
		        
		    //Creating a Group object 
		      Group root = new Group(barChart) ;
		        
		      //Creating a scene object
/*		      Scene scene = new Scene(root, 600, 400) ;

		      //Setting title to the Stage
		      stage.setTitle("Bar Chart") ;
		        
		      //Adding scene to the stage
		      stage.setScene(scene) ;
		        
		      //Displaying the contents of the stage
		      stage.show() ; */       
		
	}
/*		 public static void main(String args[]) {
		      launch(args) ;
		   }
*/
	
}
