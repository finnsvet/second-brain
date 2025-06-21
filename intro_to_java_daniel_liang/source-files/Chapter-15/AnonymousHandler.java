import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class AnonymousHandler extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    HBox box = new HBox(10);
    BorderPane container = new BorderPane();

    Text text = new Text(40, 40, "Programming sucks");
    Button btUp = new Button("Up"); Button btDown = new Button("Down");
    Button btRight = new Button("Right"); Button btLeft = new Button("Left");

    pane.getChildren().add(text);
    box.setAlignment(Pos.CENTER);
    box.getChildren().addAll(btUp, btDown, btLeft, btRight);
    container.setCenter(pane);
    container.setBottom(box);

    btUp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        text.setY(text.getY() > 10 ? text.getY() - 5 : 10);
      }
    });
    btDown.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        text.setY(text.getY() + 5 < pane.getHeight() ?
        text.getY() + 5 : pane.getHeight());
      }
    });
    btLeft.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        text.setX(text.getX() > 10 ? text.getX() - 5 : 10);
      }
    });
    btRight.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        text.setX(text.getX() < pane.getWidth() - 135 ?
        text.getX() + 5 : pane.getWidth() - 135);
      }
    });

    Scene scene = new Scene(container);
    primaryStage.setTitle("AnonymousHandler");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
