public class TestObjectInit {

  private double radius = 0;
  private static double adder = 1;

  public static void main(String[] args) {
    TestObjectInit[] Circle = new TestObjectInit[10];

    for (int i = 0; i < Circle.length; ++i) {
      Circle[i] = new TestObjectInit();
    }
    //for (TestObjectInit item : Circle) item = new TestObjectInit();
    for (TestObjectInit item : Circle) System.out.println(item.radius);
    System.out.println(Circle[0].radius);
  }

  TestObjectInit() {
    radius += adder++;
  }
}
