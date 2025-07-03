import java.io.*;

public class ArraySerialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		int[] numbers   = {1, 2, 3, 4, 5};
		int[] numbersRef;

		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("array.dat"))) {
			writer.writeObject(ex2(numbers));
	  }
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("array.dat"))) {
			numbersRef = (int[]) reader.readObject();
		}

		int index = 0;
		while (index != numbersRef.length) System.out.printf("%d ", numbersRef[index++]);
		System.out.println();
	}

	private static int[] ex2(int[] numbers) {
	  int[] newA = new int[5];
		for (int i = 0; i < numbers.length; ++i)
		  newA[i] = numbers[i] * 2;
		return newA;
	}
}
