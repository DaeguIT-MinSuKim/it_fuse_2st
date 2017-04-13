package kr.or.dgit.book_project.chart;

import java.awt.Color;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.CodenService;

public class PieChartEx {

	private Scene scene;

	// Stage가 최상위 컨테이너

	public PieChartEx() {
		Stage arg0 = new Stage();
		scene = new Scene(new Group());
		//scene.setFill(Paint.valueOf(Color.lightGray));

		arg0.setTitle("그래프 제목임");
		arg0.setWidth(500);
		arg0.setHeight(500);

		List<Coden> list = CodenService.getInstance().selectCodenAll();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("cName", list.get(i).getcName());
			pieChartData
					.add(new PieChart.Data(list.get(i).getcName(), BookInfoService.getInstance().countBookInfo(map)));
		}

		final PieChart chart = new PieChart(pieChartData);
		((Group) scene.getRoot()).getChildren().add(chart);

		arg0.setScene(scene);
	//	arg0.show();
	}

	public Scene getScene() {
		return scene;
	}
	/*
	 * public static void main(String[] args) { launch(args); }
	 */
}
