package Java8;

import java.util.Arrays;
import java.util.Optional;

public class SecondSmallestElement {
  public static void main(String[] args) {
    int[] array = {1,2,3,4,5};

    Optional<Integer> secondSmallest = Arrays.stream(array)
      .boxed() // Convert int to Integer to work with Stream API
      .distinct() // Remove duplicates
      .sorted() // Sort in ascending order
      .skip(1) // Skip the first element (smallest)
      .findFirst(); // Get the next element (second smallest)

    if (secondSmallest.isPresent()) {
      System.out.println("Second smallest element: " + secondSmallest.get());
    } else {
      System.out.println("No second smallest element found.");
    }
  }
}
