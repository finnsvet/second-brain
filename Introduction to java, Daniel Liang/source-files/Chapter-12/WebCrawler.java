import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler {

  public static void main(String[] args) {
    System.out.println("Input URL: ");
    String URL = (new Scanner(System.in)).nextLine();
    crawler(URL);
  }

  public static void crawler(String startUrl) {
    ArrayList<String> pendingURLs = new ArrayList<>();
    ArrayList<String> traversedURLs = new ArrayList<>();
    pendingURLs.add(startUrl);

    while (!pendingURLs.isEmpty() && traversedURLs.size() <= 100) {
      String currentUrl = pendingURLs.remove(0);
      if (!traversedURLs.contains(currentUrl)) {
        traversedURLs.add(currentUrl);
        System.out.println("Crawl: " + currentUrl);

        for (String s : getSubUrls(currentUrl)) {
          if (!traversedURLs.contains(s)) pendingURLs.add(s);
        }
      }
    }
  }

  public static ArrayList<String> getSubUrls(String startUrl) {
    ArrayList<String> subs = new ArrayList<>();

    try {
      java.net.URL url = new java.net.URL(startUrl);
      Scanner input = new Scanner(url.openStream());
      int currentIndex = 0;

      while (input.hasNext()) {
        String line = input.nextLine();
        currentIndex = line.indexOf("https", currentIndex);

        while (currentIndex > 0) {
          int endIndex = line.indexOf("\"", currentIndex);
          if (endIndex > 0) {
            subs.add(line.substring(currentIndex, endIndex));
            currentIndex = line.indexOf("https", endIndex);
          } else {
            currentIndex = -1;
          }
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }

    return subs;
  }
}
