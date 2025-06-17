import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle extends Application {

  @Override
  public void start(Stage primaryStage) {
    Circle circle = new Circle();
    circle.setRadius(50);
    circle.setCenterX(100);
    circle.setCenterY(100);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

    Pane pane = new Pane(circle);
    Scene scene = new Scene(pane, 200, 200);

    primaryStage.setTitle("Circle");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
