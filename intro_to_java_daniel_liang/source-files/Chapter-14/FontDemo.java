import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class FontDemo extends Application {

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new StackPane();

    Circle circle = new Circle();
    circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
    circle.setStroke(Color.BLACK);
    circle.setRadius(50);

    Label label = new Label("JavaFX");
    label.setFont(
      Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20)
    );

    pane.getChildren().addAll(circle, label);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Font Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
