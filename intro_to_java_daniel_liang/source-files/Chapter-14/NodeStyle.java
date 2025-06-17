import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NodeStyle extends Application {

  @Override
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    pane.setStyle("-fx-border-color: red; fx-background-color: lightgray");
    pane.setRotate(45);

    Button btk = new Button("OK");
    btk.setStyle("-fx-border-color: blue");
    pane.getChildren().add(btk);

    Scene scene = new Scene(pane, 200, 250);
    primaryStage.setTitle("Rotated Pane");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
