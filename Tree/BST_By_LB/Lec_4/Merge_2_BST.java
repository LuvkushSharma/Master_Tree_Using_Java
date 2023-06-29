package Lec_4;

/*

You are given two balanced binary search trees of
integers having ‘N’ and ‘M’ nodes. You have to merge the two BSTs into a balanced binary search tree and return the root node to that balanced BST.

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Merge_2_BST {

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
    public Merge_2_BST () {

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

    public void MergeBST (Merge_2_BST tree2) {

          // Since we had accessed this function using tree1 so, we can directly use the root for this.
          TreeNode root1 = this.root;

          // Accessing the root of tree2 by it's object. But in the class as it was private. So, we can only access root in the class.
          TreeNode root2 = tree2.root;

          MergeBST (root1 , root2);
    }

    // -------------------------- Merge Two Bst's -----------------------

    // -------------------- Step-1 -------------------
    private void Inorder (TreeNode nn , ArrayList<Integer> in) {

        // Base Case
        if (nn == null)
            return;

        // L : Left
        Inorder (nn.left , in);

        // N : Root
        in. add(nn.data);

        // R : Right
        Inorder (nn.right , in);

    }

    // ------------------ Step-2 --------------------
    private ArrayList<Integer> mergeSortedArrays (ArrayList<Integer> a , ArrayList<Integer> b) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0; // -----> It will point to the array : a
        int j = 0; // -----> It will point to the array : b

        while (i < a.size() && j < b.size()) {

            if (a.get (i) < b.get (j)) {

                int val = a.get (i);
                ans.get (val);

                i += 1;
            } else {

                int val = b.get (j);
                ans.get (val);

                j += 1;

            }
        }

        // If 'a' is remaining
        while (i < a.size()) {
            int val = a.get (i);
            ans.get (val);

            i += 1;
        }

        // If 'b' is remaining
        while (j < b.size()) {
            int val = b.get (j);
            ans.get (val);

            j += 1;
        }

        return ans;
    }

    // ------------------ Step-3 ----------------
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

    // ------------ Main Function --------------
    private TreeNode MergeBST (TreeNode root1 , TreeNode root2) {

          // Step-1 : Store Inorder
        ArrayList<Integer> bst1 = new ArrayList<>();
        ArrayList<Integer> bst2 = new ArrayList<>();

        Inorder (root1 , bst1); // TC : O(m) and SC : O(m)
        Inorder (root2 , bst2);  // TC : O(n) and SC : O(n)

        // Step-2 : Merge Two Sorted Arrays
        ArrayList<Integer> mergedArray = mergeSortedArrays (bst1 , bst2);

        // Step-3 :
        int n = mergedArray.size();
        TreeNode newRoot = inorderToBST (0 , n-1 , mergedArray); // TC : O(m + n) and SC : O(m + n)

        return newRoot;
    }
}
