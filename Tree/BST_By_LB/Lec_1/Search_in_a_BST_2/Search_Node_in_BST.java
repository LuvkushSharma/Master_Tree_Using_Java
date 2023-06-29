package Lec_1.Search_in_a_BST_2;

import java.util.Scanner;

public class Search_Node_in_BST {

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
    public Search_Node_in_BST () {

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

    // --------------------- Searching Code ---------------------

    public boolean Search (int x) {

        // return Search (this.root , x);
        return Iterative_Search(this.root , x);
    }

    // TC : O(logn)
    // But in case of skew tree : TC : O(n)
    // SC : O(H) where H is height.
    private boolean Search (TreeNode root , int x) {

        // Base Case
        // nhi find kar paaye
        if (root == null)
            return false;

        // val founded
        if (root.data == x) {

            return true;
        }

        if (root.data > x) {

            // left part main search karo
            return Search (root.left , x);

        } else {

            // Right part main search karo
            return Search (root.right , x);
        }
    }

    // TC : O(n)
    // SC : O(1)
    private boolean Iterative_Search (TreeNode root , int x) {

        TreeNode temp = root;

        while (temp != null) {

            if (temp.data == x) {

                return true;
            }

            if (temp.data > x) {

                temp = temp.left;

            } else {

                temp = temp.right;
            }
        }

        return false;
    }
}
