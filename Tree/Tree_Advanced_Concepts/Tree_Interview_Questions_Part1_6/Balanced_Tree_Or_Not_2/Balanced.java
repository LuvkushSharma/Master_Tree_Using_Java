package Tree_Interview_Questions_Part1_6.Balanced_Tree_Or_Not_2;

import java.util.Scanner;

/*

Given a binary tree, find if it is height balanced or not.
A tree is height balanced if difference between heights of left and right subtrees
is not more than one for all nodes of tree.

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /
   10
  /
5

Example 1:

Input:
      1
    /
   2
    \
     3
Output: 0
Explanation: The max difference in height
of left subtree and right subtree is 2,
which is greater than 1. Hence unbalanced

Example 2:

Input:
       10
     /   \
    20   30
  /   \
 40   60
Output: 1
Explanation: The max difference in height
of left subtree and right subtree is 1.
Hence balanced.
Your Task:
You don't need to take input. Just complete the function isBalanced() that takes root node as parameter and returns true, if the tree is balanced else returns false.

Constraints:
1 <= Number of nodes <= 105
0 <= Data of a node <= 106

Expected time complexity: O(N)
Expected auxiliary space: O(h) , where h = height of tree




 */

public class Balanced {

    Scanner sc = new Scanner(System.in);

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // Constructor of the Binary Tree
    public Balanced() {

        this.root = Create_Binary_Tree ();
    }

    private TreeNode Create_Binary_Tree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode (data);

        System.out.println("Left of " + data + " ");
        boolean hasLeftNode = sc.nextBoolean();
        if (hasLeftNode == true) {

            root.left = Create_Binary_Tree();
        }

        System.out.println("Right of " + data + " ");
        boolean hasRightNode = sc.nextBoolean();
        if (hasRightNode == true) {

            root.right = Create_Binary_Tree();
        }

        return root;
    }

    public boolean isBalanced () {

        return isBalanced(root);
    }

    // TC : O(n^2)
    private boolean isBalanced (TreeNode root) {

        // Base Case
        // -------> Single node is always balanced.
        if (root == null) {
            return true;
        }

        boolean left = isBalanced(root.left); // Left balance hain ?
        boolean right = isBalanced(root.right); // Right balance hain ?

        boolean diff = Math.abs (height (root.left) - height (root.right)) <= 1; // Kya main balance huun

        if (left == true && right == true && diff == true) {

            return true;

        } else {

            return false;
        }
    }

    private int height (TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        int left = height (root.left);
        int right = height (root.right);

        int ans = Math.max(left , right) + 1;

        return ans;
    }

}
