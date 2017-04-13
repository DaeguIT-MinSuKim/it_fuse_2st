package kr.or.dgit.book_project.chart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.javafx.application.LauncherImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.CodenService;
import kr.or.dgit.book_project.service.PaymentIOService;

public class PieChartEx2 {

	private Scene scene;

	// Stage가 최상위 컨테이너

	public PieChartEx2() {
		Stage arg0 = new Stage();
		scene = new Scene(new Group());
		//scene.setFill(Paint.valueOf(Color.lightGray));

		arg0.setTitle("그래프 제목임");
		arg0.setWidth(500);
		arg0.setHeight(500);

		/*List<PaymentIO> list = PaymentIOService.getInstance().overduePaymentIO();
		List<PaymentIO> list2 = PaymentIOService.getInstance().lendPaymentIO();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("retrunDate", list.get(i).getReturnDate());
			map.put("retrunDate", list2.get(i).getReturnDate());
			pieChartData
					.add(new PieChart.Data(list.get(i).getReturnDate(), BookInfoService.getInstance().countBookInfo(map)));
		}*/
		
		// 전체 도서 중 대여 된 것
		
		
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
			Map<String, Object> map = new HashMap<>();
			map.put("isLending", true);
			pieChartData.add(new PieChart.Data("대여중도서", BookInfoService.getInstance().countBookInfo(map)));
			map.put("isLending", false);
			pieChartData.add(new PieChart.Data("대여가능도서", BookInfoService.getInstance().countBookInfo(map)));

		final PieChart chart = new PieChart(pieChartData);
		((Group) scene.getRoot()).getChildren().add(chart);
		arg0.setScene(scene);
	}

	public Scene getScene() {
		return scene;
	}
}
