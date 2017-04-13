package kr.or.dgit.book_project.chart;

import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartEx {
	private Scene scene;

	public BarChartEx() {
		Stage arg1 = new Stage();
		scene = new Scene(new Group());

		arg1.setTitle("Bar Chart");
		arg1.setWidth(500);
		arg1.setHeight(500);
		// Defining the axes
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList("대여횟수", "연체횟수")));
		xAxis.setLabel("category");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("score");

		// Creating the Bar chart
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Comparison between various cars");

		// Prepare XYChart.Series objects by setting data
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		series1.setName("대여");
		series1.getData().add(new XYChart.Data<>("대여횟수", 5.0));

		XYChart.Series<String, Number> series2 = new XYChart.Series<>();
		series2.setName("연체");
		series2.getData().add(new XYChart.Data<>("연체횟수", 1.0));

		// Setting the data to bar chart
		barChart.getData().addAll(series1, series2);

		arg1.setScene(scene);
	}

	public Scene getScene() {
		return scene;
	}

}