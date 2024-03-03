package Tree_Interview_Questions_Part2_7.sumOfLongRootToLeafPath_1;

/*

--------------- Sum of the longest Bloodline of the tree ----------------

Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of
all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input:
        4
       / \
      2   5
     / \ / \
    7  1 2  3
      /
     6
Output: 13
Explanation:
        4
       / \
      2   5
     / \ / \
    7  1 2  3
      /
     6

The highlighted nodes (4, 2, 1, 6) above are
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13

Example 2:

Input:
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
Output: 11
Your Task:
You don't need to read input or print anything. Your task is to complete the function sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and returns an integer denoting the sum of the longest root to leaf path of the tree. If the tree is empty, return 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 104



 */

/*

----------------- Intuition --------------------

DS ----> pair <Sum , No. of nodes / Length of path>

ans = <0 , 0>

-------> Taking first  path i.e 4 2 7

at 4 : sum = 4 and length = 1
       i.e <4 , 1>

at 2 : sum = 4 + 2 and length = 1 + 1
       i.e <6 , 2>

at 7 : sum = 6 + 7 and length = 2 + 1
       i.e <13 , 3>

Update the ans :

if (sum.length >= ans.length) {

     // ans.first is nothing but the sum.
     ans.first = max (sum.first . ans.first);
     ans.length = sum.length

}

so, ans.first = 13 and ans.length = 3

-------> Taking Second  path i.e 4 2 1 6

at 4 : sum = 4 and length = 1
       i.e <4 , 1>

at 2 : sum = 4 + 2 and length = 1 + 1
       i.e <6 , 2>

at 1 : sum = 6 + 1 and length = 2 + 1
       i.e <7 , 3>

at 6 : sum = 7 + 6 and length = 3 + 1
       i.e <13 , 4>

if (sum.length >= ans.length) {

     // ans.first is nothing but the sum.
     ans.first = max (sum.first . ans.first);
     ans.length = sum.length

}

so, ans.first = 13 and ans.length = 4

Similarly , we will go to : 4 5 2 and 4 5 3

 */

import java.util.Scanner;

public class sumOfTheLongestBloodlineOfTree {

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
    public  sumOfTheLongestBloodlineOfTree() {

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

    private int maxLen = 0;
    private int maxSum = Integer.MIN_VALUE;

    public int LongestPathSum () {

        LongestPathSum(root);

        return maxSum;
    }



    private void LongestPathSum (TreeNode root) {

        int len = 0;
        int maxLen = 0;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        solve (root , sum , len);

    }

    private void solve (TreeNode root , int sum , int len) {

        if (root == null) {

            if (len > maxLen) {

                maxSum = sum;
                maxLen = len;

            } else if (len == maxLen) {

                maxSum = Math.max (sum , maxSum);
            }

            return;
        }

        sum = sum + root.val;

        solve (root.left , sum , len + 1);
        solve (root.right , sum , len + 1);
    }


}
