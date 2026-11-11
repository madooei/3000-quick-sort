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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
