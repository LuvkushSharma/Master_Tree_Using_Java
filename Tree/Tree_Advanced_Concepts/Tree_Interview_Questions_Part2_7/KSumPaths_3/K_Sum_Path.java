package Tree_Interview_Questions_Part2_7.KSumPaths_3;

import java.util.ArrayList;
import java.util.Scanner;

/*

Given a binary tree and an integer K. Find the number of paths in the tree which
have their sum equal to K.
A path may start from any node and end at any node in the downward direction.


Example 1:

Input:
Tree =
          1
        /   \
       2     3
K = 3
Output: 2
Explanation:
Path 1 : 1 + 2 = 3
Path 2 : only leaf node 3

Example 2:

Input:
Tree =
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5
        /   / \     \
       1   1   2     6
K = 5
Output: 8
Explanation:
The following paths sum to K.
3 2
3 1 1
1 3 1
4 1
1 -1 4 1
-1 4 2
5
1 -1 5

Your Task:
You don't need to read input or print anything. Complete the function sumK() which takes root node and integer K as input parameters and returns the number of paths that have sum K. Since the answer may be very large, compute it modulo 109+7.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 105
-105 ≤ Node Value ≤ 105
-109 ≤ k ≤ 109


 */

public class K_Sum_Path {

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
    public K_Sum_Path () {

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

    private int count = 0;

    public int KSumPath (int k) {

        return KSumPath(root , k);
    }

    private void solve (TreeNode root , int k , ArrayList<Integer> path) {

        // Base Case
        if (root == null)
            return;

        path.add (root.val);

        // left call
        solve (root.left , k , path);

        // right call
        solve (root.right , k , path);

        // Check for k sum
        int size = path.size();
        int sum = 0;
        for (int i = size-1 ; i >= 0 ; i--) {

            sum += path.get(i);

            if (sum == k)
                count += 1;
        }

        // Backtrack
        path.remove(size - 1); // removing currently added element from the arraylist so, that when we move to upper nodes then in their function frame this value will not be visible.

    }

    private int KSumPath (TreeNode root , int k) {

        ArrayList<Integer> path = new ArrayList<>();

        solve (root , k , path);

        return count;
    }

}
