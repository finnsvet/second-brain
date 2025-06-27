import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;

public class ListViewDemo extends Application {

  private final String[] titles = {"Autoboxing", "Ophelia", "Felix", "Bart"};
  private final ImageView[] images = {
    new ImageView("imgs/autoboxing.png"),
    new ImageView("imgs/lady.png"),
    new ImageView("imgs/felix.png"),
    new ImageView("imgs/bart.gif")
  };

  @Override
  public void start(Stage primaryStage) {
    ListView<String> list = new ListView<>(FXCollections.observableArrayList(titles));
    list.setPrefSize(400, 400);
    list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    FlowPane imagePane = new FlowPane(10, 10);
    BorderPane pane = new BorderPane();
    pane.setLeft(new ScrollPane(list));
    pane.setCenter(imagePane);

    list.getSelectionModel().selectedItemProperty().addListener( ov-> {
      imagePane.getChildren().clear();
      for (Integer i: list.getSelectionModel().getSelectedIndices()) {
        images[i].setFitWidth(400);
        images[i].setPreserveRatio(true);
        imagePane.getChildren().add(images[i]);
      }
    });

    Scene scene = new Scene(pane, 450, 170);
    primaryStage.setTitle("ListView Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
