# Quicksort

`Partition` rearranges a whole array around its last element with two markers, so the pivot lands in its final sorted position. `QuickSort` sorts an array by partitioning a slice and then sorting each side the same way, in two versions: one takes the last element of each slice as the pivot, and one takes the median of the first, middle, and last elements. A JUnit suite runs the same scenarios against both versions and checks the private helpers through reflection.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      quick/
        Partition.java                      # whole-array two-marker partition
        QuickSort.java                      # last-element pivot and median-of-three
    test/
      quick/
        PartitionTest.java
        QuickSortTest.java                  # the scenarios both versions share
        QuickSortLastElementTest.java       # runs them with the last-element pivot
        QuickSortMedianOfThreeTest.java     # runs them with median-of-three
  scripts/
    test.sh                                 # compile and run the JUnit tests
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh quick.QuickSortLastElementTest` — compiles everything and runs only that test class.

## What's here

- `quick.Partition` — `partition`, the whole-array partition the notes trace.
- `quick.QuickSort` — `quicksort`, with the last element as the pivot, and `quicksortMedianOfThree`. They use private helpers: a recursive version of each that sorts a slice, `partition` on a slice, and `medianIndex`, which returns the index of the median of three elements.
- `quick.PartitionTest` — checks that the pivot lands in place, with no larger value to its left and no smaller value to its right, and checks the example the notes trace.
- `quick.QuickSortTest` and its two subclasses — the sort scenarios, run once per version. `QuickSortLastElementTest` also checks the slice `partition`, and `QuickSortMedianOfThreeTest` checks `medianIndex`, both through reflection.
