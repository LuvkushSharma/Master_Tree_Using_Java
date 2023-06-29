package Lec_3.Normal_BST_To_Balanced_BST_3;

import java.util.ArrayList;
import java.util.Scanner;

public class normalToBalanced {

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
    public  normalToBalanced () {

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

    // --------------- Inorder ----------------
    private void Inorder (TreeNode nn , ArrayList<Integer> in) {

        // Base Case
        if (nn == null) {
            return;
        }

        Inorder (nn.left , in);
        in.add (nn.data);
        Inorder (nn.right , in);
    }

    // ------------ Normal To Balanced BST -------------
    public void balancedBST () {

        TreeNode newRoot = balancedBST (this.root);
    }

    TreeNode inorderToBST (int start , int end , ArrayList<Integer> inorderVal) {

        // Base Case
        if (start > end){
            return null;
        }

        // Step-2
        int mid = (start + end)/2;

        int val = inorderVal.get(mid);
        TreeNode newRoot = new TreeNode(val);

        // Step-3
        newRoot.left = inorderToBST (start , mid-1 , inorderVal); // Left Portion Creation
        newRoot.right = inorderToBST (mid+1 , end , inorderVal); // Right Portion Creation

        return newRoot;
    }

    private TreeNode balancedBST (TreeNode nn) {

        // Stores the inorder traversal of BST
        // store inorder --> sorted values
        ArrayList<Integer> inorder = new ArrayList<>();

        // Step-1
        Inorder (nn , inorder);

        return inorderToBST (0 , inorder.size()-1 , inorder);

    }
}
