package kr.or.dgit.book_project.chart;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.PaymentIOService;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.Group;
 
public class BarPicChart extends Application {
	private static BookInfo listmapForbc;
	private static List<HashMap<String, Object>> listmapForPie;
	private static BarChart<String, Number> bc;
	private static NumberAxis yAxis;
	private static CategoryAxis xAxis;
    
	/*
        Scene pie = new Scene(new Group());
        stage.setTitle("분야별도서대여통계");
        stage.setWidth(1024);
        stage.setHeight(768);*/
        
	public void start(Stage arg0) throws Exception {
    		// This method is invoked on the JavaFX thread
    		AnchorPane anchorPane = new AnchorPane();

    		Scene scene = new Scene(anchorPane, Color.BEIGE);
    		HBox box = new HBox();
    		box.prefWidthProperty().bind(anchorPane.widthProperty());
    		box.prefHeightProperty().bind(anchorPane.heightProperty());
    		box.setStyle("-fx-alignment:center;");

    		yAxis = new NumberAxis();
    		xAxis = new CategoryAxis();
    		bc = new BarChart<String, Number>(xAxis, yAxis);
    		PieChart pie1 = new PieChart();
    		
    		HBox.setHgrow(bc, Priority.ALWAYS);
    		HBox.setHgrow(pie1, Priority.ALWAYS);
    		bc.setMaxWidth(Double.MAX_VALUE);
    		pie1.setMaxWidth(Double.MAX_VALUE);
    		box.getChildren().addAll(bc, pie1);
    		

    		anchorPane.getChildren().addAll(box);

    		bc.setTitle("고객별 주문수량");
    		yAxis.setLabel("주문수량");
    		xAxis.setLabel("상호명");

    
    			listmapForbc = (BookInfo) BookInfoService.getInstance().selectAllBookInfo(null);
    	
    				System.exit(0);
    			

    		
    				BigDecimal result = BigDecimal.valueOf(0);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
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
			pieChartData.add(new PieChart.Data((String) tempMap.get("shopName"), temp));
		}

		pieChartData.forEach(
				data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), " %")));

		pie1.setData(pieChartData);
		pie1.setTitle("매출비율");
		pie1.setLegendSide(Side.BOTTOM);
		pie1.lookup(".chart-title").setStyle("-fx-font-size: 1.8em");
		pie1.lookup(".chart-legend").setStyle("-fx-background-color:  transparent");

		tableDesignSetting();
	}

	private static void tableDesignSetting() {
		for (int i = 0; i < listmapForbc.getbLendCount(); i++) {
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
        
        /*ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                		new PieChart.Data("IT", 5),
                		new PieChart.Data("인문", 35),
                		new PieChart.Data("사회", 20),
                		new PieChart.Data("여행", 20),
                		new PieChart.Data("자기계발", 20));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("분야별도서대여비율");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();*/
    }
 
    public static void main(String[] args) {
        launch(args);
    }


}