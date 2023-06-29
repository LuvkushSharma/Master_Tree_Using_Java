package Lecture_5.Largest_BST_Subtree_3;

/*

Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the
largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:
   1. The left subtree values are less than the value of their parent (root) node's value.

   2. The right subtree values are greater than the value of their parent (root) node's value.


Note : A subtree must include all of it's descendants.

Example-1:

Input: [10,5,15,1,8,null,7]

   10
   / \
  5  15
 / \   \
1   8   7

Output: 3
Explanation: The Largest BST Subtree in this case is :

             5
           /   \
          1     8

         The return value is the subtree's size, which is 3.


Example-2:


                      1
                   /     \
                  3       3
                /   \    /  \
              2      4  2     5
                            /   \
                           4      6

           Above Tree contains two BST's

                  3
                /   \            -------------> BST-1
              2      4

                          3
                         /  \
                        2     5   --------------> BST-2
                            /   \
                           4      6


          But , size of BST-2 is more i.e. ans = 3


Example-3:

img

 */

import java.util.Scanner;

public class Largest_BST {

    Scanner sc = new Scanner(System.in);

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    private TreeNode root;

    // Constructor for tree
    public Largest_BST() {

        this.root = Create_Binary_Tree();
    }

    // --------------- Tree Creation -------------

    private TreeNode Create_Binary_Tree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode (data);

        System.out.println("Left of " + data + " ");
        boolean hasLeftNode = sc.nextBoolean();
        if (hasLeftNode == true) {

            root.left = Create_Binary_Tree();
        }

        System.out.println("Right of " + data + " ");
        boolean hasRightNode = sc.nextBoolean();
        if (hasRightNode == true) {

            root.right = Create_Binary_Tree();
        }

        return root;
    }

    // ------------------------ Largest BST Size -----------------------

    public long largestBSTSize () {

        return largestBSTSize(root).size;
    }


    private BstPair largestBSTSize (TreeNode root) {

        // Base Case
        if (root == null) {

            return new BstPair();
        }

        BstPair left_bst_pair = largestBSTSize(root.left); // Contains whether left subtree is Bst or not , min_value of left subtree and max_value.
        BstPair right_bst_pair = largestBSTSize(root.right); // Contains whether right subtree is Bst or not , min_value of right subtree and max_value.

        BstPair self_bst_pair = new BstPair();

        self_bst_pair.min = Math.min(root.val , Math.min(left_bst_pair.min , right_bst_pair.min));
        self_bst_pair.max = Math.max(root.val , Math.max(left_bst_pair.max , right_bst_pair.max));

        // Koi node BST kii property tab follow karegyi if:
        // It's left subtree is BST
        // It's right subtree is BST
        // It's data should be greater than the left subtree max and should be less than right subtree max.
        boolean isBST = left_bst_pair.isbst && right_bst_pair.isbst && (root.val > left_bst_pair.max && root.val < right_bst_pair.min);

        self_bst_pair.isbst = isBST;

        // Mera left bhi BST hain and Mera right bhi bst hain and Main khud bhi BST huun.
        if (self_bst_pair.isbst == true) {

            self_bst_pair.size = left_bst_pair.size + right_bst_pair.size + 1;

        } else { // Tum bst nhi bana rahe toh koi dikkat nhi apne left yaa fir right main se jisne bhi BST banaaya hain toh woh unka size bhej do.

            self_bst_pair.size = Math.max (left_bst_pair.size , right_bst_pair.size);
        }

        return self_bst_pair;
    }

    // Since , Min value of integer is 2^31 - 1  , and it is given in the constraint that node value can reach to this value.
    // It means if we want to initialize the min and max then we need a long variable instead of int.

    // This class contains three Information.
    class BstPair {

        boolean isbst = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        int size = 0;

    }
}
