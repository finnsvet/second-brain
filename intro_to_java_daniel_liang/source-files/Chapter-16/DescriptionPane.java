import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.control.ContentDisplay;

public class DescriptionPane extends BorderPane {

  private Label title = new Label();
  private TextArea textSpace  = new TextArea();

  public DescriptionPane() {
    title.setContentDisplay(ContentDisplay.TOP);
    title.setPrefSize(200, 100);

    textSpace.setEditable(false);
    textSpace.setWrapText(true);

    ScrollPane scroller = new ScrollPane(textSpace);

    this.setLeft(title);
    this.setCenter(scroller);
    this.setPadding(new Insets(5, 5, 5 ,5));
  }
  public DescriptionPane(String title, String source ) {
    this();
    setTitle(title);
    setImageView(new ImageView(new Image(source)));
  }
  public void setTitle(String title) {
    this.title.setText(title);
  }
  public void setImageView(ImageView icon) {
    icon.setPreserveRatio(true);
    icon.setFitHeight(300);
    title.setGraphic(icon);
  }
  public void setTextSpace(String text) {
    textSpace.setText(text);
  }
}
