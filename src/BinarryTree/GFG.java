package BinarryTree;

// Java implementation to print
// the nodes having a single child
import java.util.Vector;

// Class of the Binary Tree node
class Node1
{
  int data;
  Node1 left, right;

  Node1(int data)
  {
    this.data = data;
  }
}

class GFG{

  // List to keep track of nodes
// having single child
  static Vector<Integer> list = new Vector<>();

  // Function to find the nodes
// having single child
  static void printNodesOneChild(Node1 root)
  {
    // Base case
    if (root == null)
      return;

    // Condition to check if the node
    // is having only one child
    if (root.left != null && root.right == null ||
      root.left == null && root.right != null)
    {
      list.add(root.data);
    }

    // Traversing the left child
    printNodesOneChild(root.left);

    // Traversing the right child
    printNodesOneChild(root.right);
  }

  // Driver code
  public static void main(String[] args)
  {

    // Constructing the binary tree
    Node1 root = new Node1(2);
    root.left = new Node1(3);
    root.right = new Node1(5);
    root.left.left = new Node1(7);
    root.right.left = new Node1(8);
    root.right.right = new Node1(6);

    // Function calling
    printNodesOneChild(root);

    // Condition to check if there is
    // no such node having single child
    if (list.size() == 0)
      System.out.println(-1);
    else
    {
      for(int value : list)
      {
        System.out.println(value);
      }
    }
  }
}

// This code is contributed by sumit_9
