
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXHelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
