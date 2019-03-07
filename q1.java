//Sean Caldwell, 100657715


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math;
import java.util.Random;




public class q1 extends Application{

  public static void main(String[] args){
    launch(args);
  }

  public int randomNum(){
    Random rand = new Random();
    int n = rand.nextInt(54)+1;
    return n;
  }

  public String getCard(){
    return "file:////Users/sean/Desktop/java_assignment/Cards/" + randomNum() + ".png";

  }

  @Override
  public void start(Stage primaryStage){

    //create a grid pane
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(10);


    //sets the imageView to a random card image
    ImageView cardOne = new ImageView(new Image(getCard()));
    ImageView cardTwo = new ImageView(new Image(getCard()));
    ImageView cardThree = new ImageView(new Image(getCard()));

    //set constraints
    grid.setConstraints(cardOne, 0,0);
    grid.setConstraints(cardTwo, 1,0);
    grid.setConstraints(cardThree, 2,0);


    grid.getChildren().addAll(cardOne, cardTwo, cardThree);

    Scene scene = new Scene(grid, 600, 600);
    primaryStage.setTitle("Display Three cards");
    primaryStage.setScene(scene);
    primaryStage.show();


  }








}
