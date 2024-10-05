package Java8;
/*10. Explain the difference between findFirst() and findAny() in Streams.
  Answer:

  findFirst(): Returns the first element of the stream, if it exists. It is more suitable for ordered streams where the order matters.
  findAny(): Returns any element from the stream, and is generally more efficient in parallel streams where the order does not matter.*/
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindExample {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

    Optional<String> first = names.stream().findFirst();
    System.out.println("First: " + first.orElse("No name")); // Output: Alice

    Optional<String> any = names.stream().findAny();
    System.out.println("Any: " + any.orElse("No name")); // Output may vary
  }
}
