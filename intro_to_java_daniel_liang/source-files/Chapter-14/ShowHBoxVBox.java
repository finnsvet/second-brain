import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowHBoxVBox extends Application {

  @Override
  public void start(Stage primaryStage) {
    BorderPane pane = new BorderPane();

    pane.setTop(getHBox());
    pane.setBottom(getVBox());

    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShowVBoxHBox");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private HBox getHBox() {
    HBox box = new HBox(15);
    box.setPadding(new Insets(15, 15, 15, 15));
    box.getChildren().add(new Button("Computer Science"));
    box.getChildren().add(new Button("Chemistry"));
    box.getChildren().add(new ImageView(new Image("imgs/lady.png")));
    box.setStyle("-fx-background-color: yellow");
    return box;
  }

  private VBox getVBox() {
    VBox box = new VBox(15);

    box.setPadding(new Insets(15, 5, 5, 5));
    box.getChildren().add(new Label("Courses:"));

    Label[] courses = {
      new Label("CSC 1301"),
      new Label("CSC 1302"),
      new Label("CSC 2410"),
      new Label("CSC 3720"),
    };
    for (Label course : courses) {
      box.getChildren().add(course);
      VBox.setMargin(course, new Insets(0, 0, 0, 15));
    }
    return box;
  }
}
