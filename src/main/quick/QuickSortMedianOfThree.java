package quick;

/** Quicksort, with the median of three as the pivot. */
public final class QuickSortMedianOfThree {

  private QuickSortMedianOfThree() {
    // This class should not be instantiated!
  }

  // Sorts a in ascending order, with the median of the first, middle, and last
  // elements of each slice as the pivot. Assumes a is not null.
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

  // Returns the index (i, j, or k) of the median of arr[i], arr[j], and arr[k].
  private static int medianIndex(int[] arr, int i, int j, int k) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
