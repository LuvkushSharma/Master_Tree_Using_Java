package Lec_2.Predecessor_and_Successor_in_BST_4;

/*

You have been given a binary search tree of integers with ‘N’ nodes. You are also given 'KEY' which represents data of a node of this tree. Your task is to find the predecessor and successor of the given node in the BST.

Note:
1. The predecessor of a node in BST is that node that will be visited just before the given node in the inorder traversal of the tree. If the given node is visited first in the inorder traversal, then its predecessor is NULL.

2. The successor of a node in BST is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its successor is NULL.

3. The node for which predecessor and successor are to be found will always be present in the given tree.

4. A binary search tree (BST) is a binary tree data structure which has the following properties.
     • The left subtree of a node contains only nodes with data less than the node’s data.
     • The right subtree of a node contains only nodes with data greater than the node’s data.
     • Both the left and right subtrees must also be binary search trees.

Summary :
In an inorder traversal the number just smaller than the target is the predecessor
and the number just greater than the target is the successor.

If either predecessor or successor is not found, then set it to NULL.


Example -1 :
Input:
        10
      /   \
     2    11
   /  \
  1    5
      /  \
     3    6
      \
       4
key = 8
Output:
6 10
Explanation:
In the given BST the inorder predecessor of 8 is 6 and inorder successor of 8 is 10.

Example - 2 :
Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
key = 11
Output:
10 -1
Explanation:
In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 104
1 <= key of node <= 107
1 <= key <= 107

 */

/*

--------------------- Approach - 1 --------------------

        10
      /   \
     2    11
   /  \             Key = 8
  1    5
      /  \
     3    6
      \
       4

Step-1 : Find the Inorder traversal of the given tree.
         1  2  3  4  5  6  10  11

Step-2 : Search for the key in BST which takes O(logn) time

Step-3 :  So, key just less than 8 is 6 and Key just greater than 8 is 10

          ans = 6 10


--------------------- Approach - 2 -----------------

                          4
                        /   \
                       2     5           Key = 2
                     /   \
                    1     3

Step - 1 : Search Key i.e 2

Step - 2 : Predecessor is just smaller key.
           i.e. agar main 2 ke left main jaunga tabhi samller key milegyi and just samller chaiye it means sabse badi honi chaiye in the left subtree.
           i.e. Go to left and then go to right till we donot get null

Step - 3 : Successor is just greater key.
           i.e. greater hain toh 2 ke right maain honi chaiye i.e call 2.right.
           as , just badi honi chaiye i.e go to left till we donot get null.




 */


import java.util.Scanner;

public class predAndSucc {

    Scanner sc = new Scanner(System.in);

    // Creating nodes for the tree using this class
    public class TreeNode{

        int data;

        // These will be initialised as null
        TreeNode left;
        TreeNode right;

        public TreeNode (){

        }

        public TreeNode (int val) {
            this.data = val;
        }

    }

    private TreeNode root;

    // Constructor for BST
    public predAndSucc() {

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


    // --------------------- Predecessor and Successor -------------------

    TreeNode pre = new TreeNode();
    TreeNode suc = new TreeNode();

    public void findPredSuc (int key) {

        findPredSuc (this.root , key);

        if (pre != null)
            System.out.println("Predecessor is " + pre.data);
        else
            System.out.println(-1);

        if (suc != null)
            System.out.println("Successor is " + suc.data);
        else
            System.out.println(-1);
    }

    private void findPredSuc (TreeNode nn, int key) {

        // Base case
        if (nn == null)
            return;

        // If key is present at root
        // Iske andarr puura predecessor and successor find karne kaa code likhna hain.
        if (nn.data == key)
        {

            // The maximum value in left
            // subtree is predecessor
            if (nn.left != null)
            {
                TreeNode tmp = nn.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp;
            }

            // The minimum value in
            // right subtree is successor
            if (nn.right != null)
            {
                TreeNode tmp = nn.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp;
            }
            return;
        }

        // since temp is greater than key then it may be a successor (having key just greater than given key).
        if (nn.data > key)
        {
            suc = nn;
            findPredSuc(nn.left, key);
        }

        // since temp is lesser than key then it may be a predecessor.
        else
        {
            pre = nn;
            findPredSuc(nn.right, key);
        }
    }


}
