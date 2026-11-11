package quick;

/** Quicksort, with the last element or the median of three as the pivot. */
public final class QuickSort {

  private QuickSort() {
    // This class should not be instantiated!
  }

  // Sorts a in ascending order, with the last element of each slice as the
  // pivot. Assumes a is not null.
  public static void quicksort(int[] a) {
    quicksort(a, 0, a.length - 1);
  }

  // Sorts a in ascending order, with the median of the first, middle, and last
  // elements of each slice as the pivot. Assumes a is not null.
  public static void quicksortMedianOfThree(int[] a) {
    quicksortMedianOfThree(a, 0, a.length - 1);
  }

  // Sorts a[lo..hi] in ascending order.
  private static void quicksort(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return;                    // zero or one element: already sorted
    }
    int p = partition(a, lo, hi);
    quicksort(a, lo, p - 1);     // sort the left side
    quicksort(a, p + 1, hi);     // sort the right side
  }

  // Sorts a[lo..hi] in ascending order.
  private static void quicksortMedianOfThree(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    int m = medianIndex(a, lo, mid, hi);
    swap(a, m, hi);              // move the median-of-three pivot to the end
    int p = partition(a, lo, hi);
    quicksortMedianOfThree(a, lo, p - 1);
    quicksortMedianOfThree(a, p + 1, hi);
  }

  // Partitions a[lo..hi] around a[hi] and returns the pivot's final index.
  // Every value in a[lo..p-1] is at most the pivot, and every value in
  // a[p+1..hi] is at least the pivot.
  // Pre: lo <= hi.
  private static int partition(int[] a, int lo, int hi) {
    int pivot = a[hi];   // the last element of the slice is the pivot
    int l = lo;
    int r = hi - 1;

    while (l <= r) {
      while (l <= r && a[l] < pivot) {
        l++;
      }
      while (l <= r && a[r] > pivot) {
        r--;
      }
      if (l <= r) {
        swap(a, l, r);
        l++;
        r--;
      }
    }

    swap(a, l, hi);
    return l;
  }

  // Returns the index (i, j, or k) of the median of a[i], a[j], and a[k].
  private static int medianIndex(int[] a, int i, int j, int k) {
    if (a[i] < a[j]) {
      if (a[j] < a[k]) return j;        // a[i] < a[j] < a[k]
      else if (a[i] < a[k]) return k;   // a[i] < a[k] <= a[j]
      else return i;                    // a[k] <= a[i] < a[j]
    } else {
      if (a[i] < a[k]) return i;        // a[j] <= a[i] < a[k]
      else if (a[j] < a[k]) return k;   // a[j] < a[k] <= a[i]
      else return j;                    // a[k] <= a[j] <= a[i]
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
