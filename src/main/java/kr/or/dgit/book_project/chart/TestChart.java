package kr.or.dgit.book_project.chart;


import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.BookInfoService;
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

/*      //클라이언트 이름 배열 생성
      List<Map<String, Object>> list = BookInfoService.getInstance().selectAllCountBookInfo();
      List<BookInfo> list1 = BookInfoService.getInstance().blackCountBookInfo(list1.size());
      List<BookInfo> list2 = BookInfoService.getInstance().lendCountBookInfo(list2.size());
      String[] arrayClientNames = new String[list.size()];
      String[] arrayClientNames1 = new String[list1.size()];
      String[] arrayClientNames2 = new String[list2.size()];
      int[] arraySaleAmount = new int[arrayClientNames.length];
      int[] arraySaleAmount1 = new int[arrayClientNames1.length];
      int[] arraySaleAmount2 = new int[arrayClientNames2.length];
      
      for(int i=0; i<list.size(); i++){
         arrayClientNames[i] = list.get(i).getbCode();
         System.out.println("Add Client Name :" + arrayClientNames[i]);

         //해당 client의 판매 수량 누적
         arraySaleAmount[i] += list.get(i).getbLendCount();;
      }

      XYChart.Series series = new XYChart.Series();
      for(int j=0; j<arrayClientNames.length; j++){
         series.getData().add(new XYChart.Data(arrayClientNames[j], arraySaleAmount[j]));
      }

      Scene scene  = new Scene(barChart,800,600);
      barChart.getData().add(series);
      stage.setScene(scene);
      stage.show();*/
   } 

   public void showChart() {
      launch();
   }
}