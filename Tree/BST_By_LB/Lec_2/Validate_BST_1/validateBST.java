package Lec_2.Validate_BST_1;

/*

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:

img

Input: root = [2,1,3]
Output: true

Example 2:

img_1

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

 */

/*
     ---------------------- Approach-1 ----------------------

----> As we know that inorder traversal of BST is sorted.

      So, first find the inorder traversal and then check whether it is sorted or not.

      -------------------- Approach-2 ---------------------

      BST Prop-1  : For each node left subtree's key should be less than the root node's key and
      BST Prop-2  : right subtree's node keys should be greater than the root node's key.

      We'll use range to solve this problem.

                          (-inf , inf)
                              4
                            /    \
              (-inf,4)    2        5 (4 , inf)
                        /   \
                      1       3
             (-inf , 2)      (2 , 4)

       --------> Initially root node's range is -infinity to infinity.

       --------> Now, on the left of 4 ---> max value should be less than 4 i.e. BST Prop-1.
                 And , minimum it can go up to -infinity.

       --------> On standing at 2, we know that it's left subtree's nodes keys should be less than it's value i.e 2
                 max value that can reach in the 2's left subtree should be less than 2.
                 And minimum it can go up to -infinity.

       --------> On standing at 2, we know that it's right subtree's nodes keys should be greater than it's value i.e 2.
                 i.e. minimum value that can be taken by the right subtree of 2 should be greater than 2.
                 And Maximum it should take is less than 4 as 2 itself is the left child of 4 i.e 3 comes in the left of 4 so, it should not cross 4.

       --------> On standing at 4 , we know that right subtree of 4 should have keys greater than 4.
                 i.e. minimum value taken by the right subtree nodes  should be greater than 4.
                 And maximum it can go utp infinity.
 */


import java.util.Scanner;

public class validateBST {

    Scanner sc = new Scanner(System.in);

    // Creating nodes for the tree using this class
    public class TreeNode{

        int data;

        // These will be initialised as null
        TreeNode left;
        TreeNode right;

    }

    private TreeNode root;

    // Constructor of binary tree
    public validateBST(){

        this.root = CreateTree();
    }

    // ------------------ Tree Creation Code ---------------------

    private TreeNode CreateTree(){

        System.out.println("Enter the data : ");
        int item = sc.nextInt();

        TreeNode nn = new TreeNode();
        nn.data = item;

        boolean has_left_child = sc.nextBoolean();

        if(has_left_child == true) {

            nn.left = CreateTree();
        }

        boolean has_right_child = sc.nextBoolean();

        if(has_right_child == true) {

            nn.right = CreateTree();
        }

        return nn;
    }


    // -------------------- Validate BST Code  -------------------

    public boolean isValidBST () {

        return isValidBST (this.root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private boolean isValidBST (TreeNode root , int min , int max) {

        // Base Case
         if (root == null) {
             return true;
         }

         if (root.data > min && root.data < max) {

             // For left subtree of root node. Max value should be less than root.data
             // and min can be -inf
             boolean left = isValidBST (root.left , min , root.data);

             // For right subtree of root node. Min value should be greater than root.data.
             // And , max it can go up to inf.
             boolean right = isValidBST (root.right , root.data , max);

             return left && right;

         } else {

             return false;
         }
    }
}
