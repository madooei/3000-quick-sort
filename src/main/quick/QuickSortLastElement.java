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
    if (lo >= hi) {
      return;                            // zero or one element: already sorted
    }
    int pivotIndex = partition(arr, lo, hi);
    quicksort(arr, lo, pivotIndex - 1);  // sort the left side
    quicksort(arr, pivotIndex + 1, hi);  // sort the right side
  }

  // Partitions arr[lo..hi] around arr[hi] and returns pivotIndex, the pivot's
  // final index. Every value in arr[lo..pivotIndex-1] is at most the pivot,
  // and every value in arr[pivotIndex+1..hi] is at least the pivot.
  // Pre: lo <= hi.
  private static int partition(int[] arr, int lo, int hi) {
    int pivot = hi;       // index of the pivot, the last element of the slice
    int left = lo;
    int right = hi - 1;

    while (left <= right) {
      while (left <= right && arr[left] < arr[pivot]) {
        left++;
      }
      while (left <= right && arr[right] > arr[pivot]) {
        right--;
      }
      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    swap(arr, left, pivot);
    return left;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
