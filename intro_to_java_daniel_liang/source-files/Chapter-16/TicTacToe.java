import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

public class TicTacToe extends Application {

  private char currentTurn = 'X';
  private Cell[][] CELLS = new Cell[3][3];
  private Label gameLabel = new Label();

  public void start(Stage primaryStage){
    GridPane grid = new GridPane();
    for (int i = 0; i < 3; ++i)
      for (int j = 0; j < 3; ++j){
        CELLS[i][j] = new Cell();
        grid.add(CELLS[i][j], j, i);
      }

    BorderPane pane =  new BorderPane();
    pane.setCenter(grid);
    pane.setBottom(gameLabel);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Tic Tac Toe");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private boolean isWon(Cell cell) {
    int row = cell.getIndex()[0];
    int col = cell.getIndex()[1];
    char token = cell.getToken();

    if (CELLS[row][0].getToken() == token && CELLS[row][1].getToken() == token &&
      CELLS[row][2].getToken() == token)
      return true;

    if (CELLS[0][col].getToken() == token && CELLS[1][col].getToken() == token &&
      CELLS[2][col].getToken() == token)
      return true;

    if (CELLS[0][0].getToken() == token && CELLS[1][1].getToken() == token &&
      CELLS[2][2].getToken() == token)
      return true;

    if (CELLS[0][2].getToken() == token && CELLS[1][1].getToken() == token &&
      CELLS[2][0].getToken() == token)
      return true;

    return false;
  }

  private boolean isFull() {
    for (int i = 0; i < 3; ++i)
      for (int k = 0; k < 3; ++k)
        if (CELLS[i][k].getToken() == ' ') return false;
    return true;
  }

  private class Cell extends Pane {
    private char token = ' ';
    private int thisCounter = 0;
    private static int counter = 0;

    public Cell() {
      this.setStyle("-fx-border-color: black");
      this.setPrefSize(2000, 2000);
      this.setOnMouseClicked( e -> handleMouseClick());
      thisCounter = ++counter;
    }

    public char getToken() {
      return token;
    }

    private void displayToken(char c) {
      if (c == 'X'){
        Line lineXOne = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
        lineXOne.endXProperty().bind(this.widthProperty().subtract(10));
        lineXOne.endYProperty().bind(this.heightProperty().subtract(10));
        Line lineXTwo = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
        lineXTwo.startYProperty().bind(this.heightProperty().subtract(10));
        lineXTwo.endXProperty().bind(this.widthProperty().subtract(10));

        this.getChildren().addAll(lineXOne, lineXTwo);
      }
      if (c == 'O') {
        Ellipse ellipseO = new Ellipse(this.getWidth()/2, this.getHeight()/2,
          this.getWidth()/2 - 10, this.getHeight()/2 -10);
        ellipseO.centerXProperty().bind(this.widthProperty().divide(2));
        ellipseO.centerYProperty().bind(this.heightProperty().divide(2));
        ellipseO.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
        ellipseO.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));

        ellipseO.setStroke(Color.BLACK);
        ellipseO.setFill(Color.WHITE);

        this.getChildren().add(ellipseO);
      }
    }

    private void setToken(char c) {
      token = c;
      displayToken(token);
    }

    public void handleMouseClick() {
      if (currentTurn != ' ' && token == ' ') {
        setToken(currentTurn);

        if (isWon(this)) {
          gameLabel.setText(currentTurn + " WON! Game Over.");
          currentTurn = ' ';
        }
        else if (isFull()) {
          gameLabel.setText("Its a draw. Game Over");
          currentTurn = ' ';
        }
        else {
          currentTurn = currentTurn == 'X' ? 'O' : 'X';
          gameLabel.setText(currentTurn + "'s turn'");
        }
      }
    }

    private int[] returnIndex() {
      int[] index = new int[2];
      index[0] = thisCounter % 3 == 0 ? thisCounter/3 - 1 : thisCounter/3;
      index[1] = thisCounter % 3 == 0 ? 2 : (thisCounter % 3) - 1;
      return index;
    }

    public int[] getIndex() {
      return returnIndex();
    }
  }
}
