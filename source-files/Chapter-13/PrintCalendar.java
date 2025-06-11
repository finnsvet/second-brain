import java.util.*;

public class PrintCalendar {

  private static final String[] months = {
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  };
  private static final String[] dayOfWeek = {
    "Sun",
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri",
    "Sat",
  };
  private static final int lineLength =
    (dayOfWeek[0].length() * dayOfWeek.length) + dayOfWeek.length + 1;

  private PrintCalendar() {}

  public static void main(String[] args) {
    int month = -1;
    int year = -1;
    if (isArgsValid(args)) {
      month = Integer.valueOf(args[0]).intValue() - 1;
      year = Integer.valueOf(args[1]);
    } else {
      System.exit(1);
    }

    Calendar date = new GregorianCalendar(year, month, 1);
    print(date);
  }

  private static void print(Calendar date) {
    printHeader(date);
    int[][] dayMatrix = getDayMatrix(date);
    for (int i = 0; i < 5; ++i) {
      for (int k = 0; k < 7; ++k) {
        if (dayMatrix[i][k] == 0) System.out.printf("%4c", ' ');
        else System.out.printf("%4d", dayMatrix[i][k]);
      }
      System.out.println();
    }
  }

  private static int[][] getDayMatrix(Calendar date) {
    int[][] dayMatrix = new int[5][7];
    int firstDay = date.get(Calendar.DAY_OF_WEEK);
    int initialMonth = date.get(Calendar.MONTH);
    boolean started = false;
    int dayCount = 1;
    for (int week = 0; week < 5; ++week) {
      for (int day = 0; day < 7; ++day) {
        if (dayCount >= 27) {
          date.set(Calendar.DATE, dayCount);
          if (date.get(Calendar.MONTH) != initialMonth) {
            break;
          }
        }
        if (firstDay == day + 1 || started == true) {
          started = true;
          dayMatrix[week][day] = dayCount++;
        }
      }
    }
    return dayMatrix;
  }

  private static void printHeader(Calendar date) {
    String month = PrintCalendar.months[date.get(Calendar.MONTH)];
    int year = date.get(Calendar.YEAR);
    String monthYearString = getMonthYearString(month, year);

    System.out.println(monthYearString);
    for (int i = 0; i < lineLength; ++i) {
      System.out.print('-');
    }
    System.out.println();
    for (int i = 0; i < dayOfWeek.length; ++i) {
      System.out.print(" " + dayOfWeek[i]);
    }
    System.out.println();
  }

  private static String getMonthYearString(String month, int year) {
    String monthYear = month + " " + year;
    int monthYearlength = monthYear.length();
    char[] formatted = new char[lineLength];
    int startIndex = (lineLength / 2) - (monthYearlength / 2);
    int endIndex = startIndex + (monthYearlength - 1);
    int k = 0;

    for (int i = 0; i < formatted.length; ++i) {
      if (i >= startIndex && i <= endIndex) {
        formatted[i] = monthYear.charAt(k++);
      } else {
        formatted[i] = ' ';
      }
    }
    return (new String(formatted)).toString();
  }

  private static boolean isArgsValid(String[] args) {
    if (args.length != 2) {
      System.out.println("There must be 2 arguments");
      return false;
    }
    boolean valid = false;
    try {
      if (
        Integer.valueOf(args[0]) instanceof Integer &&
        Integer.valueOf(args[1]) instanceof Integer
      ) {
        valid = true;
      }
    } catch (Exception e) {
      System.out.println("Values must be integers");
    }
    return valid;
  }
}
