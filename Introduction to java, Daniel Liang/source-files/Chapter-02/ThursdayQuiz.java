/**
 * if today is thursday, what will be the day in 100 days.
 */
import java.util.List;

public class ThursdayQuiz {
  public static void main( String[] args ) {
    List<String> days = List.of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    /*
     * if Thursday is the 4th day pf the week, keeping in mind that sunday is the zeroth,
     * then to find the day after 100days from thurday is too add 100 days to its day index
     * and find the reminader which will represent the index number of the day it will be.
     * */
    int day = (4 + 100) % 7;
    System.out.println("100 days after Thurday is: " + days.get(day));
  }
}
