package Flatten_a_Binary_Tree_5;

/*

Given the root of a binary tree, flatten the tree into a "linked list":

1. The "linked list" should use the same TreeNode class where the right child pointer points to the next
   node in the list and the left child pointer is always null.

2. The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Input :
          1
        /   \
       2     5
      / \     \
     3   4     6

Output :
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6

Input :
        1
       / \
      3   4
         /
        2
         \
          5
Output :
     1
      \
       3
        \
         4
          \
           2
            \
             5

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

 */

import java.util.Scanner;

public class Flatten_a_Binary_Tree {

    Scanner sc = new Scanner(System.in);

    // Node class for the tree
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // Constructor for tree
    public Flatten_a_Binary_Tree () {

        this.root = BuildTree ();
    }

    private TreeNode BuildTree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();

        TreeNode root = new TreeNode (data);

        boolean hasLeftChild = sc.nextBoolean();

        if (hasLeftChild == true) {

            root.left = BuildTree ();
        }

        boolean hasRightChild = sc.nextBoolean();
        if (hasRightChild == true) {

            root.right = BuildTree ();
        }

        return root;
    }

    public void flatten () {

        flatten (root);
    }

    private void flatten(TreeNode root){

            TreeNode curr = root;

            while(curr != null){

                if(curr.left != null){

                    // Finding predecessor
                    TreeNode prev = curr.left;
                    while(prev.right != null){
                        prev = prev.right;
                    }

                    TreeNode predecessor = prev;
                    predecessor.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }

                curr = curr.right;
            }
    }

    public void displayFlattenedTree () {

        displayFlattenedTree (root);

    }

    private void displayFlattenedTree (TreeNode root) {

        while (root != null) {

            System.out.print (root.val + "--->");

            root = root.right;
        }

        System.out.println("null");
    }
}

