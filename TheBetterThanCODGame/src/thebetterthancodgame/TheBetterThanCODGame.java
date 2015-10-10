package thebetterthancodgame;
   

import java.util.List;
    import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.layout.GridPane;
   import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
   import javafx.scene.text.Font;
   import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
   import javafx.stage.Stage;
   
   public class TheBetterThanCODGame extends Application {
   
     BorderPane borderPane = new BorderPane(); // Container for the app
     World world = new World();
     Player player = world.p;
     Inventory inv = player.inv;
    StringProperty texturepath= new SimpleStringProperty();
     
      boolean n = inv.add(new Item(ItemList.Dagger));
       boolean n1 = inv.add(new Item(ItemList.Airhorn));
        boolean n2 = inv.add(new Item(ItemList.Glock18));
         boolean n3 = inv.add(new Item(ItemList.MountainDew)); 
          boolean n4 = inv.add(new Item(ItemList.Glock18));
        
      List<Item> iteml = inv.items;
   // Setup UI elements here
   
    Label leftLbl = new Label("Status");
     Label currentItem = new Label("Current Item: " + "None");
    Label rightLbl = new Label("Inventory");
     Label bottomLbl = new Label("Enter Command");
     Label labeld=new Label("Item Wear");
     Button centerBtn = new Button("Center");
    
       
     // Using a VBox (Veritcal Box) to hold UI elements
     VBox topVb = new VBox();
     VBox leftVb = new VBox();
     VBox rightVb = new VBox();
    VBox bottomVb = new VBox();
    GridPane center = new GridPane();
    Label topLbl = new Label("Level: "+player.level+ " Location: "+player.pos.x+","+player.pos.y);
    
     @Override
     public void init(){ // Use the init method to configure widgets
       // Set fonts for all labels using CSS
         texturepath.set("file:C:/res/blank.png");
         HealthBar health = new HealthBar(Color.LIMEGREEN);
         HealthBar wearbar= new HealthBar(Color.AQUA);
          center.setHgap(10);
    center.setVgap(10);
    center.setPadding(new Insets(0, 10, 0, 10));
         topVb.getChildren().add(topLbl);
        final TextArea textarea = new TextArea();
        final TextArea invarea = new TextArea();
  
       topLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
       leftLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
       rightLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
       bottomLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        Text categorys = new Text("Status");
            categorys.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
            topVb.getChildren().add(categorys); 
            currentItem.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
            labeld.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
       // Configure the VBoxes
             rightVb.setAlignment(Pos.CENTER);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
       rightVb.getChildren().add(currentItem);
       
       rightVb.getChildren().add(labeld);
       rightVb.getChildren().add(wearbar);
       leftVb.getChildren().add(leftLbl);
      leftVb.setAlignment(Pos.CENTER);
      
       leftVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black; ");    
       
       rightVb.getChildren().add(rightLbl);
      
       rightVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;padding:10px;");    
   rightVb.setPadding(new Insets(10, 50, 50, 50));
    rightVb.setSpacing(10);
       bottomVb.getChildren().add(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;"); 
       bottomVb.setSpacing(6);
       topVb.setSpacing(5);
       topVb.setPadding(new Insets(10, 30, 30, 30));
        bottomVb.setPadding(new Insets(10, 50, 50, 50));
       //elements
        
     for(Item i:iteml){
          
         
            invarea.appendText("\n"+ i.name);
            
            }
       
       Image image = new Image("file:C:/res/simon.png");
       Image imageenemy = new Image(texturepath.getValue());
   invarea.setStyle(""
        + "-fx-font-size: 20px;"
        + "-fx-font-style: italic;"
        + "-fx-font-weight: bold;"
        + "-fx-font-family: helvetica;"
        );
        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();
        iv1.setImage(image);
         iv2.setImage(imageenemy);
       // iv1.fitWidthProperty().bind(center.widthProperty());
  //  iv1.fitHeightProperty().bind(center.heightProperty());
       Label fNameLbl = new Label("Console");
        TextField fNameFld = new TextField();
        textarea.setEditable(false);
        invarea.setEditable(false);
        //textbox event
        
        rightVb.getChildren().add(invarea);
        fNameFld.setOnAction((event) -> {
            
            String text = fNameFld.getText();
            fNameFld.clear();
           
            textarea.appendText("\n" +Process.processEvent(text,world));
            String ns = "Level: "+player.level+ " Location: "+player.pos.x+","+player.pos.y;
            StringProperty nn= new SimpleStringProperty();
            StringProperty nnn= new SimpleStringProperty();
            health.setValue(player.health,player.maxHealth);
            System.out.println(player.health+ ","+player.maxHealth);
            nn.set(ns);
            
            topLbl.textProperty().bind(nn);
            if(inv.currentItem == null){
                  nnn.set("Current Item: " + "None");
            }else{
            nnn.set("Current Item: " + inv.currentItem.name);
            wearbar.setValue(inv.currentItem.wear, inv.currentItem.maxWear);
            }
            Vector2f location = world.p.pos;
                    
            Enemy e = world.worldmap[(int)location.x][(int)location.y].e;
            if(e == null){
                 texturepath.set("file:C:/res/blank.png");
            }else{
            texturepath.set("file:C:/res/"+e.texNameType);
            }
            Image sdi = new Image(texturepath.get());
            iv2.setImage(sdi);
            invarea.clear();
            for(Item i:iteml){
          
         
            invarea.appendText("\n"+ i.name);
            
            }
            currentItem.textProperty().bind(nnn);
            
             
        });
          iv1.setFitWidth(290);
         iv1.setPreserveRatio(true);
         iv1.setSmooth(true);
         iv1.setCache(true);
          iv2.setFitWidth(100);
         iv2.setPreserveRatio(true);
         iv2.setSmooth(true);
         iv2.setCache(true);

         textarea.setPrefColumnCount(19);
         
         invarea.setPrefColumnCount(13);
         invarea.setPrefRowCount(25);
         textarea.setPrefRowCount(32);
        Button saveButt = new Button("Enter");
        leftVb.getChildren().add(textarea);
        bottomVb.getChildren().add(fNameLbl);
         bottomVb.getChildren().add(fNameFld);
         
         
         topVb.getChildren().add(health);  
  topVb.setMargin( health, new Insets( 6,0,0,6));  
         iv1.setFitWidth(200);
         iv1.setPreserveRatio(true);
         iv1.setSmooth(true);
         iv1.setCache(true);
        
          center.setPrefWidth(400);
           center.add(iv1, 0, 35, 1, 2); 
           center.add(iv2, 20, 0, 1, 2); 
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
