package demo;

import java.util.Arrays;
import quick.QuickSortLastElement;

/** A demo of QuickSortLastElement on the example the notes trace. */
public final class QuickSortLastElementDemo {

  private QuickSortLastElementDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    System.out.println("before: " + Arrays.toString(arr));

    // Expect [1, 2, 3, 4, 5, 6, 7, 8, 9].
    QuickSortLastElement.quicksort(arr);
    System.out.println("after:  " + Arrays.toString(arr));
  }
}
