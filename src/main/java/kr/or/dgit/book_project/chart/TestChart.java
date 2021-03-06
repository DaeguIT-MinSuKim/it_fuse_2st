package kr.or.dgit.book_project.chart;


import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.CodenService;
/*import kr.or.dgit.sw_project.dto.Client;
import kr.or.dgit.sw_project.dto.JoinFromSale;
import kr.or.dgit.sw_project.service.ClientService;
import kr.or.dgit.sw_project.service.JoinFromSaleService;*/

public class TestChart extends Application {
   

   @SuppressWarnings({ "unchecked", "rawtypes" })
   @Override 
   public void start(Stage stage) {
      stage.setTitle("Sale Chart");
      final CategoryAxis xAxis = new CategoryAxis();
      final NumberAxis yAxis = new NumberAxis();
      final BarChart<String,Number> barChart = new BarChart<>(xAxis,yAxis);
      barChart.setTitle("Sale Chart");
      xAxis.setLabel("Client Name");       
      yAxis.setLabel("Amount");

      //클라이언트 이름 배열 생성
      List<Coden> list = CodenService.getInstance().selectCodenAll();
      String[] arrayClientNames = new String[list.size()];
      int[] arraySaleAmount = new int[arrayClientNames.length];
      
/*      for(int i=0; i<list.size(); i++){
         arrayClientNames[i] = list.get(i).getcCode().getcName();
         System.out.println("Add Client Name :" + arrayClientNames[i]);

         //해당 client의 판매 수량 누적
         arraySaleAmount[i] += list.get(i).getcName();;
      }*/

      XYChart.Series series = new XYChart.Series();
      for(int j=0; j<arrayClientNames.length; j++){
         series.getData().add(new XYChart.Data(arrayClientNames[j], arraySaleAmount[j]));
      }

      Scene scene  = new Scene(barChart,800,600);
      barChart.getData().add(series);
      stage.setScene(scene);
      stage.show();
   }

   public void showChart() {
      launch();
   }
}