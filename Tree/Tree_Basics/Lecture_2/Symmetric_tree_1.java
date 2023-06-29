package Lecture_2;

/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


Example 1:

Symmetric_Tree.png

Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100


 */


import com.sun.source.tree.Tree;

class Symmetric_tree_1 {

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

        public boolean isSysmmetric(TreeNode root) {

            TreeNode leftSubtree = root.left;
            TreeNode rightSubtree = root.right;

            return Symmetric(leftSubtree, rightSubtree);
        }

        public boolean Symmetric(TreeNode root1, TreeNode root2) {
        /*

                           10
                         /    \
                        null  null
         */
            // Agar Dono null hain i.e Tree is symmetric.
            if (root1 == null && root2 == null) {
                return true;
            }

            // Upar waala base case nhi chala matlab paake se ek null nhi hain.
            // So, if One of them is null and another one is not null then tree will not be Symmetric.
            if (root1 == null || root2 == null) {

                return false;
            }

            if (root1.val != root2.val) {

                return false;
            }

        /*


                             1
                           /   \
                          2     2
                        /  \  /   \
                       3   4  4    3

                       First Condition : false
                       Second Condition : false
                       Third Condition : false

                       i.e Level - 1 is satisfying all the Conditions for Tree to be Symmetric.

                       Pass : 2.left , 2.right i.e 3 , 3

                       i.e they call their left and right i.e null ,null return true.



         */

            boolean first_check = Symmetric(root1.left, root2.right);
            boolean second_check = Symmetric(root1.right, root2.left);

            return first_check && second_check;
        }
    }

}

/*

     ----------------------------- Questions that can be solved by the above approach -----------------------------

                  Q-2.

                             1
                          /     \
                         2       2      ---------> Tree-1
                       /  \    /   \
                      3   4    4    3



                             1
                          /     \
                         2       2      ---------> Tree-2
                       /  \    /   \
                      3   4    4    3


                      Check Whether Tree-1 and Tree-2 are symmetric.


                      Tree kaa leftsubtree should be equal to Tree-2 LeftSubtree


                  Q-3 :  Whether Two trees have same structure or not.

                  -------> Above code will remain same but remove the Third if Condition. i.e root1.val != root2.val
                           i.e Values equal ho yaa naa ho but Structure same hona chaiye.


                  Q-4 : Whether Two Trees are equal or not.

                  -----------> Trees Should have same Structure and same values then Trees are equal.




 */