JavaFx is  an excellent pedagogical tool for learning OOP. Its excellent example of hoe the object oriented principles are applied.

## 14.2 JavaFx vs. Swing and AWT
Swing and AWT are replaced by the javaFX platform for developing rich GUI applications. 

## 14.3 The Basic Structure of a JavaFX program
the `javafx.application.Application` class defined the essential framework for writing javaFX programs. Every JavaFX program is defined in a class that extends `javafc.application.Application`, an example below:
```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class myJavaFx extends Application {
	@Override
	public void start(Stage primaryStage) {
		Button btOK = new Button("OK");
		Scene scene = new Scene(btOK, 200, 250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
```
