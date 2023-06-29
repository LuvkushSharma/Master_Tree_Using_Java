package Tree_Interview_Questions_Part2_7.LowestCommonAncestor_2;

import java.util.Scanner;

/*

----------- What is LCA ---------

The lowest common ancestor is the lowest node in the tree that has both n1 and n2
as descendants, where n1 and n2 are the nodes for which we wish to find the LCA.
Hence, the LCA of a binary tree with nodes n1 and n2 is the shared ancestor of n1
and n2 that is located farthest from the root.

Given a Binary Tree with all unique values and two nodes value, n1 and n2. The
task is to find the lowest common ancestor of the given two nodes. We may assume
that either both n1 and n2 are present in the tree or none of them are present.

LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of
tree.

Example 1:

Input:
n1 = 2 , n2 = 3
       1
      / \
     2   3
Output: 1
Explanation:
LCA of 2 and 3 is 1.
Example 2:

Input:
n1 = 3 , n2 = 4
           5
          /
         2
        / \
       3   4
Output: 2
Explanation:
LCA of 3 and 4 is 2.
Your Task:
You don't have to read, input, or print anything. Your task is to complete the
function lca() that takes nodes, n1, and n2 as parameters and returns the LCA node
as output.

Expected Time Complexity:O(N).
Expected Auxiliary Space:O(Height of Tree).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105

 */

/*

                                5
                            /      \
                           4        3
                         /   \    /   \
                        7     8  22    27
                            /   \     /
                           12   9    29


                  Let's say n1 = 8   and n2 = 27
                  Find their lowest Common Ancestor.


           4 , 5 are the ancestors of 8
           3 , 5 are the ancestors of 27

           But among them we need to take the lowest Common ancestor of both n1 and n2.
           and i.e 5


  ------------------------- Approach --------------------------

  Approach-1 : Find the path from root to n1 and root to n2.

  So, if we take above example as a reference then ,
  Path1 = 5 4 8
  Path2 = 5 3 27

  Now , start from the last of both the paths.


  Approach-2 :





 */

public class LCA {

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
    public LCA () {

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

    public int Lowest_Common_Ancestor(int n1 , int n2) {

        TreeNode ans =  Lowest_Common_Ancestor(root , n1 , n2);

        return ans.val;
    }

    private TreeNode Lowest_Common_Ancestor(TreeNode root , int n1 , int n2) {

          // Base Case
        if (root == null) {
            return null;
        }

        if (root.val == n1 || root.val == n2) {

            return root;
        }

        TreeNode leftAns = Lowest_Common_Ancestor (root.left , n1 , n2);
        TreeNode rightAns = Lowest_Common_Ancestor (root.right , n1 , n2);

        if (leftAns != null && rightAns != null) {

            return root;

        } else if (leftAns != null && rightAns == null) {

            return leftAns;

        } else if (leftAns == null && rightAns != null){

            return rightAns;

        } else {

            return null;
        }
    }

}
