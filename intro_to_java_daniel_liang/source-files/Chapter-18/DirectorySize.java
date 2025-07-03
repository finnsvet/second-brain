import java.io.File;
import java.util.Scanner;

public class DirectorySize {

	public static void main(String[] args) {
		System.out.print("Enter Directory: ");
		Scanner input = new Scanner(System.in);
		String directory = input.nextLine();
    long size = getSize(new File(directory));
    System.out.printf("%d bytes. %.2fMB.\n", size, size*1e-6);
	}

	private static long getSize(File file) {
		long size = 0;

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; files != null && i < files.length; ++i)
				size += getSize(files[i]);
		} else {
			size += file.length();
		}

		return size;
	}
}
