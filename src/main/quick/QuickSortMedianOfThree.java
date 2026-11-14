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
    if (lo >= hi) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    int median = medianIndex(arr, lo, mid, hi);
    swap(arr, median, hi);       // move the median-of-three pivot to the end
    int pivotIndex = partition(arr, lo, hi);
    quicksort(arr, lo, pivotIndex - 1);
    quicksort(arr, pivotIndex + 1, hi);
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

  // Returns the index (i, j, or k) of the median of arr[i], arr[j], and arr[k].
  private static int medianIndex(int[] arr, int i, int j, int k) {
    if (arr[i] < arr[j]) {
      if (arr[j] < arr[k]) return j;       // arr[i] < arr[j] < arr[k]
      else if (arr[i] < arr[k]) return k;  // arr[i] < arr[k] <= arr[j]
      else return i;                       // arr[k] <= arr[i] < arr[j]
    } else {
      if (arr[i] < arr[k]) return i;       // arr[j] <= arr[i] < arr[k]
      else if (arr[j] < arr[k]) return k;  // arr[j] < arr[k] <= arr[i]
      else return j;                       // arr[k] <= arr[j] <= arr[i]
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
