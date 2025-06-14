public class testLarge {

  public static void main(String[] args) {
    int[] list = { 2, 1, 3, 10, 7 };
    int indexOfMax = 0;
    for (int i = 0; i < list.length; ++i) {
      if (list[indexOfMax] < list[i]) indexOfMax = i;
    }
    System.out.println(list[indexOfMax]);
  }
}
