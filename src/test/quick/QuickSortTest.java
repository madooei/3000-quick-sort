package quick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The scenarios for quicksort. A concrete subclass supplies sort() to pick the
 * version under test.
 */
public abstract class QuickSortTest {

  // Calls the version under test.
  protected abstract void sort(int[] a);

  // Sorts a copy of input and checks it against expected.
  private void check(int[] input, int[] expected) {
    int[] a = input.clone();
    sort(a);
    assertArrayEquals(expected, a);
  }

  @Test
  public void emptyArrayStaysEmpty() {
    check(new int[] {}, new int[] {});
  }

  @Test
  public void singleElementStaysPut() {
    check(new int[] {1}, new int[] {1});
  }

  @Test
  public void unsortedArrayGetsSorted() {
    check(new int[] {5, 1, 4, 2}, new int[] {1, 2, 4, 5});
  }

  @Test
  public void alreadySortedArrayIsUnchanged() {
    check(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5});
  }

  @Test
  public void reverseSortedArrayGetsSorted() {
    check(new int[] {5, 4, 3, 2, 1}, new int[] {1, 2, 3, 4, 5});
  }

  @Test
  public void allDuplicatesAreUnchanged() {
    check(new int[] {4, 4, 4, 4}, new int[] {4, 4, 4, 4});
  }

  @Test
  public void manyDuplicatesGetSorted() {
    check(new int[] {2, 3, 1, 2, 3, 1, 2}, new int[] {1, 1, 2, 2, 2, 3, 3});
  }

  @Test
  public void tracedPartitionInputSortsFully() {
    check(new int[] {3, 5, 8, 1, 2, 9, 4, 7, 6},
        new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
  }

  @Test
  public void negativesSortBeforePositives() {
    check(new int[] {-3, 1, -7, 4, 0}, new int[] {-7, -3, 0, 1, 4});
  }

  // A partition that sends equal values to one side would recurse once per
  // element here and overflow the call stack.
  @Test
  public void largeArrayOfEqualValuesGetsSorted() {
    int[] input = new int[100_000];
    java.util.Arrays.fill(input, 7);
    check(input, input.clone());
  }
}
