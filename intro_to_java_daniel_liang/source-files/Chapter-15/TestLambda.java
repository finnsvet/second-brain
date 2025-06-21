public class TestLambda {
  public static void main(String[] args) {
    TestLambda test = new TestLambda();

    test.perform1(() -> System.out.println("Perform 1"));
    test.perform2(e -> System.out.println(Math.pow(e, 2)));
    System.out.println(test.getVavlue(
      (a, b) -> { return a * b; }
    ));
  }

  public void perform1(T1 t) {
    t.m1();
  }
  public void perform2(T2 t) {
    t.m2(25.2);
  }
  public double getVavlue(T3 t) {
    return t.m3(32, 435.7);
  }
}

@FunctionalInterface
interface T1 {
  public abstract void m1();
}

@FunctionalInterface
interface T2 {
  public abstract void m2(Double e);
}

@FunctionalInterface
interface T3 {
  public abstract double m3(double a, double b);
}
