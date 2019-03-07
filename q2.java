//Sean Caldwell, 100657715



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;




public class q2 extends Application{

  public static void main(String[] args){
  launch(args);
  }


  //Calculate takes the amount invested the years invested for and the annual interest rate
  //and returns the future value of the investment as a string
  public String calculate(String amount, String years, String interestRate){
    double a = Double.parseDouble(amount);
    double y = Double.parseDouble(years);
    double r = Double.parseDouble(interestRate);
    double xy = (r/100)/12.0;
    String s = Double.toString(a*Math.pow((1 + xy),(y*12)));
    return s;
  }

  @Override
  public void start(Stage primaryStage){
    primaryStage. setTitle("Future Value Calculator");

    GridPane grid = new GridPane();

    //button
    Button calcButton = new Button("Calculate");
    grid.setConstraints(calcButton, 1, 4);


    //4 labels for the inputs and output
    Label amountLabel = new Label("Investment Amount");
    grid.setConstraints(amountLabel,0,0);
    Label yearLabel = new Label("Years");
    grid.setConstraints(yearLabel,0,1);
    Label rateLabel = new Label("Annual Interest Rate");
    grid.setConstraints(rateLabel,0,2);
    Label valueLabel = new Label("Future Value");
    grid.setConstraints(valueLabel,0,3);


    //four textfields for the input and output
    TextField amount = new TextField();
    amount.setMaxWidth(200);
    grid.setConstraints(amount, 1,0);

    TextField years = new TextField();
    years.setMaxWidth(200);
    grid.setConstraints(years, 1,1);

    TextField rate = new TextField();
    grid.setConstraints(rate, 1,2);

    TextField value = new TextField();
    value.setMaxWidth(200);
    grid.setConstraints(value, 1,3);


    //The button event handler which calculates when pressed
    calcButton.setOnAction(e ->{
      value.setText(calculate(amount.getText(), years.getText(), rate.getText()));
      });

      grid.getChildren().addAll(amountLabel, amount, yearLabel, years, rateLabel, rate, valueLabel, value, calcButton);


    Scene scene = new Scene(grid, 600, 600);
    primaryStage.setScene(scene);
    primaryStage.show();



  }


}
