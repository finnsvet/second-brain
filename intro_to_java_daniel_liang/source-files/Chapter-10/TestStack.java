public class TestStack {

  public static void main(String[] args) {
    StackOfIntegers stack = new StackOfIntegers();

    for (int i = 0; i < 10; ++i) stack.push(i);
    while (!stack.empty()) System.out.print(stack.pop() + " ");
    System.out.println();
  }
}

class StackOfIntegers {

  private int[] elements;
  private int size;
  private static final int DEFAULT_SIZE = 16;

  public StackOfIntegers() {
    this(DEFAULT_SIZE);
  }

  public StackOfIntegers(int capacity) {
    elements = new int[capacity];
  }

  public boolean empty() {
    return size == 0;
  }

  public int peek() {
    return elements[size - 1];
  }

  public void push(int value) {
    if (size >= elements.length) {
      int[] temp = new int[elements.length * 2];
      System.arraycopy(elements, 0, temp, 0, elements.length);
      elements = temp;
    }
    elements[size++] = value;
  }

  public int pop() {
    return elements[--size];
  }

  public int getSize() {
    return size;
  }
}
