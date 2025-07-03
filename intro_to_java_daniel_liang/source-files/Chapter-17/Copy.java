import java.io.*;

public class Copy {
	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length != 2) {
			System.out.println("Usage: java copy srcFile tgtFile");
			System.exit(1);
		}
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("source file does not exist");
			System.exit(2);
		}
		File targetFile = new File(args[1]);
		if (targetFile.exists()) {
			System.out.println("target file already exists");
			System.exit(3);
		}

		try (
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
		) {
			int r, numberOfBytesCopied = 0;
			long fileSize = sourceFile.length();
			while ((r = input.read()) != -1) {
				output.write( (byte)r );
				++numberOfBytesCopied;
				double percent = ((double)numberOfBytesCopied / (double)fileSize) * 100.0;
				System.out.printf("\rCopied %d bytes. Progress: %.2f%%", numberOfBytesCopied, percent );
			}
			System.out.println();
		}
	}
}
