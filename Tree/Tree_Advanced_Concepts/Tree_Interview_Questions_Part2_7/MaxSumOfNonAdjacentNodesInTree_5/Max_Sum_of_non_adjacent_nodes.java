package Tree_Interview_Questions_Part2_7.MaxSumOfNonAdjacentNodesInTree_5;

import java.util.Scanner;

/*

Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents in consideration and vice versa.



Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.

Example 2:

Input:
        1
      /   \
     2     3
    /     /  \
   4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e. 16. These nodes are
non-adjacent.

Your Task:
You don't need to read input or print anything. You just have to complete function getMaxSum() which accepts root node of the tree as parameter and returns the maximum sum as described.

Expected Time Complexity: O(Number of nodes in the tree).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes in the tree ≤ 10000
1 ≤ Value of each node ≤ 100000


 */

public class Max_Sum_of_non_adjacent_nodes {

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
    public  Max_Sum_of_non_adjacent_nodes () {

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

    public int MaxSumNonAdjacent () {

        return MaxSumNonAdjacent (root);
    }

    private Pair solve (TreeNode root) {

        // Base Case
        if (root == null) {

            // i.e <0,0>
            return new Pair();
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        Pair result = new Pair();

        // Maximum including all nodes at current level
        result.a = root.val + left.b + right.b;

        // Excluding
        result.b = Math.max (left.a , left.b) + Math.max(right.a , right.b);

        return result;

    }

    private int MaxSumNonAdjacent (TreeNode root) {

        Pair ans = solve (root);
        return Math.max(ans.a , ans.b);
    }

    class Pair {

        int a = 0;
        int b = 0;
    }
}
