 import javafx.application.Application;
 import javafx.stage.Stage;
 import javafx.scene.Scene;
 import javafx.scene.image.ImageView;
 public class TestAreaDemo extends Application {
 @Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
 // Declare and create a description pane
 DescriptionPane descriptionPane = new DescriptionPane();
 // Set title, text, and image in the description pane
 descriptionPane.setTitle("Ophelia");
 String description = "Painting by Sir John Everett Millias: Ophelia";
 descriptionPane.setImageView(new ImageView("imgs/lady.png"));
 descriptionPane.setTextSpace(description);
 // Create a scene and place it in the stage
 Scene scene = new Scene(descriptionPane, 450, 200);
 primaryStage.setTitle("TextAreaDemo"); // Set the stage title
 primaryStage.setScene(scene); // Place the scene in the stage
 primaryStage.show(); // Display the stage
 }
 }
