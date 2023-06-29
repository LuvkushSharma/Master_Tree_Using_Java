package Lecture_5.Construct_Binary_Tree_From_Preorder_and_Inorder_Traversal_1;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder
traversal of the same tree, construct and return the binary tree.

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]


Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

*/

/*

---------------------------- Approach -------------------------------------------

Preorder --> Root Left Right

So, we'll take Root from Preorder and Child from Inorder

Inorder --> Left Root Right

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

i.e If 3 is the root then it's left subtree is 9 (left of 3 is 9 from Inorder) and right subtree will be [15,20,7]

         3
       /
      9

Now , 9 will be the root from Preorder but after seeing the inorder we get to know that 9 has no left and right child.

Now , 20 will be the root. and 15 is the left child of 20 and right child is 7.

         3
       /   \
      9     20

Now , 15 will be the root from Preorder having no further child.        .

             3
           /   \
          9     20
               /
              15

Now , 7 will be the root having no further child.

             3
           /   \
          9     20
               /   \
              15    7


  i.e. for finding the root node we'll use Preorder and for it's child we will see the Inorder.


Note : We will always get the unique tree at the end.


Ex-2 :
       Preorder : [10 , 12 , 3 , 4 , 6 , 7 , 5 , 11 , 2 , 8] ------------> Use it to see the root node.

       Inorder : [3, 12 , 6 , 4 , 7 , 10 , 11 , 5 , 2 , 8] ------------> Use it to see the Child nodes.


   Step-1 : 10 will be our root node (after seeing the preorder) and it's left-subtree is [3, 12 , 6 , 4 , 7] and Right subtree is
           [11 , 5 , 2 , 8]

                                  10
                                /    \
                [3, 12 , 6 , 4 , 7]  [11 , 5 , 2 , 8]



     Step-2 : 12 will be the root node , and it's left subtree is [3] whereas right subtree has [6,4,7].

                                  10
                                /    \
                               12    [11 , 5 , 2 , 8]
                             /    \
                            [3]   [6,4,7]

     Step-3 : Now , 3 will be the root node , and it has no left child and right child.

                                  10
                                /    \
                               12    [11 , 5 , 2 , 8]
                             /    \
                            3    [6,4,7]


     Step-4 : Now , 4 will be the root node , and it's left subtree is [6] whereas right subtree is [7]

                                  10
                                /    \
                               12    [11 , 5 , 2 , 8]
                             /    \
                            3      4
                                 /   \
                                [6]  [7]

     Step-5 : Now , 6 will be the root node ,  and it has no left child and right child. Same with 7

                                  10
                                /    \
                               12    [11 , 5 , 2 , 8]
                             /    \
                            3      4
                                 /   \
                                6     7


    Step-6 : Now , 5 will be the root node ,  and it has left subtree as [11] whereas right subtree is [2 , 8]

                                   10
                                /     \
                               12       5
                             /    \    /  \
                            3      4  [11] [2 , 8]
                                 /   \
                                6     7

    Step-7 : Now , 11 will be the root node ,  and it has no left subtree  whereas right subtree is [2 , 8]

                                   10
                                /     \
                               12       5
                             /    \    /  \
                            3      4  11  [2,8]
                                 /   \
                                6     7


    Step-8 : Now , 2 will be the root node ,  and it has no left subtree  whereas right subtree is [8]

                                   10
                                /     \
                               12       5
                             /    \    /  \
                            3      4  11   2
                                 /   \       \
                                6     7      [8]

    Step-9 : Now , 8 will be the root node , and it has no left subtree  and right subtree.

                                   10
                                /     \
                               12       5
                             /    \    /  \
                            3      4  11   2
                                 /   \       \
                                6     7       8


 */


import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_From_Preorder_and_Inorder {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }

  }

  private TreeNode root;

  public void buildTree (int preorder[] , int inorder[]) {

        this.root = CreateTree(preorder , inorder , 0 , inorder.length-1 , 0 , preorder.length-1);

  }

  private TreeNode CreateTree (int pre[] , int in[] , int in_low , int in_height , int p_low , int p_height) {

        if (in_low > in_height || p_low > p_height) {
            return null;
        }

        // Taking root node from the Preorder.
        TreeNode node = new TreeNode(pre[p_low]);

        // Search the root node in the inorder array
        int idx = Search(in , in_low , in_height , pre[p_low]);

        int net_element = idx - in_low; // Total elements in the left of the root node.

        // left subtree of pre[p_low] i.e. root node
        node.left = CreateTree(pre , in , in_low , idx - 1 , p_low + 1 , p_low + net_element);

        // right subtree : jaha par left khatam hua hain uske aagye kaa right banega.
        node.right = CreateTree(pre , in , idx + 1 , in_height , p_low + net_element + 1 , p_height);

        return node;

  }

  private int Search (int inorder[] , int start , int end , int item) {

        for (int i = start ; i <= end ; i++) {

            if (inorder[i] == item) {
                return i;
            }
        }

        return 0;
  }

  //-------------------------- Tree Displaying ----------------------------

    public void display () {

        display(root);
    }

    private void display (TreeNode root){

        // We do this using BFS (Breadth first search) where we use queue data structure.
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root); // Inserting root node in the queue

        // For printing different level data on different line we will push NULL which shows that
        // now, we want the new line.
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
                System.out.print (temp.val + " ");

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
