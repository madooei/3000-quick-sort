package quick;

/** Quicksort, with the last element of each slice as the pivot. */
public final class QuickSortLastElement {

  private QuickSortLastElement() {
    // This class should not be instantiated!
  }

  // Sorts a in ascending order, with the last element of each slice as the
  // pivot. Assumes a is not null.
  public static void quicksort(int[] a) {
    quicksort(a, 0, a.length - 1);
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

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
