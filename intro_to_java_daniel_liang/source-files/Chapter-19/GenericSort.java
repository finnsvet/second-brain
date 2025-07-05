public class GenericSort {

	public static void main(String[] args) {

		Integer[] integers = { Integer.valueOf(2), Integer.valueOf(4),
		Integer.valueOf(1) };

		Double[] doubles = { Double.valueOf(3.2),  Double.valueOf(1.3),
		Double.valueOf(-22.3)};

		Character[] chars = {Character.valueOf('a'),
		Character.valueOf('j'), Character.valueOf('r')};

		String[] strings = {"Tom", "Susana", "Ivy"};

		sort(integers); sort(doubles);
		sort(chars); sort(strings);

		printList(integers); printList(doubles);
		printList(chars); printList(strings);
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		T minValue;
		int minIndex;

		for (int i = 0; i != array.length; ++i) {
			minValue = array[i];
			minIndex = i;
			for (int j = i + 1; j != array.length; ++j) {
				if (minValue.compareTo(array[j]) > 0) {
					minValue = array[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = minValue;
			}
		}
	}

	public static void printList(Object[] array) {
		for (Object o: array)
			System.out.print(o + " ");
		System.out.println();
	}
}
