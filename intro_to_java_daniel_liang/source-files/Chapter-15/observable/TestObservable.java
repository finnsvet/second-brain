import java.util.Scanner;

@FunctionalInterface
interface InValidationListener {
  public void invalidated(Observable o);
}

class Observable {
  private int PREVALUE = 50;
  private int VALUE = 50;
  private InValidationListener listener = null;

  public void addListener(InValidationListener listener) {
    this.listener = listener;
  }
  public void valueChanged() {
    listener.invalidated(this);
  }

  public void setValue(int value) {
    PREVALUE = VALUE;
    VALUE = value;
    valueChanged();
  }
  public int getValue() { return VALUE; }
  public int getPreValue() { return PREVALUE; }
}

public class TestObservable {
  public static void main(String[] args) {
    Observable object = new Observable();
    object.addListener(o -> {
      if (o.getValue() == o.getPreValue())
        System.out.printf("Bro, you just told me that before, be. original.\n", o.getPreValue(), o.getValue());
    });

    Scanner input = new Scanner(System.in);
    System.out.println("This is a listener it will tell you if you input a number twice, consecutively; INPUT!:");
    while (true) {
      object.setValue(input.nextInt());
    }
  }
}
