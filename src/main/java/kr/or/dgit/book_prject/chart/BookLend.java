package kr.or.dgit.book_prject.chart;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
 
public class BookLend extends Application {
 
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("분야별도서대여통계");
        stage.setWidth(1024);
        stage.setHeight(768);
        
        ObservableList<PieChart.Data> pieChartData =
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
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}