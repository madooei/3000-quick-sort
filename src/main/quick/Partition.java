package quick;

/** The partitioning step of quicksort, on a whole array. */
public final class Partition {

  private Partition() {
    // This class should not be instantiated!
  }

  // Partitions a around its last element and returns the pivot's final index.
  // Every value before that index is at most the pivot, and every value after
  // it is at least the pivot. Assumes a is not null and not empty.
  public static int partition(int[] arr) {
    int n = arr.length;
    int pivot = n - 1;           // index of the pivot, the last element
    int left = 0;                // left marker
    int right = n - 2;           // right marker, just left of the pivot

    while (left <= right) {
      while (left <= right && arr[left] < arr[pivot]) {
        left++;                  // step past values that belong on the left
      }
      while (left <= right && arr[right] > arr[pivot]) {
        right--;                 // step past values that belong on the right
      }
      if (left <= right) {
        swap(arr, left, right);  // swap the two values the markers stopped on
        left++;
        right--;
      }
    }

    swap(arr, left, pivot);      // move the pivot between the two sides
    return left;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
