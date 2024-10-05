package BinarryTree;

import java.util.*;
 //Definition for a binary tree node.
 class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
   TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;}
  }

class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    //check for empty input
    if(preorder.length == 0 || inorder.length == 0){
      return null;
    }

    //initialize a hashmap for inorder traversal
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < inorder.length; i++){
      map.put(inorder[i], i);
    }

    //call helper function
    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
  }

  public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
    //base case
    if(preStart > preEnd || inStart > inEnd){
      return null;
    }

    //create the root node with the first element in the preorder traversal
    TreeNode root = new TreeNode(preorder[preStart]);

    //find the index of the root node in the inorder traversal
    int inRoot = map.get(root.val);

    //calculate the number of nodes in the left subtree
    int numsLeft = inRoot - inStart;

    //recursively build the left and right subtrees
    root.left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
    root.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

    return root;
  }
}