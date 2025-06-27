import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ComboBox;

public class ComboBoxDemo extends Application {

  private final String[] titles = {"Autoboxing", "Ophelia", "Felix", "Bart"};
  private final ImageView[] images = {
    new ImageView("imgs/autoboxing.png"),
    new ImageView("imgs/lady.png"),
    new ImageView("imgs/felix.png"),
    new ImageView("imgs/bart.gif")
  };
  private final String[] descriptions = {
    "An image explaining autoboxing in java...",
    "A painting of Shakespeares Ophelia by Sir James Everett Millias...",
    "A picture of a handsome genius",
    "A picture of Bart Simpsons AKA Springfields Bad Boy AKA, Our generations Dennis the Menace"
  };
  private final ComboBox<String> cbo = new ComboBox<>();
  private final DescriptionPane dPane = new DescriptionPane();

  @Override
  public void start(Stage primaryStage) {

    setDisplay(0);

    BorderPane paneForCombo = new BorderPane();
    paneForCombo.setLeft(new Label("Select an option:"));
    paneForCombo.setCenter(cbo);

    ObservableList<String> items = FXCollections.observableArrayList(titles);
    cbo.getItems().addAll(items); cbo.setPrefWidth(400); cbo.setValue("Autoboxing");

    BorderPane pane = new BorderPane();
    pane.setTop(paneForCombo);
    pane.setCenter(dPane);

    cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Combo Box Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void setDisplay(int index) {
    dPane.setTitle(titles[index]);
    dPane.setImageView(images[index]);
    dPane.setTextSpace(descriptions[index]);
  }
}
