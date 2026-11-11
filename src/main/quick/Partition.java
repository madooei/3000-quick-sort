package quick;

/** The partitioning step of quicksort, on a whole array. */
public final class Partition {

  private Partition() {
    // This class should not be instantiated!
  }

  // Partitions a around its last element and returns the pivot's final index.
  // Every value before that index is at most the pivot, and every value after
  // it is at least the pivot. Assumes a is not null and not empty.
  public static int partition(int[] a) {
    int n = a.length;
    int pivot = a[n - 1];   // the last element is the pivot
    int l = 0;              // left marker
    int r = n - 2;          // right marker, just left of the pivot

    while (l <= r) {
      while (l <= r && a[l] < pivot) {
        l++;                // step past values that belong on the left
      }
      while (l <= r && a[r] > pivot) {
        r--;                // step past values that belong on the right
      }
      if (l <= r) {
        swap(a, l, r);      // swap the two values the markers stopped on
        l++;
        r--;
      }
    }

    swap(a, l, n - 1);      // move the pivot between the two sides
    return l;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
