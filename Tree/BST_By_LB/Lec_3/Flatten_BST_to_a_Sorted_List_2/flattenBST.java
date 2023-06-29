package Lec_3.Flatten_BST_to_a_Sorted_List_2;

import java.util.ArrayList;
import java.util.Scanner;

public class flattenBST {

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
    public  flattenBST () {

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

    private void Inorder (TreeNode nn , ArrayList<Integer> in) {

        // Base Case
        if (nn == null) {
            return;
        }

        Inorder (nn.left , in);
        in.add (nn.data);
        Inorder (nn.right , in);
    }

    public void flattenBSTintoSorList () {

        TreeNode head = flattenBSTintoSorList (this.root);

        display (head);
    }

    private TreeNode flattenBSTintoSorList (TreeNode nn) {

        // Stores the inorder traversal of BST
        // store inorder --> sorted values
        ArrayList<Integer> inorder = new ArrayList<>();

        // 1st step
        Inorder (nn , inorder);

        TreeNode newRoot = new TreeNode(inorder.get (0));

        TreeNode curr = newRoot;

        // 2nd step
        for (int i = 1 ; i < inorder.size() ; i++) {

            TreeNode temp = new TreeNode(inorder.get (i));

            curr.left = null;
            curr.right = temp;

            curr = temp;
        }

        // 3rd step
        curr.left = null;
        curr.right = null;

        return newRoot;

    }

    // ----------------- Displaying LinkedLists ----------------
    private void display (TreeNode head) {

        while (head != null) {

            System.out.print (head.data + "--->");
            head = head.right;
        }

        System.out.print ("null");
    }

}
