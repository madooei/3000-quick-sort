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
  protected void sort(int[] arr) {
    QuickSortMedianOfThree.quicksort(arr);
  }

  // With a poor pivot on sorted input, the recursion would go once per
  // element deep here and overflow the call stack.
  @Test
  public void largeSortedArrayStaysSorted() {
    int[] arr = new int[100_000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    int[] expected = arr.clone();
    sort(arr);
    assertArrayEquals(expected, arr);
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
    int index = callMedianIndex(new int[] {5, 5, 5});
    assertTrue(index >= 0 && index <= 2);
  }

  // Calls the private static method medianIndex(int[], int, int, int) of
  // QuickSortMedianOfThree on indices 0, 1, and 2 of arr.
  private static int callMedianIndex(int[] arr) {
    try {
      Method method = QuickSortMedianOfThree.class.getDeclaredMethod("medianIndex", int[].class, int.class, int.class, int.class);
      method.setAccessible(true);
      return (int) method.invoke(null, arr, 0, 1, 2);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }
}
