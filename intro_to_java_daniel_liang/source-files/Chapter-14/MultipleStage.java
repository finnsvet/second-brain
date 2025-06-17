import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStage extends Application {

  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new Button("OK"), 200, 250);
    primaryStage.setTitle("Window 1");
    primaryStage.setScene(scene);
    primaryStage.show();

    Stage newStage = new Stage();
    newStage.setTitle("Window 2");
    newStage.setScene(new Scene(new Button("OK DAD"), 200, 250));
    newStage.show();
  }
}
