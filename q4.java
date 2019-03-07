//Sean Caldwell, 100657715

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


public class q4 extends Application {

  public static void main(String args[]){
    launch(args);
  }
  public void setCount(int readNumber, int[] arr){
    readNumber = readNumber - 65;
    System.out.println(readNumber);

    arr[readNumber] = arr[readNumber] + 1;
    return;
  }
  public int getCount(int letter, int[] arr){
    return arr[letter];
  }
  public void readFile(String fileName, int[] arr, BorderPane pane) throws java.io.IOException{


    java.io.File input= new java.io.File(fileName);
    Scanner scanInput = new Scanner(input);
    String s = "";
    // puts all characters in one string
    while(scanInput.hasNext()) {
      s = s + scanInput.next();
    }
    s = s.toUpperCase();

    int readNumber = 0;
    for(int i = 0; i < s.length(); ++i){
    readNumber = (s.charAt(i));

      setCount(readNumber, arr);
    }

    scanInput.close();

    CategoryAxis xAxis = new CategoryAxis();

    xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")));

    NumberAxis yAxis = new NumberAxis();


    //Creating the Bar chart
    BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    barChart.setTitle("Count letters in a file");

    //set width of bars
    barChart.setCategoryGap(1);


    //Prepare XYChart.Series objects by setting data
    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    series1.setName("Letters");
    for(int i = 0; i < 26; ++i){
      char xAxisLetter = (char)(i+65);
      String addToAxis = Character.toString(xAxisLetter);
      series1.getData().add(new XYChart.Data<>(addToAxis, getCount(i, arr)));
    }

    //Setting the data to bar chart
    barChart.getData().addAll(series1);



    pane.setLeft(barChart);

  }


  @Override
  public void start(Stage stage){
    GridPane grid = new GridPane();
    GridPane grid2 = new GridPane();
    int[] letterArray = new int[26];
    Button fileButton = new Button("View");
    grid2.setConstraints(fileButton, 2,0);

    Label fileLabel = new Label("File Name:");
    grid2.setConstraints(fileLabel,0,0);
    TextField fileText = new TextField();
    fileText.setMaxWidth(200);
    grid2.setConstraints(fileText, 1,0);






    BorderPane border = new BorderPane();

    fileButton.setOnAction(e ->{



      try {
                //Pass file name to function
                readFile(fileText.getText(), letterArray, border);
            } catch (IOException ex) {
                //Catch any errors
                Logger.getLogger(q4.class.getName()).log(Level.SEVERE, null, ex);
      }

    });







    grid2.getChildren().addAll(fileButton, fileLabel, fileText);


    border.setBottom(grid2);

    //Creating a scene object
    Scene scene = new Scene(border, 600, 500);

    //Setting title to the Stage
    stage.setTitle("Bar Chart");

    //Adding scene to the stage
    stage.setScene(scene);

    //Displaying the contents of the stage
    stage.show();
  }

}
