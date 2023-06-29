package Lecture_2.View;

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.

 */

/*

Ancestor 6 and 4 is 5.
Ancestor of 2 and 7 is 2 (A node to be a descendant of itself)
Ancestor of 7 and 8 is 3

p = 6 and q = 4

Step-1 :
Pehle Root se 6 tak kaa path nikaal lo i.e   :  3    5    6
Fir Root se 4 tak kaa path nikaal lo i.e   :  3     5    2   4

Step-2 :
3 and 3 same i.e move
5 and 5 is same i.e move
abb different mill gaya i.e previous is LCS.
ans = 5.


p = 2 and q = 4


Step-1 :
Pehle Root se 2 tak kaa path nikaal lo i.e   :  3    5    2
Fir Root se 4 tak kaa path nikaal lo i.e   :  3     5    2   4

Step-2 :
3 and 3 same i.e move
5 and 5 is same i.e move
2 and 2 same i.e move
abb different mill gaya i.e previous is LCS.
ans = 2.



Agar p ---> left branch main hain i.e 3 ke left main and
q ---> right branch main hain i.e 3 ke right main

then LCS always root node hee hoga.

 */

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

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

        /*

            Dry Run for : p = 2 and q = 8

            3 se check karo kyaa address of 2 == address of 3 hain yaa fir address of 8 == address of 3 hain kya.--> No
            Kya , address of 2 == address of 5 || address of 8 == address of 5. ---> No
            Kya , address of 2 == address of 6 || address of 8 == address of 6. ---> No.
            6.left = nul and 6.right is also null. So, else if condition runs i.e it returns null.

            Abb back ayengye and 5 kaa right chalega i.e 2 and address of 2 == address of 2.
            i.e return 2's address and 5 ke left main thaa null and right main 2's address.
            i.e else if condition runs and return 2's address.

            i.e 3 ke left se ayaa 2's address.

            Now right main se 8 kaa address ayega and jab ham 3 waale function frame main hongye then.

            3 ke left se 2's address and 3 ke right se 8 kaa address i.e if condtion runs as both are not equal to run i.e
            return root i.e 3.

            ans = 3.


         */

        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) {

                return null;
            }

          if (root == p || root == q) {

              return root;
          }

          TreeNode left = LowestCommonAncestor (root.left , p , q);
          TreeNode right = LowestCommonAncestor (root.right , p , q);

            // Jab dono left aur right main kuch address hoga then return root
          if (left != null && right != null) {

              return root;

          } else if (left == null){

              return right;

          } else {

              return left;
          }

        }
    }
}
