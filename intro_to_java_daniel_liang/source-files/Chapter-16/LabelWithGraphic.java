import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ContentDisplay;

public class LabelWithGraphic extends Application {

  @Override
	public void start(Stage primaryStage) {

		Image img = new Image("imgs/lady.png");

		Label label = new Label("Ophelia", new ImageView(img));
		label.setStyle("-fx-border-color: green; -fx-border-width: 2");
		label.setContentDisplay(ContentDisplay.BOTTOM);
		label.setTextFill(Color.RED);

		Ellipse ellipse = new Ellipse(50, 50, 50, 25);
		StackPane stackPane = new StackPane(ellipse, new Label("ellipse"));
		Label label2 = new Label("A pane inside a label", stackPane);
		label2.setContentDisplay(ContentDisplay.BOTTOM);

		HBox box = new HBox(20);
		box.getChildren().addAll(label, label2);

		Scene scene = new Scene(box);
		primaryStage.setTitle("Labels with graphic nodes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
