import java.util.Scanner;

public class ReadFileFromURL {

  public static void main(String[] args) {
    System.out.println("Enter a URL: ");
    String URLString = new Scanner(System.in).next();

    try {
      int count = 0;
      java.net.URL url = new java.net.URL(URLString);
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine();
        count += line.length();
      }
      System.out.println("file size: " + count);
    } catch (java.net.MalformedURLException ex) {
      System.out.println("Invalid URL");
    } catch (java.io.IOException ex) {
      System.out.println("I/O Errors: no such file");
    }
  }
}
