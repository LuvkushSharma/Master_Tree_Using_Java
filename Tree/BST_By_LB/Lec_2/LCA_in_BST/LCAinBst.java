package Lec_2.LCA_in_BST;

/*

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.


 */


/*

                                4
                             /     \
                            2       5
                          /   \
                         1     3

                    p = 2   ,   q = 5


   ----------------------- Approach -------------------

   Case - 1:  root.data < p && root.data < b

              so, LCA in right subtree of root node.

   Case - 2 : root.data > p && root.data > b

              so, LCA in left subtree of the root node.

   Case - 3 : root.data > a && root.data < b

              LCA is root.data


   Case - 4 : root.data < a && root.data > b

              LCA is root.data

 */

import java.util.Scanner;

public class LCAinBst {

    Scanner sc = new Scanner(System.in);

    // Node class for BST
    class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        // Constructors
        public TreeNode () {

        }

        public TreeNode (int val) {
            this.data = val;
        }
    }

    private TreeNode root;

    // Constructor for BST
    public  LCAinBst () {

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

    public int LCA (int p , int q) {

        // TreeNode ans =  LCA (this.root , p , q);
        TreeNode ans =  LCA_2 (this.root , p , q);

        return ans.data;
    }

    // M-1 : SC : O(n)
    /*

    private TreeNode LCA (TreeNode root , int p , int q) {

        // Base Case
        if (root == null)
            return null;

        // Case - 1
        if (root.data < p && root.data < q) {

            return LCA (root.right , p , q);
        }

        if (root.data > p && root.data > q) {

            return LCA (root.right , p , q);
        }

        // Case-3 and 4
        return root;
    }

     */

    // SC : O(1)
    private TreeNode LCA_2 (TreeNode root , int p , int q) {

        // Base Case
        if (root == null)
            return null;


        while (root != null) {

            if (root.data < p && root.data < q) {

                root = root.right;

            } else if (root.data > p && root.data > q) {

                root = root.left;

            } else { // Case-3 and 4

                break;
            }
        }

        return root;
    }
}
