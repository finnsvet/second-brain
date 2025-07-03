import java.io.*;
import java.util.Date;

public class TestObjectInputStream {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    String object = "object.dat";
    TestObjectOutputStream.main(object);

    try (ObjectInputStream reader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(object)))) {
      double one  = reader.readDouble();
      String two  = reader.readUTF();
      Date   date = (Date) reader.readObject();
      System.out.println(one + " " + two + " " + date);
    }
  }
}

class TestObjectOutputStream {

  static void main(String fileName) throws IOException {
    try (ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
      writer.writeDouble(29.13);
      writer.writeUTF("Anastasia");
      writer.writeObject(new Date());
    }
  }
}
