public class boolToInt {
  public static void test(String[] args) {
    boolean b = true;
    int i = (int) true;
    System.out.println(i + '\n');

    i = 0;
    b = (boolean) i;
    System.out.println(b + '\n');
  }
}
