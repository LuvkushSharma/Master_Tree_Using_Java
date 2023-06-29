package Lecture_5.Maximum_Sum_BST_in_Binary_tree_4;

import java.util.Scanner;

/*

Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.

Example 2:

Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.

Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.


Constraints:

The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104



 */

public class maxSumBST {

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
    public maxSumBST (){

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

    // ------------------------ Max Sum BST in a Binary Tree -----------------------

    public int findMaxSumBST () {

        return findMaxSumBST(root).ans;
    }

    // TC : O(n)
    private BstPair findMaxSumBST (TreeNode root) {

        // Base Case
        if (root == null) {

            return new BstPair();
        }

        BstPair left_bst_pair = findMaxSumBST(root.left); // Contains whether left subtree is Bst or not , min_value of left subtree and max_value.
        BstPair right_bst_pair = findMaxSumBST(root.right); // Contains whether right subtree is Bst or not , min_value of right subtree and max_value.

        BstPair self_bst_pair = new BstPair();

        self_bst_pair.min = Math.min(root.val , Math.min(left_bst_pair.min , right_bst_pair.min));
        self_bst_pair.max = Math.max(root.val , Math.max(left_bst_pair.max , right_bst_pair.max));

        // Koi node BST kii property tab follow karegyi if:
        // It's left subtree is BST
        // It's right subtree is BST
        // It's data should be greater than the left subtree max and should be less than right subtree max.
        boolean isBST = left_bst_pair.isbst && right_bst_pair.isbst && (root.val > left_bst_pair.max && root.val < right_bst_pair.min);

        self_bst_pair.isbst = isBST;

        // Entire tree sum
        self_bst_pair.sum = left_bst_pair.sum + right_bst_pair.sum + root.val;

        // Mera left bhi BST hain and Mera right bhi bst hain and Main khud bhi BST huun.
        if (self_bst_pair.isbst == true) {

            // It is given in the constraint that data can be negative i.e. we
            self_bst_pair.ans = Math.max (self_bst_pair.sum, Math.max(left_bst_pair.ans, right_bst_pair.ans));


        } else { // Tum bst nhi bana rahe toh koi dikkat nhi apne left yaa fir right main se jisne bhi BST banaaya hain toh woh unka size bhej do.

            self_bst_pair.ans = Math.max (left_bst_pair.ans , right_bst_pair.ans);
        }

        return self_bst_pair;
    }

    // Since , Min value of integer is 2^31 - 1  , and it is given in the constraint that node value can reach to this value.
    // It means if we want to initialize the min and max then we need a long variable instead of int.

    // This class contains three Information.
    class BstPair {

        boolean isbst = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        int sum = 0; // ----------> tells whole tree sum
        int ans = 0;  // ---------> BST portion sum

    }
}
