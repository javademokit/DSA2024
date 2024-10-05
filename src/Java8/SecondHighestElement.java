package Java8;

import java.util.Arrays;
import java.util.Optional;

public class SecondHighestElement {
  public static void main(String[] args) {
    int[] array = {10, 20, 4, 45, 99, 99};

    Optional<Integer> secondHighest = Arrays.stream(array)
      .boxed() // Convert int to Integer to work with Stream API
      .distinct() // Remove duplicates
      .sorted((a, b) -> b - a) // Sort in descending order
      .skip(1) // Skip the first element (highest)
      .findFirst(); // Get the next element (second highest)

    if (secondHighest.isPresent()) {
      System.out.println("Second highest element: " + secondHighest.get());
    } else {
      System.out.println("No second highest element found.");
    }
  }
}
