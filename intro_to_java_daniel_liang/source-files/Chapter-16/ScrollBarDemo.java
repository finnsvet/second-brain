import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Orientation;

public class ScrollBarDemo extends Application {
  @Override
  public void start(Stage primaryStage) {

    Text text = new Text("Programming sucks!");

    ScrollBar hBar = new ScrollBar();
    hBar.setOrientation(Orientation.HORIZONTAL);
    ScrollBar vBar = new ScrollBar();
    vBar.setOrientation(Orientation.VERTICAL);

    Pane textPane = new Pane();
    textPane.getChildren().add(text);

    BorderPane pane = new BorderPane();
    pane.setRight(vBar);
    pane.setBottom(hBar);
    pane.setCenter(textPane);

    hBar.valueProperty().addListener( ov -> text.setX(hBar.getValue()/hBar.getMax() * textPane.getWidth()) );
    vBar.valueProperty().addListener( ov -> text.setY(vBar.getValue()/vBar.getMax() * textPane.getHeight()) );

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Scrollbar");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
