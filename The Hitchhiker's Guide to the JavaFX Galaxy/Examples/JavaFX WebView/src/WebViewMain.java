import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewMain extends Application {
	
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("WebView");
        Group root = new Group();
		Scene scene = new Scene(root, 750, 500, Color.web("#666970"));
        
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://google.com");
        
        root.getChildren().add(browser);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
	public static void main(String[] args) {
		launch(args);
	}
}
