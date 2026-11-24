package demo;

import java.util.Arrays;
import quick.Partition;

/** A demo of Partition on the example the notes trace. */
public final class PartitionDemo {

  private PartitionDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    System.out.println("before: " + Arrays.toString(arr));

    // The pivot is 6, the last element. Expect [3, 5, 4, 1, 2, 6, 8, 7, 9] and index 5.
    int pivotIndex = Partition.partition(arr);
    System.out.println("after:  " + Arrays.toString(arr));
    System.out.println("pivot index: " + pivotIndex);
  }
}
