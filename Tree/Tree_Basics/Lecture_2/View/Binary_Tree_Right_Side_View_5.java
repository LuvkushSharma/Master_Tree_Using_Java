package Lecture_2.View;

/*

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]


Example 2:

Input: root = [1,null,3]
Output: [1,3]


Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

 */

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Right_Side_View_5 {

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

    /*

       In the given image Pehle Depth = 4 tak list main dal jaayega. i.e 1   3   6   8  11 i.e Visited = 4 ho gaya.

       Now , move to the left subtree and usme 7 tak depth same hoga toh usse add nhi karengye list main.
       After , 7 in the leftsubtree depth increases i.e 9 and 10 will be added in the list.


     */

    public class Solution {

        int visited = -1; // -------> Depth

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> ll = new ArrayList<>();
            view (root , 0 , ll);

            return ll;
        }

        public void view (TreeNode root , int curr , List<Integer> ll) {

            if (root == null) {
                return;
            }

            if (curr > visited) {
                ll.add(root.val);
                visited = curr;
            }

            view (root.right , curr + 1 , ll);
            view (root.left , curr + 1 , ll);

        }
    }
}
