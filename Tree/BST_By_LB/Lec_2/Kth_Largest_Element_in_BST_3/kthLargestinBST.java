package Lec_2.Kth_Largest_Element_in_BST_3;


/*

                               5
                            /      \
                          4          8
                        /          /   \
                       2          6     10
                        \           \
                         3            7

                         k = 3

   -------------------------  Approach - 1 --------------------

            TC : O(n)

   ------>  We know that inorder traversal of BST is sorted.

            2  3  4   5  6  7  8  10

            n = 8

            Let's say we start the counter (i) by 0. i.e i = 0

            Inorder : Left Root Right

            go till i not reaches (n - k + 1)

            as kth largest element will be at (n - k + 1) in the Inorder Traversal.

            n = 8 , k = 3 so, till i != 6

            i.e when we reach at 7 return it.



 */


import java.util.Scanner;

public class kthLargestinBST {

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
    public kthLargestinBST() {

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


        if (val > root.data) {

            root.right = insertIntoBST (root.right , val);

        } else {

            root.left = insertIntoBST (root.left , val);
        }

        return root;
    }

    public int kthLargest (int k) {

        return kthLargest (this.root , k);
    }


    private int kthLargest (TreeNode root , int k) {

        int n = numOfNodesInBst (this.root);
        int ans = solve (root , k , n);

        return ans;
    }

    private int numOfNodesInBst (TreeNode root) {

        if (root == null)
            return 0;

        int left = numOfNodesInBst (root.left);
        int right = numOfNodesInBst (root.right);

        int ans = left + right + 1;
        return ans;
    }

    private int counter = 0;
    // Inorder Way main gaye.
    private int solve (TreeNode root  , int k , int n) {

        // Base Case
        if (root == null)
            return -1;

        // L
        int left = solve (root.left , k , n);

        if (left != -1) {

            return left;
        }

        // N
        counter += 1;

        if (counter == (n - k + 1)) {
            return root.data;
        }

        // R
        return solve (root.right , k , n);
    }
}

