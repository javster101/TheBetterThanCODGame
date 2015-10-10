package thebetterthancodgame;
   

import java.util.List;
    import javafx.application.Application;
import static javafx.application.Application.launch;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
   import javafx.scene.layout.BorderPane;
   import javafx.scene.layout.VBox;
   import javafx.scene.text.Font;
   import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
   import javafx.stage.Stage;
   
   public class TheBetterThanCODGame extends Application {
   
     BorderPane borderPane = new BorderPane(); // Container for the app
     World world = new World();
     Player player = world.p;
     Inventory inv = player.inv;
      List<Item> iteml = inv.items;
   // Setup UI elements here
    Label topLbl = new Label("AREA");
    Label leftLbl = new Label("STATUS");
    Label rightLbl = new Label("INVENTORY");
     Label bottomLbl = new Label("Bottom");
     Button centerBtn = new Button("Center");
     
     // Using a VBox (Veritcal Box) to hold UI elements
     VBox topVb = new VBox();
     VBox leftVb = new VBox();
     VBox rightVb = new VBox();
    VBox bottomVb = new VBox();
    VBox center = new VBox();
     
     @Override
     public void init(){ // Use the init method to configure widgets
       // Set fonts for all labels using CSS
        
        
       topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       leftLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       rightLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       
       // Configure the VBoxes
       topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
       
       leftVb.getChildren().add(leftLbl);
      leftVb.setAlignment(Pos.CENTER);
       leftVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");    
       
       rightVb.getChildren().add(rightLbl);
       rightVb.setAlignment(Pos.CENTER);
       rightVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");    
   
       bottomVb.getChildren().add(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");  
       //elements
       for(Item i:iteml){
           Text category = new Text(i.name);
            category.setFont(Font.font("Arial", FontWeight.BOLD, 10));
            rightVb.getChildren().add(category); 
       }
       Image image = new Image("file:C:/res/unnamed.png");
   
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.fitWidthProperty().bind(center.widthProperty());
    iv1.fitHeightProperty().bind(center.heightProperty());
       Label fNameLbl = new Label("Console");
        TextField fNameFld = new TextField();
        Button saveButt = new Button("Enter");
        bottomVb.getChildren().add(fNameLbl);
         bottomVb.getChildren().add(fNameFld);
         bottomVb.getChildren().add(saveButt);
          center.setPrefWidth(400);
         center.getChildren().add(iv1);
       // Add VBoxes to Pane
       borderPane.setTop(topVb);
       borderPane.setLeft(leftVb);
       borderPane.setRight(rightVb);
       borderPane.setBottom(bottomVb);
       borderPane.setCenter(center);
    
       // Button event handler
       centerBtn.setOnAction((ActionEvent event) -> {
           System.out.println("Center clicked!");
       });
      
     }
     
     public static void main(String[] args) {
       launch(args);
     }
     
     @Override
     public void start(Stage primaryStage) {
       primaryStage.setTitle("Border Pane Example");
   
      primaryStage.setScene(new Scene(borderPane, 300, 250));
       primaryStage.show();
     }
   }
