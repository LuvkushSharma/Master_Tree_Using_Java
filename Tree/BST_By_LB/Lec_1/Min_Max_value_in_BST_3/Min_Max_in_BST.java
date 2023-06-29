package Lec_1.Min_Max_value_in_BST_3;

import java.util.Scanner;

public class Min_Max_in_BST {

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
    public Min_Max_in_BST () {

        Create_BST ();
    }

    // -------------------- BST Creation Code -----------------------

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

    // ------------------- Min and Max node value ----------------

    // -------> Max
    public int Max () {

        return Max (this.root);
    }

    private int Max (TreeNode root) {

        TreeNode temp = root;

        // Go to the right most node in the BST
        while (temp.right != null) {

            temp = temp.right;
        }

        return temp.data;
    }

    // --------> Min
    public int Min () {

        return Min (this.root);
    }

    private int Min (TreeNode root) {

        TreeNode temp = root;

        // Go to the left most node in the BST
        while (temp.left != null) {

            temp = temp.left;
        }

        return temp.data;
    }
}
