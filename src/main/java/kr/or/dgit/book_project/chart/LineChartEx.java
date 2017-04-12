package kr.or.dgit.book_project.chart;

	import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage; 
	         
	public class LineChartEx extends Application { 
	   
	   @Override 
	   public void start(Stage stage) {
	      //Defining the x axis             
	      NumberAxis xAxis = new NumberAxis(1, 12, 1) ; 
	      xAxis.setLabel("월") ; 
	        
	      //Defining the y axis   
	      NumberAxis yAxis = new NumberAxis(0, 3000, 100) ; 
	      yAxis.setLabel("도서대여수") ; 
	      	        
	      //Creating the line chart 
	      LineChart linechart = new LineChart(xAxis, yAxis) ; 
	        
	      //Prepare XYChart.Series objects by setting data 
	      XYChart.Series series = new XYChart.Series() ; 
	      series.setName("도서대여통계") ; 
	      series.getData() .add(new XYChart.Data(1, 1000) );
	      series.getData() .add(new XYChart.Data(2, 1000) );
	      series.getData() .add(new XYChart.Data(3, 1000) );
	      series.getData() .add(new XYChart.Data(4, 1400) );
	      series.getData() .add(new XYChart.Data(5, 1000) );
	      series.getData() .add(new XYChart.Data(6, 1000) );  
	      series.getData() .add(new XYChart.Data(7, 1000) ); 
	      series.getData() .add(new XYChart.Data(8, 800) ); 
	      series.getData() .add(new XYChart.Data(9, 900) ); 
	      series.getData() .add(new XYChart.Data(10, 1200) ); 
	      series.getData() .add(new XYChart.Data(11, 700) ); 
	      series.getData() .add(new XYChart.Data(12, 800) ); 
	      
	      
	      XYChart.Series series1 = new XYChart.Series() ; 
	      series1.setName("No of schools in an year") ; 
	        
	      series1.getData() .add(new XYChart.Data(1, 1000) );
	      series1.getData() .add(new XYChart.Data(2, 1000) );
	      series1.getData() .add(new XYChart.Data(3, 2000) );
	      series1.getData() .add(new XYChart.Data(4, 1000) );
	      series1.getData() .add(new XYChart.Data(5, 1000) );
	      series1.getData() .add(new XYChart.Data(6, 1000) );  
	      series1.getData() .add(new XYChart.Data(7, 1000) ); 
	      series1.getData() .add(new XYChart.Data(8, 800) ); 
	      series1.getData() .add(new XYChart.Data(9, 900) ); 
	      series1.getData() .add(new XYChart.Data(10, 1200) ); 
	      series1.getData() .add(new XYChart.Data(11, 700) ); 
	      series1.getData() .add(new XYChart.Data(12, 800) );
	      
	      
	      XYChart.Series series2 = new XYChart.Series() ; 
	      series2.setName("No of schools in an year") ; 
	        
	      series2.getData() .add(new XYChart.Data(1, 1000) );
	      series2.getData() .add(new XYChart.Data(2, 1000) );
	      series2.getData() .add(new XYChart.Data(3, 100) );
	      series2.getData() .add(new XYChart.Data(4, 1000) );
	      series2.getData() .add(new XYChart.Data(5, 500) );
	      series2.getData() .add(new XYChart.Data(6, 1500) );  
	      series2.getData() .add(new XYChart.Data(7, 1000) ); 
	      series2.getData() .add(new XYChart.Data(8, 800) ); 
	      series2.getData() .add(new XYChart.Data(9, 900) ); 
	      series2.getData() .add(new XYChart.Data(10, 1200) ); 
	      series2.getData() .add(new XYChart.Data(11, 700) ); 
	      series2.getData() .add(new XYChart.Data(12, 800) );
	      
	      
	      XYChart.Series series3 = new XYChart.Series() ; 
	      series3.setName("No of schools in an year") ;
	      
	      series3.getData() .add(new XYChart.Data(1, 1000) );
	      series3.getData() .add(new XYChart.Data(2, 1000) );
	      series3.getData() .add(new XYChart.Data(3, 300) );
	      series3.getData() .add(new XYChart.Data(4, 1000) );
	      series3.getData() .add(new XYChart.Data(5, 1000) );
	      series3.getData() .add(new XYChart.Data(6, 1000) );  
	      series3.getData() .add(new XYChart.Data(7, 1000) ); 
	      series3.getData() .add(new XYChart.Data(8, 800) ); 
	      series3.getData() .add(new XYChart.Data(9, 900) ); 
	      series3.getData() .add(new XYChart.Data(10, 1200) ); 
	      series3.getData() .add(new XYChart.Data(11, 700) ); 
	      series3.getData() .add(new XYChart.Data(12, 800) );
	      
	      
	      XYChart.Series series4 = new XYChart.Series() ; 
	      series4.setName("No of schools in an year") ;
	      
	      series4.getData() .add(new XYChart.Data(1, 2000) );
	      series4.getData() .add(new XYChart.Data(2, 1500) );
	      series4.getData() .add(new XYChart.Data(3, 1000) );
	      series4.getData() .add(new XYChart.Data(4, 2500) );
	      series4.getData() .add(new XYChart.Data(5, 900) );
	      series4.getData() .add(new XYChart.Data(6, 100) );  
	      series4.getData() .add(new XYChart.Data(7, 500) ); 
	      series4.getData() .add(new XYChart.Data(8, 800) ); 
	      series4.getData() .add(new XYChart.Data(9, 900) ); 
	      series4.getData() .add(new XYChart.Data(10, 1200) ); 
	      series4.getData() .add(new XYChart.Data(11, 700) ); 
	      series4.getData() .add(new XYChart.Data(12, 800) );
	      
	      //Setting the data to Line chart    
	      linechart.getData() .addAll(series,series1,series2,series3,series4);
	        
	      //Creating a Group object  
	      Group root = new Group(linechart) ; 
   
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 400) ; 

	      
	      //Setting title to the Stage 
	      stage.setTitle("도서차트") ; 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene) ;
		   
	      //Displaying the contents of the stage 
	      stage.show() ;   
	   } 
	   public static void main(String args[]) { 
	      launch(args) ; 
	   } 
	}