import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ShowLine extends Application {

  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new LinePane());
    primaryStage.setTitle("ShowLine");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

class LinePane extends Pane {

  public LinePane() {
    Line line1 = new Line(10, 10, 10, 10);
    line1.startXProperty().bind(widthProperty().subtract(10));
    line1.startYProperty().bind(heightProperty().subtract(10));
    line1.setStrokeWidth(5);
    line1.setStroke(Color.GREEN);

    Line line2 = new Line(10, 10, 10, 10);
    line2.endXProperty().bind(widthProperty().subtract(10));
    line2.startYProperty().bind(heightProperty().subtract(10));
    line2.setStrokeWidth(5);
    line2.setStroke(Color.RED);

    getChildren().addAll(line1, line2);
  }
}
