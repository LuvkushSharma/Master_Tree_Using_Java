package Lec_1.BST_Creation_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {

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
    public BST () {

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

    public void LevelOrderTraversal () {

        LevelOrderTraversal(root);
    }

    private void LevelOrderTraversal (TreeNode root){

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        q.add(null); // As a separator for levels

        while (!q.isEmpty()) {

            TreeNode temp = q.peek();
            q.remove();

            // This if used for printing each level on the separate line
            // Matlab puuraana level completely traversed ho chuuka hain.
            if (temp == null) { // old level completely traversed

                System.out.println();

                if (!q.isEmpty()) { // queue still have some child nodes
                    q.add(null);
                }

            } else {

                // This the code for the level Order Traversal.
                System.out.print (temp.data + " ");

                if (temp.left != null)
                { // If left child is not NULL
                    q.add(temp.left);
                }

                if (temp.right != null)
                {
                    q.add(temp.right);
                }
            }
        }
    }

}
