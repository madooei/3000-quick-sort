package quick;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Runs the quicksort scenarios against the last-element pivot, then tests the
 * private slice partition through reflection.
 */
public class QuickSortLastElementTest extends QuickSortTest {

  @Override
  protected void sort(int[] a) {
    QuickSort.quicksort(a);
  }

  @Test
  public void partitionLeavesValuesOutsideTheSliceAlone() {
    int[] a = {90, 30, 10, 50, 20, 80};
    assertEquals(2, callPartition(a, 1, 4));
    assertArrayEquals(new int[] {90, 10, 20, 50, 30, 80}, a);
  }

  @Test
  public void partitionOfTheTracedExample() {
    int[] a = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    assertEquals(5, callPartition(a, 0, 8));
    assertArrayEquals(new int[] {3, 5, 4, 1, 2, 6, 8, 7, 9}, a);
  }

  @Test
  public void partitionSplitsEqualValuesInTheMiddle() {
    int[] a = {7, 7, 7, 7, 7, 7, 7, 7, 7};
    assertEquals(4, callPartition(a, 0, 8));
  }

  // Calls the private static method partition(int[], int, int) of QuickSort.
  private static int callPartition(int[] a, int lo, int hi) {
    try {
      Method method = QuickSort.class.getDeclaredMethod("partition", int[].class, int.class, int.class);
      method.setAccessible(true);
      return (int) method.invoke(null, a, lo, hi);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }
}
