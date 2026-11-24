package demo;

import java.util.Arrays;
import quick.QuickSortMedianOfThree;

/** A demo of QuickSortMedianOfThree on the sorted array the notes trace. */
public final class QuickSortMedianOfThreeDemo {

  private QuickSortMedianOfThreeDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("before: " + Arrays.toString(arr));

    // The first pivot is 5, the median of 1, 5, and 9.
    // Expect the array to come back sorted: [1, 2, 3, 4, 5, 6, 7, 8, 9].
    QuickSortMedianOfThree.quicksort(arr);
    System.out.println("after:  " + Arrays.toString(arr));
  }
}
