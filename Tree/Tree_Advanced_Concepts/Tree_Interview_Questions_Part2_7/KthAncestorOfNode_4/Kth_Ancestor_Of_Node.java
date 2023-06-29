package Tree_Interview_Questions_Part2_7.KthAncestorOfNode_4;

/*

Given a binary tree of size  N, a node, and a positive integer k.,
Your task is to complete the function kthAncestor(), the function should return
the kth ancestor of the given node in the binary tree.
If there does not exist any such ancestor then return -1.
Note: It is guaranteed that the node exists in the tree.


Example 1:

img

Input:
K = 2
Node = 4

Output: 1
Explanation:
Since, K is 2 and node is 4, so we
first need to locate the node and
look k times its ancestors.
Here in this Case node 4 has 1 as his
2nd Ancestor aka the Root of the tree.


Example 2:

Input:
k=1
node=3
      1
    /   \
    2     3

Output:
1
Explanation:
K=1 and node=3 ,Kth ancestor of node 3 is 1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)



Constraints:
1<=N<=104
1<= K <= 100


 */

import java.util.Scanner;

public class Kth_Ancestor_Of_Node {

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
    public  Kth_Ancestor_Of_Node () {

        this.root = Create_Binary_Tree ();
    }

    private TreeNode Create_Binary_Tree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode (data);

        System.out.println("Left of " + data + " ");
        boolean hasLeftNode = sc.nextBoolean();
        if (hasLeftNode) {

            root.left = Create_Binary_Tree();
        }

        System.out.println("Right of " + data + " ");
        boolean hasRightNode = sc.nextBoolean();
        if (hasRightNode) {

            root.right = Create_Binary_Tree();
        }

        return root;
    }

    // Making 'k' a global variable.
    private int K = 0;

    public int kthAncestor (int k , int node) {

        K = k;
        return kthAncestor(root , node);

    }

    private TreeNode solve (TreeNode root , int node) {

        // Base Case
        if (root == null)
            return null;

        if (root.val == node)
            return root;

        TreeNode leftans = solve (root.left , node);
        TreeNode rightans = solve (root.right , node);

        if (leftans != null && rightans == null) {

            // Decrementing k
            K -= 1;

            // Check
            if (K <= 0) {

                // ans founded so we lock the ans by making k INT_MAX
                // Recursion toh aur possiblility check karega i.e left aur right main aur call bache hongye toh woh bhi
                // lagaayega. Toh ham kya karte hain kii k ko itna bada bana dete hain kii agar further k
                // kam hoga tabb bhi woh dubaare 0 nhi banega. Isse Ye Node locked ho gayi.
                K = Integer.MAX_VALUE; // Jisse kii agar agye k decreament hoga toh woh less than 0 naa ho paaye.
                return root;
            }

            return leftans;

        }

        if (leftans == null && rightans != null) {

            K -= 1;

            if (K <= 0) {

                // ans lock
                K = Integer.MAX_VALUE;
                return root;
            }

            return rightans;
        }

        // If both leftans and rightans are null then simply return null
        return null;
    }

    private int kthAncestor (TreeNode root , int node) {

        TreeNode ans = solve (root , node);

        // Also handle the Imp case.
        // i.e when ans.val == node then also return -1.
        if (ans == null || ans.val == node)
            return -1;

        return ans.val;
    }
}
