import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new HBox(10);
    pane.setPadding(new Insets(5, 5, 5, 5));

    Image image = new Image("imgs/lady.png");
    ImageView imageV1 = new ImageView(image);
    ImageView imageV2 = new ImageView(image);
    imageV2.setFitHeight(100);
    imageV2.setFitWidth(100);
    ImageView imageV3 = new ImageView(image);
    imageV3.setRotate(90);

    pane.getChildren().addAll(imageV1, imageV2, imageV3);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Three images");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
