package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    // Sample data
    List<Employee> employees = Arrays.asList(
      new Employee("Alice", 28),
      new Employee("Bob", 35),
      new Employee("Charlie", 40),
      new Employee("David", 25)
    );

    // Stream to filter and collect names of employees older than 30
    List<String> namesOfOlderEmployees = employees.stream()
      .filter(employee -> employee.getAge() > 30)  // Filter employees older than 30
      .map(Employee::getName)                      // Extract names
      .collect(Collectors.toList());               // Collect names into a list

    // Print the result
    System.out.println(namesOfOlderEmployees);
  }
}
