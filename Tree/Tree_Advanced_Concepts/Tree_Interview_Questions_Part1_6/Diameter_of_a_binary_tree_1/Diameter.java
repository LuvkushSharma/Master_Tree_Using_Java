package Tree_Interview_Questions_Part1_6.Diameter_of_a_binary_tree_1;

import java.util.Scanner;

/*

The diameter of a tree (sometimes called the width) is the number of nodes on the
longest path between two end nodes. The diagram below shows two trees each with
diameter nine, the leaves that form the ends of the longest path are shaded
(note that there is more than one path in each tree of length nine, but no path
longer than nine nodes).

img

Example 1:

Input:
       1
     /  \
    2    3
Output: 3

Example 2:

Input:
         10
        /   \
      20    30
    /   \
   40   60
Output: 4
Your Task:
You need to complete the function diameter() that takes root as parameter and
returns the diameter.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000



 */

public class Diameter {

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
    public Diameter () {

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

    public int getDiameter () {

        return getDiameter(root);
    }
    private int getDiameter (TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        int op1 = getDiameter(root.left);
        int op2 = getDiameter(root.right);
        int op3 = height(root.left) + 1 + height(root.right);

        System.out.println("Root : " + root.val);
        System.out.println("Opt_1 : " + op1);
        System.out.println("Opt_2 : " + op2);
        System.out.println("Opt_3 : " + op3);

        System.out.println();

        int ans = Math.max (Math.max (op1 , op2) , op3);

        return ans;
    }

    // Assuming single node height as 1
    private int height (TreeNode root) {

        // Base Case
        if (root == null) {
            return 0;
        }

        int left = height (root.left);
        int right = height (root.right);

        int ans = Math.max (left , right) + 1;
        return ans ;
    }

}
