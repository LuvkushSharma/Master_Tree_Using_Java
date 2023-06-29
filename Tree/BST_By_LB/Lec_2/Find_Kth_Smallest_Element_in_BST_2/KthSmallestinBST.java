package Lec_2.Find_Kth_Smallest_Element_in_BST_2;

/*

Given the root of a binary search tree, and an integer k, return the kth smallest
value (1-indexed) of all the values of the nodes in the tree.

Example 1:

img

Input: root = [3,1,4,null,2], k = 1
Output: 1


Example 2:

img_1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

 */

/*

                               5
                            /      \
                          4          8
                        /          /   \
                       2          6     10
                        \           \
                         3            7

                         k = 3

   -------------------------  Approach -1 --------------------

            TC : O(n)

   ------>  We know that inorder traversal of BST is sorted.

            2  3  4   5  6  7  8  10

            Let's say we start the counter (i) by 0. i.e i = 0

            Inorder : Left Root Right

            So, in case of inorder first left call occurs. i.e. we goes to 4.
            again left call occurs so we reach to 2. Again left call occurs and we got null i.e return and print data.
            So, instead of printing we will increment the counter by 1. i.e i = 1

            Similarly, now right call occurs at 2. And we reached to 3.
            Left call at 3 returns null. Now i += 1 i.e 2.
            Right call of 3 occurs and return.

            from 2 also return as we had called all the recursive functions for 2.

            Now we reached to 4 as it's left subtree calls are done.
            So, i += 1 i.e i = 3

            return 4.  ------> as i == k

 */

import java.util.Scanner;

public class KthSmallestinBST {

    Scanner sc = new Scanner(System.in);

    // Class for the node of the tree
    class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        // Constructor
        public TreeNode (int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    // Constructor for BST
    public KthSmallestinBST() {

        Create_BST ();
    }

    private void Create_BST () {

        System.out.println("Enter the data for BST : ");
        int val = sc.nextInt();

        // Taking User input till we donot get -1
        while (val != -1) {

            this.root = insertIntoBST(root , val);
            val = sc.nextInt();
        }
    }

    private TreeNode insertIntoBST (TreeNode root , int val) {

        if (root == null) {

            TreeNode nn = new TreeNode(val);
            return nn;
        }

        // right part main insert karna hain
        if (val > root.data) {

            root.right = insertIntoBST (root.right , val);

        } else { // left part main insert karna hain

            root.left = insertIntoBST (root.left , val);
        }

        return root;
    }

    public int kthSmallest (int k) {

        return kthSmallest (this.root , k);
    }


    private int kthSmallest (TreeNode root , int k) {

        int ans = solve (root , k);

        return ans;
    }

    private int counter = 0;
    // Inorder Way main gaye.
    private int solve (TreeNode root  , int k) {

        // Base Case
        if (root == null)
            return -1;

        // L
        int left = solve (root.left , k);

        if (left != -1) {

            return left;
        }

        // N
        counter += 1;

        if (counter == k) {
            return root.data;
        }

        // R
        return solve (root.right , k);
    }
}
