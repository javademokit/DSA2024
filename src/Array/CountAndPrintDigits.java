package Array;

import java.util.Scanner;

public class CountAndPrintDigits {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter an integer: ");

    // Read input as an integer
    int input = scanner.nextInt();

    // Handle negative numbers
    if (input < 0) {
      input = -input; // Make it positive for processing
    }

    // Variable to count digits
    int count = 0;

    // StringBuilder to collect digits for printing later
    StringBuilder digits = new StringBuilder();

    // Count the number of digits using a while loop
    while (input > 0) {
      int digit = input % 10; // Get the last digit
      digits.insert(0, digit + 1+" "); // Insert the digit at the start
      count++; // Increment count
      input /= 10; // Remove the last digit
    }

    // Print the count of digits
    System.out.println("Number of digits: " + count);
    // Print each digit
    System.out.println("Digits: " + digits.toString().trim());

    scanner.close();
  }
}
