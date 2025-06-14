import java.util.ArrayList;

public class TestArrayList {

  public static void main(String[] args) {
    // create a list½
    ArrayList<String> cityList = new ArrayList<String>();

    // add contents
    cityList.add("London");
    cityList.add("Denver");
    cityList.add("Paris");
    cityList.add("Seoul");
    cityList.add("Tokyo");

    System.out.println("List size " + cityList.size());
    System.out.println("Is Miami in the list? " + cityList.contains("Miami"));
    System.out.println(
      "The location of Denver in the List " + cityList.indexOf("Denver")
    );
    System.out.println("is the List empty " + cityList.isEmpty());

    cityList.add(2, "Xian");
    cityList.remove("Miami");
    cityList.remove(1);

    System.out.println(cityList.toString());

    for (int i = cityList.size() - 1; i >= 0; --i) {
      System.out.print(cityList.get(i) + " ");
    }
    System.out.println();

    // new list uste type reference
    ArrayList<Circle> list = new ArrayList<>();

    list.add(new Circle(2));
    list.add(new Circle(3));

    System.out.println("The area of the circle? " + list.get(0).getArea());
  }
}
