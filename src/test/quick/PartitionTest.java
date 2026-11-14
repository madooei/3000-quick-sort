package quick;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for the whole-array partition. */
public class PartitionTest {

  // Partitions a copy of input and checks the partition property: the pivot
  // (the last element) sits at the returned index pivotIndex, every value
  // before pivotIndex is at most the pivot, and every value after pivotIndex
  // is at least the pivot.
  private void checkProperty(int[] input) {
    int pivot = input[input.length - 1];
    int[] arr = input.clone();
    int pivotIndex = Partition.partition(arr);

    assertEquals(pivot, arr[pivotIndex], "pivot value should sit at the returned index");
    for (int i = 0; i < pivotIndex; i++) {
      assertTrue(arr[i] <= pivot, "left side should be <= pivot at index " + i);
    }
    for (int i = pivotIndex + 1; i < arr.length; i++) {
      assertTrue(arr[i] >= pivot, "right side should be >= pivot at index " + i);
    }
  }

  @Test
  public void singleElementReturnsZero() {
    int[] arr = {7};
    assertEquals(0, Partition.partition(arr));
  }

  @Test
  public void singleElementStaysPut() {
    int[] arr = {7};
    Partition.partition(arr);
    assertArrayEquals(new int[] {7}, arr);
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
    int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    assertEquals(5, Partition.partition(arr));
  }

  @Test
  public void swapsOutOfPlacePairsAndThenPlacesThePivot() {
    int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
    Partition.partition(arr);
    assertArrayEquals(new int[] {3, 5, 4, 1, 2, 6, 8, 7, 9}, arr);
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
    int[] arr = {7, 7, 7, 7, 7, 7, 7, 7, 7};
    assertEquals(4, Partition.partition(arr));
  }
}
