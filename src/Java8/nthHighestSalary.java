package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class nthHighestSalary {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();

    // Populate the HashMap with employee names and salaries
    map.put("Abrar", 20000);
    map.put("Chand", 35000);
    map.put("Kalam", 45000);
    map.put("Raheem", 35000);
    map.put("Kiran", 50000);
    map.put("Esa", 45000);
    int n = 3;
    Map.Entry<Integer, List<String>> res = getDynamicNthHighestSalary(map, n);
    System.out.println(res);

    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

    List<String> filteredNames = names.stream()
      .filter(name -> name.startsWith("A"))
      .map(String::toUpperCase)
      .collect(Collectors.toList());
    System.out.println(filteredNames); // Output: [ALICE]

  }

  // Method to find the nth highest salary dynamically
  public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(Map<String, Integer> employeeSalaries, int n) {
    // Using Java Streams to process the map and find the nth highest salary

    // 1. Group employee names by their corresponding salaries
    return employeeSalaries.entrySet()
      .stream()
      .collect(Collectors.groupingBy(
        Map.Entry::getValue, // Group by salary
        Collectors.mapping(Map.Entry::getKey, Collectors.toList()) // Collect employee names as a list for each salary
      ))
      .entrySet()
      .stream()
      // 2. Sort the map entries by salary in descending order
      .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
      // 3. Collect the sorted map entries into a List
      .collect(Collectors.toList())
      // 4. Get the nth element from the list (n - 1 as list index starts from 0)
      .get(n - 1);
  }


}
