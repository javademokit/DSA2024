package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExceptionExample {
  public static void main(String[] args) {
    List<String> numbers = Arrays.asList("1", "2", "a", "4");

    List<Integer> result = numbers.stream()
      .map(s -> {
        try {
          return Integer.parseInt(s);
        } catch (NumberFormatException e) {
          System.out.println("kkkk");
          return null; // Handle or log exception as needed
        }
      })
      .filter(num -> num != null)
      .collect(Collectors.toList());

    System.out.println(result); // Output: [1, 2, 4]
  }
}
