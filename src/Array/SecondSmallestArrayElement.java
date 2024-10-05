package Array;
public class SecondSmallestArrayElement {
  public static void main(String[] args) {
    int[] arr = {-1,-2, 20, 4, 45, 99, 4};

    if (arr.length < 2) {
      System.out.println("Array does not have enough elements.");
      return;
    }
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        secondMin = min; // Update secondMin to the old min
        min = arr[i];    // Update min to the new smallest value
      } else if (arr[i] < secondMin && arr[i] != min) {
        secondMin = arr[i]; // Update secondMin to the new second smallest value
      }
    }

    System.out.println(secondMin);
  }
}
