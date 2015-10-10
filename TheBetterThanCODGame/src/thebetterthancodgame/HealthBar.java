/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebetterthancodgame;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author Warren
 * */
public class HealthBar extends Pane {  
   
 Rectangle outerHealthRect;  
 Rectangle innerHealthRect;  
   
 public HealthBar(Color color) {  
    
  double height = 10;  
    
 double outerWidth = 200;  
  double innerWidth = 200;  
    
  double x=0.0;  
  double y=0.0;  
    
  outerHealthRect = new Rectangle( x, y, outerWidth, height);  
  outerHealthRect.setStroke(Color.BLACK);  
  outerHealthRect.setStrokeWidth(2);  
  outerHealthRect.setStrokeType( StrokeType.OUTSIDE);  
  outerHealthRect.setFill(Color.WHITE);  
  
  innerHealthRect = new Rectangle( x, y, innerWidth, height);  
  innerHealthRect.setStrokeType( StrokeType.OUTSIDE);  
  innerHealthRect.setFill(color);  
  
  getChildren().addAll( outerHealthRect, innerHealthRect);  
  
 }  
   
 public void setValue( double value,double maxhealth) {  
  innerHealthRect.setWidth( 200/maxhealth *value);  
 }  
   
}  