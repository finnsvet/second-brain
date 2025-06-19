import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class ShowEllipse extends Application {

  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new EllipsePane(), 300, 200);
    primaryStage.setTitle("Show Ellipse");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

class EllipsePane extends Pane {

  private void paint() {
    getChildren().clear();
    for (int i = 0; i < 16; ++i) {
      Ellipse el = new Ellipse(
        getWidth() / 2,
        getHeight() / 2,
        getWidth() / 2 - 50,
        getHeight() / 2 - 50
      );
      el.setRotate((i * 180) / 16);
      el.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
      el.setFill(Color.WHITE);
      getChildren().add(el);
    }
  }

  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paint();
  }

  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paint();
  }
}
