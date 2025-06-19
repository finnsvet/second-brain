import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent extends Application {

  @Override
  public void start(Stage primaryStage) {
    HBox pane = new HBox(10);
    pane.setAlignment(Pos.CENTER);

    Button btk1 = new Button("Ok");
    OkHandler handler1 = new OkHandler();
    btk1.setOnAction(handler1);

    Button btk2 = new Button("Cancel");
    CanHandler handler2 = new CanHandler();
    btk2.setOnAction(handler2);

    pane.getChildren().addAll(btk1, btk2);

    primaryStage.setTitle("Handlers");
    primaryStage.setScene(new Scene(pane));
    primaryStage.show();
  }
}

class OkHandler implements EventHandler<ActionEvent> {

  @Override
  public void handle(ActionEvent e) {
    System.out.println("Ok was clicked");
  }
}

class CanHandler implements EventHandler<ActionEvent> {

  @Override
  public void handle(ActionEvent e) {
    System.out.println("Cancel was clicked");
  }
}
