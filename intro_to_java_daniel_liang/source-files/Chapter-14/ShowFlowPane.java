import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {

  @Override
  public void start(Stage primaryStage) {
    FlowPane pane = new FlowPane();
    pane.setPadding(new Insets(11, 12, 13, 14));
    pane.setHgap(5);
    pane.setVgap(5);

    pane
      .getChildren()
      .addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
    TextField txF = new TextField();
    txF.setPrefColumnCount(1);
    pane.getChildren().addAll(txF, new Label("Last Name:"), new TextField());

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Show FlowPane");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
