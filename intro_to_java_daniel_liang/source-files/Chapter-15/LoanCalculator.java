import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class LoanCalculator extends Application {

  private TextField tfAnnualInterestRate = new TextField();
  private TextField tfNumberOfYears = new TextField();
  private TextField tfLoanAmount = new TextField();
  private TextField tfMonthlyPayment = new TextField();
  private TextField tfTotalPayment = new TextField();
  private Button btCalculate = new Button("Calculate");

  @Override
  public void start(Stage primaryStage) {

    GridPane container = new GridPane();
    container.setHgap(5);
    container.setVgap(5);
    container.add(new Label("Annual Interest Rate"), 0, 0);
    container.add(tfAnnualInterestRate, 1, 0);
    container.add(new Label("Number Of Years"), 0, 1);
    container.add(tfNumberOfYears, 1, 1);
    container.add(new Label("Loan Amount"), 0, 2);
    container.add(tfLoanAmount, 1, 2);
    container.add(new Label("Monthly Payment"), 0, 3);
    container.add(tfMonthlyPayment, 1, 3);
    container.add(new Label("Total Payment"), 0, 4);
    container.add(tfTotalPayment, 1, 4);
    container.add(btCalculate, 1, 5);

    // clean ui
    container.setAlignment(Pos.CENTER);
    tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
    tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
    container.setPadding(new Insets(10, 10, 10, 10));

    tfTotalPayment.setEditable(false);
    tfMonthlyPayment.setEditable(false);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);

    btCalculate.setOnAction(e -> calculateLoan());

    Scene scene = new Scene(container);
    primaryStage.setTitle("Loan Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  private void calculateLoan() {

    double interest = Double.parseDouble(tfAnnualInterestRate.getText());
    int year = Integer.parseInt(tfNumberOfYears.getText());
    double amount = Double.parseDouble(tfLoanAmount.getText());

    Loan loan = new Loan(interest, year, amount);

    tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
    tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
  }
}
