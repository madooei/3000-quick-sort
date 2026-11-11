package quick;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

  // With a poor pivot on sorted input, the recursion would go once per
  // element deep here and overflow the call stack.
  @Test
  public void largeSortedArrayStaysSorted() {
    int[] a = new int[100_000];
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
    int[] expected = a.clone();
    sort(a);
    assertArrayEquals(expected, a);
  }

  @Test
  public void medianIsTheMiddleIndexWhenAscending() {
    assertEquals(1, callMedianIndex(new int[] {10, 20, 30}));
  }

  @Test
  public void medianIsTheMiddleIndexWhenDescending() {
    assertEquals(1, callMedianIndex(new int[] {30, 20, 10}));
  }

  @Test
  public void medianIsTheFirstIndexWhenLastIsLargest() {
    assertEquals(0, callMedianIndex(new int[] {20, 10, 30}));
  }

  @Test
  public void medianIsTheFirstIndexWhenLastIsSmallest() {
    assertEquals(0, callMedianIndex(new int[] {20, 30, 10}));
  }

  @Test
  public void medianIsTheLastIndexWhenFirstIsSmallest() {
    assertEquals(2, callMedianIndex(new int[] {10, 30, 20}));
  }

  @Test
  public void medianIsTheLastIndexWhenFirstIsLargest() {
    assertEquals(2, callMedianIndex(new int[] {30, 10, 20}));
  }

  @Test
  public void medianOfThreeEqualValuesIsOneOfTheIndices() {
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
