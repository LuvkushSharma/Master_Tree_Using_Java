package Lecture_5.Validate_Binary_Search_Tree_2;

/*

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

1. The left subtree of a node contains only nodes with keys less than the node's key.
2. The right subtree of a node contains only nodes with keys greater than the node's key.
3. Both the left and right subtrees must also be binary search trees.

Example-1:

img1

Input: root = [2,1,3]
Output: true

Example-2:

img2

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1


 */

import java.util.Scanner;

public class Validate_BST {

    Scanner sc = new Scanner(System.in);

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    private TreeNode root;

    // Constructor for tree
    public Validate_BST () {

        this.root = Create_Binary_Tree();
    }

    // --------------- Tree Creation -------------

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

    // ------------------------ Is Binary Search Tree -----------------------

    public boolean isValidBST () {

        return isValidBST(root).isbst;
    }

    // TC : O(n)
    private BstPair isValidBST (TreeNode root) {

        // Base Case
        if (root == null) {

            return new BstPair();
        }

        BstPair left_bst_pair = isValidBST(root.left); // Contains whether left subtree is Bst or not , min_value of left subtree and max_value.
        BstPair right_bst_pair = isValidBST(root.right); // Contains whether right subtree is Bst or not , min_value of right subtree and max_value.

        BstPair self_bst_pair = new BstPair();

        self_bst_pair.min = Math.min(root.val , Math.min(left_bst_pair.min , right_bst_pair.min));
        self_bst_pair.max = Math.max(root.val , Math.max(left_bst_pair.max , right_bst_pair.max));

        // Koi node BST kii property tab follow karegyi if:
        // It's left subtree is BST
        // It's right subtree is BST
        // It's data should be greater than the left subtree max and should be less than right subtree max.
        boolean isBST = left_bst_pair.isbst && right_bst_pair.isbst && (root.val > left_bst_pair.max && root.val < right_bst_pair.min);

        self_bst_pair.isbst = isBST;

        return self_bst_pair;
    }

    // Since , Min value of integer is 2^31 - 1  , and it is given in the constraint that node value can reach to this value.
    // It means if we want to initialize the min and max then we need a long variable instead of int.

    // This class contains three Information.
    class BstPair {

        boolean isbst = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

    }

}
