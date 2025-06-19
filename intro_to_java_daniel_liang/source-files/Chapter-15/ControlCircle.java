import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {

  private CirclePane circle = new CirclePane();

  @Override
  public void start(Stage primaryStage) {
    HBox box = new HBox();
    box.setSpacing(10);
    box.setAlignment(Pos.CENTER);

    Button shrink = new Button("Shrink");
    Button enlarge = new Button("Enlarge");
    box.getChildren().addAll(shrink, enlarge);

    BorderPane pane = new BorderPane();
    pane.setCenter(circle);
    pane.setBottom(box);
    BorderPane.setAlignment(box, Pos.CENTER);

    shrink.setOnAction(new ShrinkHandler());
    enlarge.setOnAction(new EnlargeHanlder());

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Circle");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  class ShrinkHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      circle.shrink();
    }
  }

  class EnlargeHanlder implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      circle.enlarge();
    }
  }
}

class CirclePane extends StackPane {

  private Circle circle = new Circle(50);

  public CirclePane() {
    getChildren().add(circle);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
  }

  public void shrink() {
    circle.setRadius(
      circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius()
    );
  }

  public void enlarge() {
    circle.setRadius(circle.getRadius() + 2);
  }
}
