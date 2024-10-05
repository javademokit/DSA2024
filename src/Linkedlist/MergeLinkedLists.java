package Linkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class MergeLinkedLists {
  public static void main(String[] args) {
    // Create two LinkedLists
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();

    // Add elements to list1
    list1.add(10);
    list1.add(20);
    list1.add(30);

    // Add elements to list2
    list2.add(15);
    list2.add(25);
    list2.add(5);

    // Merge the two LinkedLists
    LinkedList<Integer> mergedList = mergeLinkedLists(list1, list2);

    // Optionally, sort the merged list
    Collections.sort(mergedList);

    // Print the sorted merged list
    System.out.println("Merged and sorted LinkedList: " + mergedList);
  }

  public static LinkedList<Integer> mergeLinkedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    LinkedList<Integer> mergedList = new LinkedList<>(list1);
    mergedList.addAll(list2);
    return mergedList;
  }
}
