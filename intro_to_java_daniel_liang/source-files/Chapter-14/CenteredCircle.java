import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CenteredCircle extends Application {

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();

    Circle circle = new Circle();
    circle.centerXProperty().bind(pane.widthProperty().divide(2));
    circle.centerYProperty().bind(pane.heightProperty().divide(2));
    circle.setRadius(50);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);

    pane.getChildren().add(circle);
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Centered Circle");
    primaryStage.show();
  }
}
