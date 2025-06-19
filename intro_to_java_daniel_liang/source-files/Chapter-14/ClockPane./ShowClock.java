import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShowClock extends Application {

  @Override
  public void start(Stage primaryStage) {
    ClockPane clock = new ClockPane();
    String timeString =
      clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
    Label label = new Label(timeString);

    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(label);
    BorderPane.setAlignment(label, Pos.TOP_CENTER);

    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("clock");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
