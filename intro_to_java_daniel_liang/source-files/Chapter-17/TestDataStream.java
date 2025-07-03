import java.io.*;

public class TestDataStream {
	public static void main(String[] args) throws IOException {
		try(DataOutputStream writer = new DataOutputStream(new FileOutputStream("temp.dat"))) {
			writer.writeUTF("Dubem");
			writer.writeDouble(17.3);
			writer.writeUTF("Naomi");
			writer.writeDouble(14.6);
		}
		try (DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"))) {
			System.out.println(input.readUTF() + " " + input.readDouble());
			System.out.println(input.readUTF() + " " + input.readDouble());
		}
	}
}
