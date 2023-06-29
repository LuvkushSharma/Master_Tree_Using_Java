package Tree_Interview_Questions_Part1_6.Determine_Two_Trees_Identical_Or_Not_3;

import java.util.Scanner;

/*

Given two binary trees, the task is to find if both of them are identical or not.


Example 2:

Input:
     1          1
   /   \      /   \
  2     3    2     3
Output: Yes
Explanation: There are two trees both
having 3 nodes and 2 edges, both trees
are identical having the root as 1,
left child of 1 is 2 and right child
of 1 is 3.

Example 2:

Input:
    1       1
  /  \     /  \
 2    3   3    2
Output: No
Explanation: There are two trees both
having 3 nodes and 2 edges, but both
trees are not identical.

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function isIdentical() that takes two roots as parameters and returns true or false. The printing is done by the driver code.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).


Constraints:
1 <= Number of nodes <= 105
1 <=Data of a node <= 105




 */

public class Identical {

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
    public Identical () {

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

    public boolean isIdentical (Identical tree2) {

        TreeNode root1 = this.root;
        TreeNode root2 = tree2.root;
        return isIdentical(root1 , root2);
    }

    private boolean isIdentical (TreeNode r1 , TreeNode r2) {

        // Base Case - 1
        if (r1 == null && r2 == null) {
            return true;
        }

        // Base Case - 2
        if (r1 == null && r2 != null) {
            return false;
        }

        // Base Case - 3
        if (r1 != null && r2 == null) {
            return false;
        }

        // Abb ham yaha tabhi pahochengye when both r1 and r2 are non-null
        boolean leftans = isIdentical (r1.left , r2.left);
        boolean rightans = isIdentical (r1.right , r2.right);

        boolean value = false;
        if (r1.val == r2.val)
            value = true;

        if (leftans && rightans && value) {
            return true;
        }

        return false;
    }

}
