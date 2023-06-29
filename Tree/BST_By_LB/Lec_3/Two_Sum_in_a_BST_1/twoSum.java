package Lec_3.Two_Sum_in_a_BST_1;

import java.util.ArrayList;
import java.util.Scanner;

public class twoSum {

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
    public  twoSum () {

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

    // ---------------- Approach - 2 ----------------
    public boolean isTwoSum (int target) {

        return isTwoSum (this.root , target);
    }

    private boolean isTwoSum (TreeNode nn , int target) {

        // Stores the inorder traversal of BST
        // store inorder --> sorted values
        ArrayList<Integer> inorder = new ArrayList<>();

        Inorder (nn , inorder); // SC : O(n) and TC : O(n)

        // Now applying Two pointer algo on Inorder arraylist
        int i = 0;
        int j = inorder.size() - 1;

        while (i < j) {

            int sum = inorder.get(i) + inorder.get(j);

            if (sum == target)
                return true;
            else if (sum > target)
                j -= 1;
            else
                i += 1;
        }

        return false;
    }

    private void Inorder (TreeNode nn , ArrayList<Integer> in) {

        // Base Case
        if (nn == null) {
            return;
        }

        // L
        Inorder (nn.left , in);

        // N
        in.add (nn.data);

        // R
        Inorder (nn.right , in);
    }
}
