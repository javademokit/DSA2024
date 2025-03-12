package SortStackRecursion;

import java.util.Stack;

public class SortStackRecursion {

    // Sorts the stack in ascending order (smallest element on top)
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove the top element
            sortStack(stack);      // Sort the remaining stack recursively
            insertSorted(stack, top); // Insert top back in the sorted stack
        }
    }

    // Helper function to insert an element into the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: stack is empty OR top element is smaller than current element
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop(); // Remove the top item
            insertSorted(stack, element); // Recursively insert the element
            stack.push(temp); // Push the previous top item back
        }
    }

    // Helper function to print the stack
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("\nSorted Stack:");
        printStack(stack);
    }
}
