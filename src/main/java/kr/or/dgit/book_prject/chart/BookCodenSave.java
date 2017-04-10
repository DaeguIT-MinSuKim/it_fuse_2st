package kr.or.dgit.book_prject.chart;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import kr.or.dgit.book_project.dto.Coden;
 
public class BookCodenSave extends Application {
	
 
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("분야별도서보유통계");
        stage.setWidth(1024);
        stage.setHeight(768);
        
       /* List<Coden> CodenService.getInstance().selectCodenAll();
        Object[][] data = new Object[][];
        */
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                		new PieChart.Data("IT", 500),
                		new PieChart.Data("인문", 500),
                		new PieChart.Data("사회", 1000),
                		new PieChart.Data("여행", 500),
                		new PieChart.Data("자기계발", 500));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("분야별도서보유비율");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}