package Lecture_4;

/*

Delete Node in a BST
Medium
7.6K
196
Companies
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.


Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105

 */

public class Delete_Node_in_BST_3 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Solution {

        public TreeNode deleteNode (TreeNode root , int key) {

                return delete(root , key);
        }

        public TreeNode delete (TreeNode root , int key) {

            if (root == null) {

                return null;
            }

            if (root.val < key) {

                root.right = deleteNode (root.right , key);

            } else if (root.val > key) {

                root.left = deleteNode (root.left , key);

            } else { // Data mill gaya

                // ---> 0 Child or 1 Child Case
                if (root.left == null) {

                    return root.right;

                } else if (root.right == null) {

                    return root.left;

                } else { // 2 Child Case : i.e both the child exists.

                    // Method-1 : Replace node by left kaa max.
                    int lmax = max(root.left); // Jiss Node par khada hain uske left side se Max value laa
                    root.left = deleteNode(root.left, lmax);
                    root.val = lmax;

                    // Method-2 : Replace node by right kaa min.
                }
            }

            return root;
        }

        public int max(TreeNode root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }

            int r = max(root.right);
            return Math.max(root.val, r);

        }
    }
}
