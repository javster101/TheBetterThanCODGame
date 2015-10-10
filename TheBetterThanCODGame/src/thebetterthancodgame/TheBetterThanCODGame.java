/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thebetterthancodgame;

/**
 *
 * @author Javier
 */

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
/*from w  w w. ja v  a  2s.c  o m*/
public class TheBetterThanCODGame extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws UnsupportedEncodingException {
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 780, 750, Color.WHITE);

    GridPane gridpane = new GridPane();
    gridpane.setPadding(new Insets(5));
    gridpane.setHgap(5);
    gridpane.setVgap(5);
    ColumnConstraints column1 = new ColumnConstraints(100);
    ColumnConstraints column2 = new ColumnConstraints(50, 350, 600);
    column2.setHgrow(Priority.ALWAYS);
    gridpane.getColumnConstraints().addAll(column1, column2);
    Image image;

    
     image = new Image("file:C:/res/boss.png");
   
    ImageView iv1 = new ImageView();
    iv1.setPreserveRatio(false);
    iv1.fitWidthProperty().bind(root.widthProperty());
    iv1.fitHeightProperty().bind(root.heightProperty());
    iv1.setImage(image);
    Label fNameLbl = new Label("Console");
    TextField fNameFld = new TextField();
    

    Button saveButt = new Button("Enter");

    // First name label
    GridPane.setHalignment(iv1, HPos.LEFT);
    gridpane.add(iv1, 0, 0);
    GridPane.setHalignment(fNameLbl, HPos.LEFT);
    gridpane.add(fNameLbl, 0, 0);

    // Last name label
   

    // First name field
    GridPane.setHalignment(fNameFld, HPos.LEFT);
    gridpane.add(fNameFld, 1, 0);

    // Last name field
 

    // Save button
    GridPane.setHalignment(saveButt, HPos.LEFT);
    gridpane.add(saveButt, 1, 2);
     
    root.setCenter(gridpane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}



