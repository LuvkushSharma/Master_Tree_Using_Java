package Tree_Traversals_1.BoundaryTraversal_3;

import java.util.ArrayList;
import java.util.Scanner;

/*

-------------------------- Approach ----------------------------


 We divide this problem in three parts :-

 Print the root node then do the following things :-

 First we will print the left part of the tree where leaf node is exclusive i.e
 1 and 2

 Secondly we will print the leaf nodes only i.e
 3 6 8 10 11

 Lastly we will print the right part of the tree exclusive of the leaf node.

 And print the right part in the reverse order.


*/

public class Boundary_Traversal {

    Scanner sc = new Scanner(System.in);

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // Constructor of the Binary Tree
    public Boundary_Traversal () {

        this.root = Create_Binary_Tree ();
    }

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


    // We will traverse the left part of the tree here
    private void LeftTraverse(TreeNode root , ArrayList<Integer> ans){

            // Base Case
            if(root == null){
                return;
            }

            // In case of leaf node stop.
            if(root.left == null && root.right == null){
                return;
            }

            // root kii value daalte jaao and left main call lagaate jaao.
            ans.add(root.val);

            if(root.left != null){

                LeftTraverse(root.left, ans);

            }else{
                // When left part is NULL so right part will act as a boundary.
                /*
                     1
                    /
                   3
                  /
                 2
                  \
                   5 ---> In this case 5 will act as a boundary.

                 */
                LeftTraverse(root.right, ans);
            }

    }

    // We know that in case of Inorder traversal we are moving from left to right.
    // i.e traverse using Inorder Traversal and store
    private void LeafNodeTraverse(TreeNode root, ArrayList<Integer> ans){

            // Base Case - 1
            if(root == null){
                return;
            }

            // Base case - 2
            if(root.left == null && root.right == null){

                ans.add(root.val);
                return;
            }

            LeafNodeTraverse(root.left , ans);
            LeafNodeTraverse(root.right, ans);

    }


    private void RightTraverse(TreeNode root, ArrayList<Integer> ans){

            if(root == null){
                return;
            }

            // Do not count the leaf nodes as we had already counted them
            if(root.left == null && root.right == null){
                return;
            }

            // If right exists
            if(root.right != null){
                RightTraverse(root.right, ans);

            } else{
                RightTraverse(root.left, ans);

            }

            // Pehle right kaa call lagaate chalo and jaise hee leaf node par aa jaao
            // waise hee return hote samay ans main data store karte chalo i.e
            // reverse order main right part store ho jaayega.
            ans.add(root.val);

    }

    public ArrayList<Integer> BoundaryTraverse () {

        return BoundaryTraverse(root);
    }

    // As user have no access to the root node i.e we will make a public function.
    // From where we will pass the root node and that function will be called by the user.
    // make sure to make the below function as private.
    private ArrayList<Integer> BoundaryTraverse(TreeNode root){

            ArrayList<Integer> ans = new ArrayList<>();

            // Base Case
            // If no root node is their
            if(root == null){
                return ans;
            }

            // Firstly Putting root -> data in the ans
            ans.add(root.val);

            // Left part store if exits else store right part means : Here No left part of A but right part of A is present
            //  and B is also the boundary of the tree.                   //             X
                                                                         //            /
            LeftTraverse(root.left, ans);                                //           A
                                                                         //            \
            // In case of leaf node                                      //             B
                                                                          //            /
            // Left subtree leafs                                         //           C
            LeafNodeTraverse(root.left, ans);

            // Right subtree leafs
            LeafNodeTraverse(root.right, ans);

            // Traversing right part of the tree
            RightTraverse(root.right, ans);

            return ans;

    }

}




