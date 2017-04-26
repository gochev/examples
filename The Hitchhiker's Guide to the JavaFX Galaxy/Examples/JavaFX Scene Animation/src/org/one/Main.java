package org.one;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	 
	   @Override
	   public void start(Stage stage) {
	       Group root = new Group();
	       Scene scene = new Scene(root, 500, 500, Color.BLACK);
	 
	       Rectangle r = new Rectangle(25,25,250,250);
	       r.setFill(Color.BLUE);
	       root.getChildren().add(r);
	 
	       stage.setTitle("JavaFX Scene Graph Demo");
	       stage.setScene(scene);
	       stage.show();
	   }
	 
	   public static void main(String[] args) {
	       launch(args);
	   }
	}