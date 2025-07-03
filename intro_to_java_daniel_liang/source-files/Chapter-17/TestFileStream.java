import java.io.*;

public class TestFileStream {
	public static void main(String[] args) throws IOException {
		try (FileOutputStream output = new FileOutputStream("file.dat")) {
			for (int i = 1; i != 11; ++i)
				output.write(i);
			int big = 13131;
			output.write(big);
		}
		try (FileInputStream input = new FileInputStream("file.dat")) {
			int value;
			while ((value = input.read()) != -1)
				System.out.print(value + " ");
			System.out.println();
		}
	}
}
