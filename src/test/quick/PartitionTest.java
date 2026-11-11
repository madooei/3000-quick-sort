package quick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the standalone whole-array partition. Two things are checked: the
 * exact result on the traced example from the notes, and the partition property
 * on a range of inputs — everything left of the returned index is at most the
 * pivot, everything right of it is at least the pivot.
 */
public class PartitionTest {

  // Checks the partition property: the returned index p holds the original
  // pivot value (the last element), everything before p is <= a[p], and
  // everything after p is >= a[p].
  private void checkProperty(int[] input) {
    int pivot = input[input.length - 1];
    int[] a = input.clone();
    int p = Partition.partition(a);

    assertEquals(pivot, a[p], "pivot value should sit at the returned index");
    for (int i = 0; i < p; i++) {
      assertTrue(a[i] <= a[p], "left side should be <= pivot at index " + i);
    }
    for (int i = p + 1; i < a.length; i++) {
      assertTrue(a[i] >= a[p], "right side should be >= pivot at index " + i);
    }
  }

  @Test
  public void tracedExampleFromTheNotes() {
    int[] a = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    int p = Partition.partition(a);
    assertEquals(5, p);
    assertArrayEquals(new int[] {3, 5, 4, 1, 2, 6, 8, 7, 9}, a);
  }

  @Test
  public void singleElementReturnsZero() {
    int[] a = {7};
    assertEquals(0, Partition.partition(a));
    assertArrayEquals(new int[] {7}, a);
  }

  @Test
  public void twoElementsAlreadyOrdered() {
    checkProperty(new int[] {1, 2});
  }

  @Test
  public void twoElementsReversed() {
    checkProperty(new int[] {2, 1});
  }

  @Test
  public void pivotIsAlreadyLargest() {
    checkProperty(new int[] {4, 1, 3, 2, 5});
  }

  @Test
  public void pivotIsAlreadySmallest() {
    checkProperty(new int[] {4, 5, 3, 2, 1});
  }

  @Test
  public void allEqualValues() {
    checkProperty(new int[] {4, 4, 4, 4});
  }

  @Test
  public void withDuplicatesOfThePivot() {
    checkProperty(new int[] {6, 2, 6, 1, 6});
  }

  // Both markers stop on values equal to the pivot, so equal values are
  // spread across both sides and the pivot lands in the middle.
  @Test
  public void allEqualValuesSplitInTheMiddle() {
    int[] a = {7, 7, 7, 7, 7, 7, 7, 7, 7};
    assertEquals(4, Partition.partition(a));
  }
}
