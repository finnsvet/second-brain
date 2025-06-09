public class WriteData {

  public static void main(String[] args) throws java.io.IOException {
    java.io.File file = new java.io.File("scores.txt");
    if (file.exists()) {
      System.out.println("File already exists");
      System.exit(1);
    }

    java.io.PrintWriter writer = new java.io.PrintWriter(file);

    writer.print("John F Kennedy: ");
    writer.println(100);
    writer.print("Theodore Roslvelt: ");
    writer.println(121330);

    writer.close();
  }
}
