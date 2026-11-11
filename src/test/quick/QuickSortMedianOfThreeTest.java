package quick;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Runs the quicksort scenarios against the median-of-three pivot, then tests
 * the private medianIndex helper through reflection.
 */
public class QuickSortMedianOfThreeTest extends QuickSortTest {

  @Override
  protected void sort(int[] a) {
    QuickSort.quicksortMedianOfThree(a);
  }

  @Test
  public void medianIsTheMiddleIndex() {
    assertEquals(1, callMedianIndex(new int[] {10, 20, 30}));
    assertEquals(1, callMedianIndex(new int[] {30, 20, 10}));
  }

  @Test
  public void medianIsTheFirstIndex() {
    assertEquals(0, callMedianIndex(new int[] {20, 10, 30}));
    assertEquals(0, callMedianIndex(new int[] {20, 30, 10}));
  }

  @Test
  public void medianIsTheLastIndex() {
    assertEquals(2, callMedianIndex(new int[] {10, 30, 20}));
    assertEquals(2, callMedianIndex(new int[] {30, 10, 20}));
  }

  @Test
  public void medianOfThreeEqualValues() {
    int m = callMedianIndex(new int[] {5, 5, 5});
    assertTrue(m >= 0 && m <= 2);
  }

  // Calls the private static method medianIndex(int[], int, int, int) of
  // QuickSort on indices 0, 1, and 2 of a.
  private static int callMedianIndex(int[] a) {
    try {
      Method method = QuickSort.class.getDeclaredMethod("medianIndex", int[].class, int.class, int.class, int.class);
      method.setAccessible(true);
      return (int) method.invoke(null, a, 0, 1, 2);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }
}
