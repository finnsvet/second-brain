import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowBorderPane extends Application {

  @Override
  public void start(Stage primaryStage) {
    BorderPane pane = new BorderPane();

    pane.setTop(new CustomPane("Top"));
    pane.setRight(new CustomPane("Right"));
    pane.setBottom(new CustomPane("Bottom"));
    pane.setLeft(new CustomPane("Left"));
    pane.setCenter(new CustomPane("Center"));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Border Pane");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

class CustomPane extends StackPane {

  public CustomPane(String label) {
    this.getChildren().add(new Label(label));
    this.setStyle("-fx-border-color: red;");
    this.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
  }
}
