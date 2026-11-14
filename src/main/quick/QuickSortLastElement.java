package quick;

/** Quicksort, with the last element of each slice as the pivot. */
public final class QuickSortLastElement {

  private QuickSortLastElement() {
    // This class should not be instantiated!
  }

  // Sorts a in ascending order, with the last element of each slice as the
  // pivot. Assumes a is not null.
  public static void quicksort(int[] arr) {
    quicksort(arr, 0, arr.length - 1);
  }

  // Sorts arr[lo..hi] in ascending order.
  private static void quicksort(int[] arr, int lo, int hi) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Partitions arr[lo..hi] around arr[hi] and returns pivotIndex, the pivot's
  // final index. Every value in arr[lo..pivotIndex-1] is at most the pivot,
  // and every value in arr[pivotIndex+1..hi] is at least the pivot.
  // Pre: lo <= hi.
  private static int partition(int[] arr, int lo, int hi) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
