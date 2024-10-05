package Linkedlist;

class Node
{
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}
public class LinkedList1 {

  static Node head;

  Node reverse(Node node)
  {
    Node prev = null;
    Node current = node;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  public void display(Node head)
  {
    while(head!=null)
    {
      System.out.println(head.data);
      head= head.next;
    }
  }
  public void push(int data)
  {
    Node temp = new Node(data);
    temp.next=head;
    head=temp;
  }

  void deleteNode(int position)
  {
    if (head == null)
      return;
    Node temp = head;
    if (position == 0)
    {
      head = temp.next;
      return;
    }
    for (int i=0; temp!=null && i<position-1; i++)
      temp = temp.next;
    if (temp == null || temp.next == null)
      return;
    Node next1 = temp.next.next;

    temp.next = next1;
  }
  static int largestElement(Node head)
  {

    int max = Integer.MIN_VALUE;
    while (head != null)
    {
      if (max < head.data)
        max = head.data;
      head = head.next;
    }
    return max;
  }
  static int smallestElement(Node head)
  {
    int min = Integer.MAX_VALUE;
    while (head != null)
    {
      if (min > head.data)
        min = head.data;
      head = head.next;
    }
    return min;
  }

  void pairWiseSwap()
  {
    Node temp = head;
    /* Traverse only till there are atleast 2 nodes left */
    while (temp != null && temp.next != null) {

      /* Swap the data */
      int k = temp.data;
      temp.data = temp.next.data;
      temp.next.data = k;
      temp = temp.next.next;
    }
  }
  // Delete the head node and return the new head
  static Node deleteHead(Node head) {

    // Check if the list is empty
    if (head == null)
      return null;

    // Store the current head in a temporary variable
    Node temp = head;

    // Move the head pointer to the next node
    head = head.next;

    // Help the garbage collector by
    // removing the reference
    temp = null;

    return head;
  }

  // Function to delete a node at a given position
  public static Node deleteNode(Node head, int position)
  {
    Node temp = head;
    Node prev = null;

    // Base case if linked list is empty
    if (temp == null)
      return head;

    // Case 1: Head is to be deleted
    if (position == 1) {
      head = temp.next;
      return head;
    }

    // Case 2: Node to be deleted is in middle
    // Traverse till given position
    for (int i = 1; temp != null && i < position; i++) {
      prev = temp;
      temp = temp.next;
    }

    // If given position is found, delete node
    if (temp != null) {
      prev.next = temp.next;
    }
    else {
      System.out.println("Data not present");
    }

    return head;
  }

  // Function to find Nth node from the end of linked list
  static int nthFromEnd(Node head, int N) {

    // Create two pointers main_ptr and ref_ptr
    // initially pointing to head.
    Node main_ptr = head;
    Node ref_ptr = head;

    // Move ref_ptr to the N-th node from beginning.
    for (int i = 1; i < N; i++) {
      ref_ptr = ref_ptr.next;

      // If the ref_ptr reaches NULL, then it means
      // N > length of linked list
      if (ref_ptr == null) {
        return -1;
      }
    }

    // Move ref_ptr and main_ptr by one node until
    // ref_ptr reaches last node of the list.
    while (ref_ptr.next != null) {
      ref_ptr = ref_ptr.next;
      main_ptr = main_ptr.next;
    }

    return main_ptr.data;
  }


  public static void main(String[] args) {

    LinkedList1 ls = new LinkedList1();
    ls.head = new Node(1);
    ls.head.next = new Node(2);
    ls.head.next.next=new Node(3);
    ls.head.next.next.next=new Node(4);

    ls.display(head);
    System.out.println("reverse ");
    ls.head=ls.reverse(ls.head);
    ls.display(head);

  }




}
