package thebetterthancodgame;
   

import java.util.List;
    import javafx.application.Application;
import static javafx.application.Application.launch;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    
     
      boolean n = inv.add(new Item(ItemList.Negev));
       boolean n1 = inv.add(new Item(ItemList.Airhorn));
        boolean n2 = inv.add(new Item(ItemList.Glock18));
         boolean n3 = inv.add(new Item(ItemList.MountainDew)); 
          boolean n4 = inv.add(new Item(ItemList.Glock18));
        
      List<Item> iteml = inv.items;
   // Setup UI elements here
    Label topLbl = new Label("Level: "+player.level+ " Location: "+player.pos.x+","+player.pos.y);
    Label leftLbl = new Label("STATUS");
    Label rightLbl = new Label("INVENTORY");
     Label bottomLbl = new Label("Enter Command");
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
        
        final TextArea textarea = new TextArea();
       topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       leftLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       rightLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Text categorys = new Text("Status");
            categorys.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            topVb.getChildren().add(categorys); 
       // Configure the VBoxes
       topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
       
       leftVb.getChildren().add(leftLbl);
      leftVb.setAlignment(Pos.CENTER);
      
       leftVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black; ");    
       
       rightVb.getChildren().add(rightLbl);
       rightVb.setAlignment(Pos.CENTER);
       rightVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;padding:10px;");    
   rightVb.setPadding(new Insets(10, 50, 50, 50));
    rightVb.setSpacing(10);
       bottomVb.getChildren().add(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;"); 
       bottomVb.setSpacing(6);
        bottomVb.setPadding(new Insets(10, 50, 50, 50));
       //elements
        
      
       int is = 0;
       for(Item i:iteml){
           is++;
           Text category = new Text("Item "+ is+ ": " +i.name);
            category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            rightVb.getChildren().add(category); 
            System.out.println("sdf");
       }
       Image image = new Image("file:C:/res/simon.png");
   
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
       // iv1.fitWidthProperty().bind(center.widthProperty());
  //  iv1.fitHeightProperty().bind(center.heightProperty());
       Label fNameLbl = new Label("Console");
        TextField fNameFld = new TextField();
        textarea.setEditable(false);
        //textbox event
        fNameFld.setOnAction((event) -> {
            
            String text = fNameFld.getText();
            processEvent(text);
            fNameFld.clear();
            textarea.appendText("\n" +text);
            
        });
         
         textarea.setPrefColumnCount(14);
         textarea.setPrefRowCount(32);
        Button saveButt = new Button("Enter");
        leftVb.getChildren().add(textarea);
        bottomVb.getChildren().add(fNameLbl);
         bottomVb.getChildren().add(fNameFld);
         iv1.setFitWidth(400);
         iv1.setPreserveRatio(true);
         iv1.setSmooth(true);
         iv1.setCache(true);
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
     public void processEvent(String msg){
         String m = msg;
         String prefix = msg.
     }
   }
