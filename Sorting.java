import java.util.Arrays;

public class Sorting {

  public static void main(String[] args) {
    System.out.println("--- Test selection sort ---");
    int[] a = {3, 2, 5, 1, 7, 8, 9, 2, 7};
    System.out.println("a: " + Arrays.toString(a));
    selectionSort(a, a.length);
    System.out.println("a: " + Arrays.toString(a));

    System.out.println("--- Test bubble sort ---");
    int[] b = {3, 2, 5, 1, 7, 8, 9, 2, 7};
    System.out.println("b: " + Arrays.toString(b));
    bubbleSort(b, b.length);
    System.out.println("b: " + Arrays.toString(b));

    System.out.println("--- Test insertion sort ---");
    int[] c = {3, 2, 5, 1, 7, 8, 9, 2, 7};
    System.out.println("c: " + Arrays.toString(c));
    insertionSort(c, c.length);
    System.out.println("c: " + Arrays.toString(c));
  }

  // Sorts array x in place (modifies the original array)
  // using the selection sort algorithm
  // x: array to be sorted
  // n: number of elements in x
  public static void selectionSort(int[] x, int n) {
    for (int i = 0; i < n - 1; i++) {
      // find the index of the minimum element
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (x[j] < x[minIndex]) {
          minIndex = j;
        }
      }
      // swap the current element with the minimum
      int temp = x[i];
      x[i] = x[minIndex];
      x[minIndex] = temp;
    }
  }

  // Sorts array x in place (modifies the original array)
  // using the bubble sort algorithm
  // x: array to be sorted
  // n: number of elements in x
  public static void bubbleSort(int[] x, int n) {
    boolean swap = true;
    // repeat this process until there are no more swaps
    while (swap) {
      swap = false;
      for (int i = 1; i < n; i++) {
        if (x[i] < x[i - 1]) {
          // swap x[i] and x[i - 1]
          int temp = x[i];
          x[i] = x[i - 1];
          x[i - 1] = temp;
          swap = true;
        }
      }
    }
  }

  // Sorts array x in place (modifies the original array)
  // using the insertion sort algorithm
  // x: array to be sorted
  // n: number of elements in x
  public static void insertionSort(int[] x, int n) {
    // start from the second element of the array
    for (int i = 1; i < n; i++) {
      int curr = x[i];
      int j = i - 1;
      // shift the previous elements forward
      // until the correct spot is found
      while (j >= 0 && x[j] > curr) {
        x[j + 1] = x[j];
        j--;
      }
      // put the current element in the correct spot
      x[j + 1] = curr;
    }
  }

}

