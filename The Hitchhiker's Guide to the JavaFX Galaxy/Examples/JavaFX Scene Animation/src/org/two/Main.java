package org.two;

import javafx.animation.FillTransition; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.stage.Stage; 
import javafx.animation.Timeline; 
import javafx.animation.ParallelTransition; 
import javafx.animation.RotateTransition; 
import javafx.animation.ScaleTransition; 
import javafx.animation.TranslateTransition; 
import javafx.util.Duration; 
 
public class Main extends Application { 
 
    @Override 
    public void start(Stage stage) { 
        Group root = new Group(); 
        Scene scene = new Scene(root, 500, 500, Color.BLACK); 
        Rectangle r = new Rectangle(0, 0, 250, 250); 
        r.setFill(Color.BLUE); 
        root.getChildren().add(r); 
 
        TranslateTransition translate = 
        new TranslateTransition(Duration.millis(750), r); 
        translate.setToX(390); 
        translate.setToY(390); 
        translate.setAutoReverse(true);
        translate.setCycleCount(Timeline.INDEFINITE);
        
        translate.play();
 
        stage.setTitle("JavaFX Scene Graph Demo"); 
        stage.setScene(scene); 
        stage.show(); 
    } 
 
    public static void main(String[] args) { 
        launch(args); 
    } 
}