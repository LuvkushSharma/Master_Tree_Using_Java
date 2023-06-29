package Tree_Interview_Questions_Part1_6.Sum_Tree_Or_Not_4;

import java.util.Scanner;

/*

Given a Binary Tree. Return true if, for every node X in the tree other than the
leaves, its value is equal to the sum of its left subtree's value and its right
subtree's value. Else return false.

An empty tree is also a Sum Tree as the sum of an empty tree can be considered to
be 0. A leaf node is also considered a Sum Tree.


Example 1:

Input:
    3
  /   \
 1     2

Output: 1
Explanation:
The sum of left subtree and right subtree is
1 + 2 = 3, which is the value of the root node.
Therefore,the given binary tree is a sum tree.

Example 2:

Input:

          10
        /    \
      20      30
    /   \
   10    10

Output: 0
Explanation:
The given tree is not a sum tree.
For the root node, sum of elements
in left subtree is 40 and sum of elements
in right subtree is 30. Root element = 10
which is not equal to 30+40.

Your Task:
You don't need to read input or print anything. Complete the function isSumTree() which takes root node as input parameter and returns true if the tree is a SumTree else it returns false.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the Tree)


Constraints:
1 ≤ number of nodes ≤ 104

 */

public class Sum_Tree {

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
    public Sum_Tree() {

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

    public boolean isSumTree () {

        return isSumTree (root);
    }

    private Pair solve (TreeNode root) {

        // Base Case
        if (root == null) {

            // <true , 0>
            return new Pair();
        }

        // According to question : Donot check Sum tree for leaf nodes
        // Leaf Node Case.
        if (root.left == null && root.right == null) {

            Pair result = new Pair();

            result.isBelowSumTree = true;
            result.sum = root.val;

            return result;
        }

        Pair Left = solve (root.left);
        Pair Right = solve (root.right);

        boolean leftans = Left.isBelowSumTree;
        boolean rightans = Right.isBelowSumTree;

        // Check current Node sumTree
        int leftSum = Left.sum;
        int rightSum = Right.sum;

        int total_sum = leftSum + rightSum;
        boolean condn = false;

        if (root.val == (total_sum)) {
            condn = true;
        }

        // This pair we have to return.
        Pair ans = new Pair();

        // If these three conditions are true
        if (leftans && rightans && condn) {

            ans.isBelowSumTree = true;

        } else {

            ans.isBelowSumTree = false;
        }

        ans.sum = total_sum + root.val;

        return ans;
    }

    private boolean isSumTree (TreeNode root) {

        Pair ans = solve (root);

        return ans.isBelowSumTree;
    }

    class Pair {

        boolean isBelowSumTree = true;
        int sum = 0;
    }

}
