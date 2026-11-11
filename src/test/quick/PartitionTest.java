package quick;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for the whole-array partition. */
public class PartitionTest {

  // Partitions a copy of input and checks the partition property: the pivot
  // (the last element) sits at the returned index p, every value before p is
  // at most the pivot, and every value after p is at least the pivot.
  private void checkProperty(int[] input) {
    int pivot = input[input.length - 1];
    int[] a = input.clone();
    int p = Partition.partition(a);

    assertEquals(pivot, a[p], "pivot value should sit at the returned index");
    for (int i = 0; i < p; i++) {
      assertTrue(a[i] <= pivot, "left side should be <= pivot at index " + i);
    }
    for (int i = p + 1; i < a.length; i++) {
      assertTrue(a[i] >= pivot, "right side should be >= pivot at index " + i);
    }
  }

  @Test
  public void singleElementReturnsZero() {
    int[] a = {7};
    assertEquals(0, Partition.partition(a));
  }

  @Test
  public void singleElementStaysPut() {
    int[] a = {7};
    Partition.partition(a);
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
  public void returnsThePivotsSortedPosition() {
    int[] a = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    assertEquals(5, Partition.partition(a));
  }

  @Test
  public void swapsOutOfPlacePairsAndThenPlacesThePivot() {
    int[] a = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    Partition.partition(a);
    assertArrayEquals(new int[] {3, 5, 4, 1, 2, 6, 8, 7, 9}, a);
  }

  @Test
  public void withDuplicatesOfThePivot() {
    checkProperty(new int[] {6, 2, 6, 1, 6});
  }

  @Test
  public void allEqualValues() {
    checkProperty(new int[] {4, 4, 4, 4});
  }

  // Both markers stop on values equal to the pivot, so equal values are
  // spread across both sides and the pivot lands in the middle.
  @Test
  public void allEqualValuesSplitInTheMiddle() {
    int[] a = {7, 7, 7, 7, 7, 7, 7, 7, 7};
    assertEquals(4, Partition.partition(a));
  }
}
